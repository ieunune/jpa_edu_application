package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {

//		롬복 적용 확인
//		Hello hello = new Hello();
//		hello.setData("Hello");
//		System.out.println(" get : " + hello.getData());

		SpringApplication.run(JpashopApplication.class, args);
	}

}
