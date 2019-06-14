package com.tyss.junitmain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JunitTest {
   @Test
	public void testFindMax() {
		assertEquals(4, Calculate.findMax(new int[] {1,3,4,2,}));
		//assertEquals(-1, Calculate.findMax(new int[] {-1,-3,2,7}));
	}
}

