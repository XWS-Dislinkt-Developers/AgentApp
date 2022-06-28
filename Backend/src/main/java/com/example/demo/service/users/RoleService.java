package com.example.demo.service.users;

import com.example.demo.model.users.Role;
import com.example.demo.repository.users.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository=roleRepository;
    }

    public Role save(Role role) { return this.roleRepository.save(role);}

    public Role findByName(String name){ return this.roleRepository.findByName(name);}

}
