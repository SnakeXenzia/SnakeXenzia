import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

public class testGame {

	@Test
	public void test1() {
		Snake snake = new Snake();
		assertTrue(snake.toaDoCoNamTrongThanRan(5, 4));
	}
	
	@Test
	public void test2() {
		Snake snake = new Snake();
		assertTrue(snake.toaDoCoNamTrongThanRan(5, 3));
	}

	@Test
	public void test3() {
		Snake snake = new Snake();
		assertTrue(snake.toaDoCoNamTrongThanRan(5, 2));
	}
	
	@Test
	public void test6() {
		Snake snake = new Snake();
		assertTrue(snake.toaDoCoNamTrongThanRan(3, 2));
	}

	@Test
	public void test4() {
		Snake s = new Snake();
		Point p = new Point(5, 10);
		assertEquals(s.layToaDoMoi(), p);
	}
	
	@Test
	public void test5() {
		Snake s = new Snake();
		Point p = new Point(6, 10);
		assertEquals(s.layToaDoMoi(), p);
	}


	

}

