package me.ffs.www.control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import tk.mybatis.spring.annotation.MapperScan;


/**
 * @author: 456
 * @date: 2018/3/6
 *
 */
@MapperScan(basePackages = "me.ffs.www.dao.mapper")
@ComponentScan(basePackages={"me.ffs"})
@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);

	}
}
