package testpackage.algo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.tns.dsa.algo.FileFinder;
import com.tns.dsa.algo.exceptionForFiles.TargetDirNotFoundException;

class FileFinderTest {
	
	FileFinder finder = new FileFinder();
	
	@Test
	void testEdgeCaseNoDir() {
		var dir = "C:/Users/hp/Desktop/Test3";
		var file = "t1.txt";
		assertThrowsExactly(TargetDirNotFoundException.class, () -> finder.findFile(dir,  file));
	}
	
	@Test
	void testEdgeCaseNoFileFound() {
		var dir = "C:/Users/hp/Desktop/Test1";
		var file = "t11.txt";
		var list = finder.findFile(dir, file);
		assertEquals(0, list.size());
	}
	
	@Test
	void test() {
		var dir = "C:\\Users\\hp\\Desktop\\Test1";
		var file = "t1.txt";
		
		var list = finder.findFile(dir, file);
//		for(var l : list) {
//			System.out.println(l);
//		}
		assertEquals(3, list.size());
		assertEquals("C:/Users/hp/Desktop/Test1/t1.txt", list.get(0));
		assertEquals("C:/Users/hp/Desktop/Test1/Test2/t1.txt", list.get(1));
		assertEquals("C:/Users/hp/Desktop/Test1/Test2/Test3/Test4/t1.txt", list.get(2));
	}
	
	@Test
	void testComplex() {
		var dir = "C:/Users/hp/Desktop/TNS";
		var file = "Screenshot (13443).png";
		
		var list = finder.findFile(dir, file);
//		for(var l : list) {
//			System.out.println(l);
//		}
		assertEquals(1, list.size());
		assertEquals(finder.replaceBlackSlash("C:\\Users\\hp\\Desktop\\TNS\\Programming\\Java basic\\errorAndSolutionSS\\StringReplace\\Screenshot (13443).png"), list.get(0));
		
	}
	
	@Test
	void testNotGiveFullFileName() {
		var dir = "C:\\Users\\hp\\Desktop\\Test1";
		var file = "t.txt";
		
		var list = finder.findFile(dir, file);
		for(var l : list) {
			System.out.println(l);
		}
		assertEquals(6, list.size());
	}
	
	@Test()
	void extendingAndNameSeparatorTestEdgeCase() {
		var file = "Test1/t1.txt";
		var exception = assertThrows(IllegalArgumentException.class, () -> finder.extentionAndFileNameSeparator(file));
		System.out.println(exception.getMessage());
	}
	
	@Test()
	void extendingAndNameSeparatorTestEdgeCase2() {
		var file = "Test1\\t1.txt";
		var exception = assertThrows(IllegalArgumentException.class, () -> finder.extentionAndFileNameSeparator(file));
		System.out.println(exception.getMessage());
	}
	
	@Test()
	void extendingAndNameSeparatorTestEdgeCase3() {
		var file = "t1?.txt";
		var exception = assertThrows(IllegalArgumentException.class, () -> finder.extentionAndFileNameSeparator(file));
		System.out.println(exception.getMessage());
	}
	
	@Test
	void extendingAndNameSeparatorTest() {
		var file = "t1.txt";
		var arr = finder.extentionAndFileNameSeparator(file);
		assertEquals("t1", arr[0]);
		assertEquals("txt", arr[1]);
	}

}
