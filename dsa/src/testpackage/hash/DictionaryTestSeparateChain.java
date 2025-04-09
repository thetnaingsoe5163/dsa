package testpackage.hash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.tns.dsa.hash.Dictionary;
import com.tns.dsa.hash.impl.SeparateChain;

class DictionaryTestSeparateChain {

static Dictionary<String, String> d = new SeparateChain<String, String>(10);
	
	@ParameterizedTest
	@CsvSource(value = {
			"How are you\tI am fine, thank you.\t1",
			"Hi\tHello\t2",
			"How old are you\tI am just a child.\t3",
			"Do you like movie\tYes I like it.\t4",
			"Do you like ice cream\tThis is not my choice\t5",
			"Where do you live\tIn your heart.\t6",
			"What is your name\tMr Bot.\t7",
			"Which color do you like\tI like blue.\t8",
			"Bye!\tBye Bye, Thank you.\t9",
			"Take care!\tThank you.\t10",	
	}, delimiter = '\t')
	void testRegister(String question, String answer) {
		int size = d.getSize();
		d.register(question, answer);
		assertEquals(size + 1, d.getSize());
	}
	
	@ParameterizedTest
	@CsvSource(value = {
			"How are you\tI am fine, thank you.\t1",
			"Hi\tHello\t2",
			"How old are you\tI am just a child.\t3",
			"Do you like movie\tYes I like it.\t4",
			"Do you like ice cream\tThis is not my choice\t5",
			"Where do you live\tIn your heart.\t6",
			"What is your name\tMr Bot.\t7",
			"Which color do you like\tI like blue.\t8",
			"Bye!\tBye Bye, Thank you.\t9",
			"Take care!\tThank you.\t10",	
	}, delimiter = '\t')
	void testSearch(String question, String answer) {
		assertEquals(answer, (String)d.search(question));
		assertEquals(10, d.getSize());
	}

}
