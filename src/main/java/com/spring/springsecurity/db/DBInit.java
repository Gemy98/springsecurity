package com.spring.springsecurity.db;

import com.spring.springsecurity.dao.AuthoritiesRepository;
import com.spring.springsecurity.dao.UserRepository;
import com.spring.springsecurity.model.Authorities;
import com.spring.springsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DBInit implements CommandLineRunner {


    private UserRepository userRepository ;

    private AuthoritiesRepository authoritiesRepository ;

    @Autowired
    public DBInit(UserRepository userRepository , AuthoritiesRepository authoritiesRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private PasswordEncoder passwordEncoder ;




    @Override
    public void run(String... args) throws Exception {

/*

        this.userRepository.deleteAll();
            User admin=new User("Gemy",passwordEncoder.encode("123"),"25","Mansoura",1);
            admin.setAuthorities(this.authoritiesRepository.findAll());
            userRepository.save(admin);
        ///////////////////////////////////////////////////////////////////
            User Manager=new User("ahmed",passwordEncoder.encode("123"),"25","Cairo",1);
            List<Authorities> authoritiesManager = new ArrayList<>();
            authoritiesManager.add(authoritiesRepository.findById(2L).get());
            authoritiesManager.add(authoritiesRepository.findById(3L).get());
            authoritiesManager.add(authoritiesRepository.findById(5L).get());
            authoritiesManager.add(authoritiesRepository.findById(6L).get());
            Manager.setAuthorities(authoritiesManager);
            userRepository.save(Manager);
        ////////////////////////////////////////////////////////////////////////////////
            User user=new User("Karim",passwordEncoder.encode("123"),"25","Tanta",1);
            List<Authorities> authoritiesUser = new ArrayList<>();
            authoritiesUser.add(authoritiesRepository.findById(3L).get());
            authoritiesUser.add(authoritiesRepository.findById(6L).get());
            user.setAuthorities(authoritiesUser);
            userRepository.save(user);
*/
    }


}
