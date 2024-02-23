/*
 * Copyright 2022 Bloomreach
 */
package at.secure.ftp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SftpServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SftpServerApplication.class, args);
		while (true);
	}
}
