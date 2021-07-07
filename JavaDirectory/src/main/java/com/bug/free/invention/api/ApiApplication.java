package com.bug.free.invention.api;

import com.bug.free.invention.api.db.DataAccess;
import com.bug.free.invention.api.db.Mapper;
import com.bug.free.invention.api.models.Capabilities;
import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		DataAccess db = new DataAccess();
		SqlSession session = db.access();

		try {
			Mapper mapper = session.getMapper(Mapper.class);
			List<Capabilities> caps = mapper.getCapabilities();
			System.out.println(caps);
		}
		finally {
			session.close();
		}
	}

}
