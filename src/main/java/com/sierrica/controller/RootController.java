package com.sierrica.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;


@Controller
@ApiIgnore
@PropertySource("classpath:application.properties")
public class RootController {

	//@Autowired
	//private UserRepository userRepository;

	@Value("${spring.profiles.active}")
	private String env;

	//@CrossOrigin
    @RequestMapping("/")
    
    public String index() {
    	//userRepository.save(new User("sierrica2", "tauste"));


    	//return env.equals("windows")  ?  "index_dev.html"  : "index.html";
         	return "index.html";
         }
}
