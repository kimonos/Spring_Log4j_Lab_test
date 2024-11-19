package com.gss.demo.controller;

import com.gss.demo.enity.User;
import com.gss.demo.repository.userRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

@RestController
@Scope(value = "prototype")
public class log4jController {
    
    @Autowired
    private userRepository userRepository;

    private Logger log = LogManager.getLogger(log4jController.class);

//     @GetMapping("/user/{id}")
//     public List<Object[]> findUserFromId(@PathVariable("id") String id){
// //        System.out.println(id);
//         return userRepository.findUserByIdUnsafe(id);
//     }

    @PostMapping("/login")
    public String login(@RequestBody Map req) {

        //-Dcom.sun.jndi.ldap.object.trustURLCodebase=true
        String name = req.get("user").toString();
        String password = req.get("password").toString();

        List<Object[]> user = userRepository.findUserByNamePassword(name,password);
        if(user.size() == 0){
            log.error("user:{},password:{}", user, password);
            return "Fail to Login";
        }
        
        return "Login, welcome!";
        
    }
}
