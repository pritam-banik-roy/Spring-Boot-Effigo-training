package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAsserTest {
	
	List<String> todos = Arrays.asList("AWS", "Azure", "DevOps"); 

	@Test
	void test() {
		boolean test = todos.contains("AWS"); //Result
		boolean test2 = todos.contains("GCP"); //Result
		
		//assertEquals(true, test);
		assertTrue(test);
		assertFalse(test2);
		//asserNull,assertNotNull
		
		assertArrayEquals(new int[] {1,2}, new int[] {1,2});
		
		assertEquals(3, todos.size());
		
	}

}
