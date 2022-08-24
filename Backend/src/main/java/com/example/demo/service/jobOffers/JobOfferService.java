package com.example.demo.service.jobOffers;

import com.example.demo.dto.jobOffers.CreateJobOfferOnDislinktDto;
import com.example.demo.model.companies.Company;
import com.example.demo.model.jobOffers.JobOffer;
import com.example.demo.model.users.User;
import com.example.demo.repository.companies.CompanyRepository;
import com.example.demo.repository.jobOffers.JobOfferRepository;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.TrustStrategy;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;

@Service
public class JobOfferService {

    private JobOfferRepository jobOfferRepository;
    private CompanyRepository companyRepository;
    private final RestTemplate restTemplate;

    public JobOfferService(JobOfferRepository jobOfferRepository, CompanyRepository companyRepository, RestTemplateBuilder restTemplateBuilder){
        this.jobOfferRepository = jobOfferRepository;
        this.companyRepository = companyRepository;
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<JobOffer> getAll(){
        return this.jobOfferRepository.findAll();
    }

    public List<JobOffer> getJobOffersForCompany(int id){
        return this.jobOfferRepository.getJobOffersForCompany(id);
    }

    public void save(JobOffer jobOffer, User user) {
        Company company = this.companyRepository.findByOwner(user.getEmail());
        jobOffer.setCompany(company);
        this.jobOfferRepository.save(jobOffer);
        if (jobOffer.getPromoteOnDislinkt()){
            promoteJobOfferOnDislinkt(user.getApiToken(), jobOffer, company);
        }
    }

    private void promoteJobOfferOnDislinkt(String apiToken, JobOffer jobOffer, Company company) {
        HttpComponentsClientHttpRequestFactory requestFactory = prepareRequestFactory();
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        String url = "https://localhost:8000/postJobCompany";
        HttpHeaders headers = new HttpHeaders();

        CreateJobOfferOnDislinktDto dto = new CreateJobOfferOnDislinktDto();
        dto.setCompany(company.getName());
        dto.setToken(apiToken);
        dto.setExperienceLevel(jobOffer.getLevelOfExperience().toString());
        dto.setPosition(jobOffer.getPosition());
        dto.setDescription(jobOffer.getJobDescription());
        dto.setRequirements(jobOffer.getRequirements());

        final HttpEntity<CreateJobOfferOnDislinktDto> entity = new HttpEntity<CreateJobOfferOnDislinktDto>(dto, headers);
        ResponseEntity<String> ret = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        System.out.println(ret.getStatusCode());
        System.out.println(ret);
    }

    private HttpComponentsClientHttpRequestFactory prepareRequestFactory() {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
        SSLContext sslContext = null;
        try {
            sslContext = org.apache.http.ssl.SSLContexts.custom()
                    .loadTrustMaterial(null, acceptingTrustStrategy)
                    .build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);
        return requestFactory;
    }


    public List<JobOffer> search(String param){
        return this.jobOfferRepository.searchJobOffers("%"+param+"%");
    }

    public List<JobOffer> getJobOffersWithCompany(){
        return this.jobOfferRepository.getJobOffersWithCompany();
    }

}
