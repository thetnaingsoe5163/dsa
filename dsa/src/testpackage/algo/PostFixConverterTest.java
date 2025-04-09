package testpackage.algo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tns.dsa.algo.PostFixConverter;

class PostFixConverterTest {

	@Test
	void test() {
		PostFixConverter postfix = new PostFixConverter();

		Assertions.assertEquals("ab+", postfix.convert("a+b"));

		Assertions.assertEquals("abc*+", postfix.convert("a+b*c"));

		Assertions.assertEquals("abcd^*+e-", postfix.convert("a+b*c^d-e"));
		
		Assertions.assertEquals("ab*cd/+e-", postfix.convert("a*b+c/d-e"));
		
		Assertions.assertEquals("abc+*", postfix.convert("a*(b+c)"));
		
		Assertions.assertEquals("abc*d+e/+", postfix.convert("a+(b*c+d)/e"));
		
		Assertions.assertEquals("ab+cd-*ef*gh+^/", postfix.convert("(a+b)*(c-d)/(e*f)^(g+h)"));
		
		Assertions.assertEquals("ab+c*de/-fgh*-^", postfix.convert("((a+b)*c-(d/e))^(f-(g*h))"));
		
		Assertions.assertEquals("abc*+def-^g^/h*", postfix.convert("(a+b*c)/d^(e-f)^g*h"));
		
		Assertions.assertEquals("ab*cd/+ef-g/*hi+jk/l-*-", postfix.convert("(((a*b)+(c/d))*((e-f)/g))-((h+i)*((j/k)-l))"));
		
		Assertions.assertEquals("ab+cd/*ef-gh+*-ij*klm+/-/", postfix.convert("(((a+b)*(c/d))-((e-f)*(g+h)))/((i*j)-(k/(l+m)))"));
		
		Assertions.assertEquals("ab+c*de/-fgh*-ij/+^kl*m-n/op+*+qrs+tu-**vw+/xy-*-z+", postfix.convert("((a+b)*c-(d/e))^(f-(g*h)+(i/j))+((k*l)-m)/n*(o+p)-q*((r+s)*(t-u))/(v+w)*(x-y)+z"));
	}

}
