package com.cognizant.collector.rally;

import com.ulisesbocchio.jasyptspringboot.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.scheduling.annotation.*;

@EnableFeignClients
@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
@EnableEncryptableProperties
public class RallyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RallyApplication.class, args);
	}

}
