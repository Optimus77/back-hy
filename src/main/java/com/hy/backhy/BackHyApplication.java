package com.hy.backhy;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hy.backhy.entity.Phone;
import com.hy.backhy.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class BackHyApplication {

	@Value("${index}")
	private String index;

	@Autowired
	private PhoneRepository Repo;

	@RequestMapping("/${Phones&Accessories}")
	ResponseEntity pa(){
		JSONObject data=new JSONObject();
		JSONArray pas=new JSONArray();
		List<Phone> phoneList= Repo.getPhoneList();

		for(Phone p:phoneList){
			pas.add(p);
		}

		data.put("pas",pas);
		data.put("totalPages","1");
		data.put("totalElements","2");

		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	public static void main(String[] args) {
		SpringApplication.run(BackHyApplication.class, args);
	}
}
