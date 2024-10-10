package ru.gb.danila.tablo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TabloApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TabloApplication.class, args);

		Tablo tablo = context.getBean(Tablo.class);
		tablo.run();
	}

}
