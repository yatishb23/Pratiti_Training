package com.yatish.optional;

import java.util.Optional;

public class OptionalDemo {
	public static void main(String[] args) {
		Optional<String> optional= Optional.of("Yatish");
		optional=Optional.ofNullable("Yatish");
		if(optional.isPresent()) {
			System.out.println(optional.get());
		}
		else {
			System.out.println("Optional is empty");
		}
	}
}
