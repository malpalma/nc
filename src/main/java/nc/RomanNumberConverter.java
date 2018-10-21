package nc;

import java.util.HashMap;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class RomanNumberConverter {
	private BidiMap<Character, Integer> numerals;
	
	public RomanNumberConverter() {
//		numerals = new HashMap<Character, Integer>();
		numerals = new DualHashBidiMap<Character, Integer>();
		numerals.put('I', 1);
		numerals.put('V', 5);
		numerals.put('X', 10);
		numerals.put('L', 50);
		numerals.put('C', 100);
		numerals.put('D', 500);
		numerals.put('M', 1000);
	}
	
//	from Roman to Integer
//	result value: intVal, -1 in case of error
//	processing roman value from it's beginning to the end
	public Integer convertRomanToInteger(String roman) {
		if(roman.isEmpty()) {
			return -1;
		} else {
			Integer intVal = 0, temp = 0, chVal = 0;
			StringBuilder sbVal = new StringBuilder(roman);
			char ch, prev = '?';
			while(sbVal.length() > 0) {
				ch = sbVal.charAt(0);
				sbVal.deleteCharAt(0);
	// is character correct?
				if(numerals.containsKey(ch)) {
					chVal = numerals.get(ch);
	// first character, only add to the temp value
					if(prev == '?') {
						temp += chVal;
	// next character
					} else {
	// if current character is the same as previous, then check if it is correct roman value, and then add to the temp value
						if(ch == prev) {
	// if current character is V, L or D then roman value is incorrect (V, L, D can not stand next to each other)
							if((ch == 'V') || (ch == 'L') || (ch == 'D')) {
								temp = 0;
								intVal = -1;
								break;
							} else {
	// other characters - there can be max. 3 next to each other
								if(temp < (3 * chVal)) {
									temp += chVal;
								} else {
									temp = 0;
									intVal = -1;
									break;
								}
							}
	// if current character is not the same as previous
						} else {
	// if current character is greater then previous -> the result of (current value - temp value) add to the integer value, and then reset temp value
							if(chVal > numerals.get(prev)) {
								temp = chVal - temp;
								intVal += temp;
								temp = 0;
	// if current character is less then previous - temp value add to the integer value and now current character value is temp value
							} else {
								intVal += temp;
								temp = chVal;
							}
						}
					}
	// incorrect character
				} else {
					temp = 0;
					intVal = -1;
					break;
				}
				prev = ch;
			}
	// at the end temp value add to the integer value
			intVal +=temp;
			return intVal;
		}
	}

//	from Integer to Roman, min. value 1, max. value 3999
//	result value: romanVal (String); in case of error: empty string
//	processing integer value from it's end to beginning
//	example: 123
//	1st loop circuit: temp = 123, partial = 3; multiplier = 1
//	2nd: temp = 12, partial = 20, multiplier = 10
//	3rd: temp = 1, partial = 100, multiplier = 100
	public String convertIntegerToRoman(Integer intVal) {
		String romanVal = "";
		if(intVal > 0 && intVal < 4000) {
			Integer temp = intVal, partial, multiplier = 1;
// current roman character
			Character tempCh;
// how many times to repeat the same roman character
			Integer repeat;
// temporary integer value in calculating 1-5 or 1-10
			Integer tempInt;
			while(temp > 0) {
				partial = (temp % 10) * multiplier;
//				System.out.println("temp: " + temp);
//				System.out.println("partial: " + partial);
//				System.out.println("multiplier: " + multiplier);
				try {
// if there is roman character with exactly this value
					if(numerals.containsValue(partial)) {
						romanVal = numerals.getKey(partial).toString().concat(romanVal);
// otherwise
					} else {
						repeat = partial / multiplier; 
// if there are 2 or 3 the same characters next to each other (2 * multiplier or 3 * multiplier)
						if(repeat <= 3) {
							tempCh = numerals.getKey(multiplier);
							for(int i = 1; i <= repeat; i++) {
								romanVal = tempCh.toString().concat(romanVal);
							}
// if 1 - 5
						} else if(repeat == 4) {
							tempInt = multiplier * 5;
							tempCh = numerals.getKey(tempInt);
							romanVal = tempCh.toString().concat(romanVal);
							tempInt = multiplier;
							tempCh = numerals.getKey(tempInt);
							romanVal = tempCh.toString().concat(romanVal);
// if 5 + (1 or 2 or 3)
						} else if(repeat <= 8) {
							tempCh = numerals.getKey(multiplier);
							for(int i = 6; i <= repeat; i++) {
								romanVal = tempCh.toString().concat(romanVal);
							}
							tempCh = numerals.getKey(multiplier * 5);
							romanVal = tempCh.toString().concat(romanVal);
// 1 - 10
						} else {
							tempCh = numerals.getKey(multiplier * 10);
							romanVal = tempCh.toString().concat(romanVal);
							tempCh = numerals.getKey(multiplier);
							romanVal = tempCh.toString().concat(romanVal);
						}
					}
				} catch(ClassCastException e) {
					romanVal = "";
					break;
				}
				temp = temp / 10;
				multiplier *= 10;
			}
		}
		return romanVal;
	}
}
