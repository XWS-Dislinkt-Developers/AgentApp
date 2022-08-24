package com.example.demo.service.users;

import com.example.demo.dto.users.UserRequest;
import com.example.demo.dto.users.UserUpdateDTO;
import com.example.demo.model.users.Role;

import com.example.demo.model.users.Address;
import com.example.demo.model.users.User;
import com.example.demo.repository.users.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService; 
    private AddressService addressService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AddressService addressService, RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.addressService = addressService;
        this.roleService = roleService;
    }

    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User save(UserRequest user){
        User u = new User();

        Role role = roleService.findByName(user.getRole());
        if (role == null) {
            role = new Role(user.getRole());
            roleService.save(role);
        }
        u.setRole(role);

        u.setPassword(passwordEncoder.encode(user.getPassword()));
        u.setName(user.getName());
        u.setSurname(user.getSurname());
        u.setTelephone(user.getTelephone());
        u.setEmail(user.getEmail());
        u.setEnabled(true);
        u.setAddress(addressService.save(new Address(user.getCountry(), user.getCity(), user.getStreet(), user.getNumber())));
        this.userRepository.save(u);
        return u;
    }

    public User setUserToCompanyOwner(User companyOwner) {
        Role role = roleService.findByName("ROLE_COMPANY_OWNER");
        if (role == null) {
            role = new Role("ROLE_COMPANY_OWNER");
            roleService.save(role);
        }
        companyOwner.setRole(role);
        return this.userRepository.save(companyOwner);
    }

    public void update(UserUpdateDTO updatedUser) {
        User user = this.userRepository.findById(updatedUser.getId());
        user.setName(updatedUser.getName());
        user.setSurname(updatedUser.getSurname());
        user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        user.setAddress(updatedUser.getAddress());
        user.setTelephone(updatedUser.getTelephone());
        this.userRepository.save(user);
    }

    public void addToken(String token, User loggedUser) {
        User user = this.userRepository.findById(loggedUser.getId());
        user.setApiToken(token);
        this.userRepository.save(user);
    }
}
