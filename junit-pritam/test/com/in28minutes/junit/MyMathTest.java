package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {
	
	private MyMath math = new MyMath();

	@Test
	void CalculateSum_ThreeMemberArray() {
		assertEquals(6, math.calculateSum(new int[] {1,2,3}));
		
		//Test condition or Assert
		
		
		}
	
	@Test
	void CalculateSum_ZeroLengthArray() {
		assertEquals(0, math.calculateSum(new int[] {}));
	}

}
