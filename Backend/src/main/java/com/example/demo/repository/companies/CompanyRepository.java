package com.example.demo.repository.companies;

import com.example.demo.model.companies.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query(value = "select c from Company c join fetch c.offices o where c.id = ?1 ")
    Company getCompany(int id);
    @Query(value = "select distinct c from Company c join fetch c.offices o where c.name = ?1 ")
    List<Company> getCompanies(String name);
    @Query(value = "select distinct c from Company c join fetch c.offices o where c.name = ?1 or o = ?1")
    List<Company> getCompaniesFullSearch(String name);
    @Query(value = "select distinct c from Company c join fetch c.offices o")
    List<Company> findAll();
    @Query(value = "select distinct c from Company c join fetch c.companyOwner o where o.email = ?1")
    Company findByOwner(String email);
}
