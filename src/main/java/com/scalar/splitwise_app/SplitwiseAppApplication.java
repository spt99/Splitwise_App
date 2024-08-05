package com.scalar.splitwise_app;

import com.scalar.splitwise_app.commands.CommandExcecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseAppApplication implements CommandLineRunner {
	private CommandExcecutor commandExcecutor;
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseAppApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		while(true)
		{
			String input = scanner.next();
			commandExcecutor.execute(input);


		}

	}

}
