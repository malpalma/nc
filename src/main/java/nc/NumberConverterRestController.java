package nc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberConverterRestController {

	@GetMapping(value = "/Roman2Int/{roman}")
	public Integer convertRomanToInteger(@PathVariable String roman, HttpServletRequest req, HttpServletResponse resp) {
		Integer ret;
		RomanNumberConverter rnc = new RomanNumberConverter();
		ret = rnc.convertRomanToInteger(roman);
		return ret;
	}
	
	@GetMapping(value = "Int2Roman/{intVal}")
	public String convertIntegerToRoman(@PathVariable Integer intVal, HttpServletRequest req, HttpServletResponse resp) {
		String ret;
		RomanNumberConverter rnc = new RomanNumberConverter();
		ret = rnc.convertIntegerToRoman(intVal);
		return ret;
	}
}
