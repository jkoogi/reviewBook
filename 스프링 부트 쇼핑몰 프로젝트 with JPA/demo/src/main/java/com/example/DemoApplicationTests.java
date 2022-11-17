package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoApplicationTests {

	@GetMapping(value = "/test")
	public UserDto test() {
		UserDto userDto = new UserDto();
		userDto.setAge(20);
		userDto. setName("hoon");

		return userDto;
	}


}
