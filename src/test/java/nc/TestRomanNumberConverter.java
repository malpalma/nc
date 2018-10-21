//package nc;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//public class TestRomanNumberConverter {
//
//	@Test
//	public void testConvert_empty_should_be_error() {
//		String roman = "";
//		Integer expected = -1;
//		RomanNumberConverter rnc = new RomanNumberConverter();
//		Integer result = rnc.convertRomanToInteger(roman);
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testConvert_I_should_be_1() {
//		String roman = "I";
//		Integer expected = 1;
//		RomanNumberConverter rnc = new RomanNumberConverter();
//		Integer result = rnc.convertRomanToInteger(roman);
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testConvert_III_should_be_3() {
//		String roman = "III";
//		Integer expected = 3;
//		RomanNumberConverter rnc = new RomanNumberConverter();
//		Integer result = rnc.convertRomanToInteger(roman);
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testConvert_IIII_should_be_error() {
//		String roman = "IIII";
//		Integer expected = -1;
//		RomanNumberConverter rnc = new RomanNumberConverter();
//		Integer result = rnc.convertRomanToInteger(roman);
//		assertEquals(expected, result);
//	}
//	
//	@Test
//	public void testConvert_XXI_should_be_21() {
//		String roman = "XXI";
//		Integer expected = 21;
//		RomanNumberConverter rnc = new RomanNumberConverter();
//		Integer result = rnc.convertRomanToInteger(roman);
//		assertEquals(expected, result);
//	}
//	
//	@Test
//	public void testConvert_MMMCMXCIX_should_be_3999() {
//		String roman = "MMMCMXCIX";
//		Integer expected = 3999;
//		RomanNumberConverter rnc = new RomanNumberConverter();
//		Integer result = rnc.convertRomanToInteger(roman);
//		assertEquals(expected, result);
//	}
//	
//	@Test
//	public void testConvert_MMMM_should_be_error() {
//		String roman = "MMMM";
//		Integer expected = -1;
//		RomanNumberConverter rnc = new RomanNumberConverter();
//		Integer result = rnc.convertRomanToInteger(roman);
//		assertEquals(expected, result);
//	}
//	
//	@Test
//	public void testConvert_0_should_be_error() {
//		Integer intVal = 0;
//		String expected = "";
//		RomanNumberConverter rnc = new RomanNumberConverter();
//		String result = rnc.convertIntegerToRoman(intVal);
//		assertEquals(expected, result);
//	}
//	
// 	@Test
//	public void testConvert_123_should_be_CXXIII() {
//		Integer intVal = 123;
//		String expected = "CXXIII";
//		RomanNumberConverter rnc = new RomanNumberConverter();
//		String result = rnc.convertIntegerToRoman(intVal);
//		assertEquals(expected, result);
//	}
// 	
// 	@Test
//	public void testConvert_794_should_be_DCCXCIV() {
//		Integer intVal = 794;
//		String expected = "DCCXCIV";
//		RomanNumberConverter rnc = new RomanNumberConverter();
//		String result = rnc.convertIntegerToRoman(intVal);
//		assertEquals(expected, result);
//	}
// 	
// 	@Test
// 	public void testConvert_4000_should_be_error() {
// 		Integer intVal = 4000;
// 		String expected = "";
// 		RomanNumberConverter rnc = new RomanNumberConverter();
// 		String result = rnc.convertIntegerToRoman(intVal);
// 		assertEquals(expected, result);
// 	}
// 	
// 	@Test
// 	public void testConvert_3999_should_be_MMMCMXCIX() {
// 		Integer intVal = 3999;
// 		String expected = "MMMCMXCIX";
// 		RomanNumberConverter rnc = new RomanNumberConverter();
// 		String result = rnc.convertIntegerToRoman(intVal);
// 		assertEquals(expected, result);
// 	}
//}
