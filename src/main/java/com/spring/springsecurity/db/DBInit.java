package com.spring.springsecurity.db;

import com.spring.springsecurity.dao.AuthoritiesRepository;
import com.spring.springsecurity.dao.RoleRepository;
import com.spring.springsecurity.dao.UserRepository;
import com.spring.springsecurity.model.Authorities;
import com.spring.springsecurity.model.Role;
import com.spring.springsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class DBInit implements CommandLineRunner {


    private UserRepository userRepository ;
    private RoleRepository roleRepository ;

    private AuthoritiesRepository authoritiesRepository ;

    @Autowired
    public DBInit(UserRepository userRepository, RoleRepository roleRepository, AuthoritiesRepository authoritiesRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.authoritiesRepository = authoritiesRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        this.userRepository.deleteAll();
            User admin=new User("Gemy","123","25","Mansoura",1);
            admin.setRoles(this.roleRepository.findAll());
            admin.setAuthorities(this.authoritiesRepository.findAll());
            userRepository.save(admin);
        ///////////////////////////////////////////////////////////////////
            User Manager=new User("ahmed","123","25","Cairo",1);
            //Role managerRoles1 = roleRepository.findById(2L).get();
            //Role managerRoles2 = roleRepository.findById(2L).get();
            //Manager.setRoles(this.roleRepository.findById(2L).;
            //Authorities managerAuthorities = authoritiesRepository.findById(2L).get();
            //Manager.setAuthorities(this.authoritiesRepository.findAll());
            //Manager.getRoles().add(managerRoles);
            //Manager.getAuthorities().add(managerAuthorities);
            List<Role> rolesManager =new ArrayList<>() ;
            rolesManager.add(roleRepository.findById(2L).get());
            rolesManager.add(roleRepository.findById(3L).get());
            List<Authorities> authoritiesManager = new ArrayList<>();
            authoritiesManager.add(authoritiesRepository.findById(2L).get());
            authoritiesManager.add(authoritiesRepository.findById(3L).get());
            Manager.setRoles(rolesManager);
            Manager.setAuthorities(authoritiesManager);
            userRepository.save(Manager);
        ////////////////////////////////////////////////////////////////////////////////
            User user=new User("Karim","123","25","Tanta",1);
            //Role userRole = roleRepository.findById(3L).get();
            //user.setRoles(this.roleRepository.findAll());
            //Authorities userAuthorities = authoritiesRepository.findById(3L).get();
            //user.setAuthorities(this.authoritiesRepository.findAll());
            //user.getRoles().add(rolesUser);
            //user.getAuthorities().add(authoritiesUser);
            List<Role> rolesUser = new ArrayList<>();
            rolesUser.add(roleRepository.findById(3L).get());
            List<Authorities> authoritiesUser = new ArrayList<>();
            authoritiesUser.add(authoritiesRepository.findById(3L).get());
            user.setRoles(rolesUser);
            user.setAuthorities(authoritiesUser);
            userRepository.save(user);

    }


}
