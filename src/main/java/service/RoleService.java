package service;

import entity.Role;
import repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public void create(Role role){
        roleRepository.save(role);
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public Role find(Long id){
        return roleRepository.getOne(id);
    }

    public void delete(Long id){ roleRepository.deleteById(id); }

}

