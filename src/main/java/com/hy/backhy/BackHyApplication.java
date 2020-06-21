package com.hy.backhy;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hy.backhy.Impl.StuInvocationHandler;
import com.hy.backhy.Impl.Student;
import com.hy.backhy.entity.PC;
import com.hy.backhy.entity.Testbean;
import com.hy.backhy.repository.PcRepository;
import com.hy.backhy.repository.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.Executors;

@SpringBootApplication

public class BackHyApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(BackHyApplication.class, args);

	}
}
