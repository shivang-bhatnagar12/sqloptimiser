package com.shivang.sqloptimiser;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shivang.sqloptimiser.engine.RuleEngine;
import com.shivang.sqloptimiser.rules.SelectStarRule;


@SpringBootApplication
public class SqloptimiserApplication {

	public static void main(String[] args) {

		RuleEngine engine = new RuleEngine(List.of(new SelectStarRule()));

		System.out.println(engine.analyse("Select * from users"));
		
		SpringApplication.run(SqloptimiserApplication.class, args);
	}

}
