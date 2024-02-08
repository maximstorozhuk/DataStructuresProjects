import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.*
;
class WildTest {

	static Wild w;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		w = new Wild();
		
		
		
	}

	@Test
	void genTest() {
		w = new Wild();
		boolean check = true;
		for(int i = 0; i < w.MAXX; i++) {
			for(int j = 0; j < w.MAXY; j++) {
				if(!(w.model[i][j] instanceof Deer || w.model[i][j] instanceof Wolf)) 
				check = false;
			}
		}
		assertTrue(check);
	}
	
	@Test
	void getMoveTest() {
		w = new Wild();
		Cell c = w.getMove(w.model[0][0]);
		assertTrue(c.x == 1 && c.y == 0 || c.x == 0 && c.y == 1);
	}
	
	@Test
	void attemptMoveTestToEmpty() {
		w = new Wild();
		w.model[0][0] = new Wolf(0, 0);
		w.model[0][1] = new Empty();
		w.model[0][0].nextPosX = 0;
		w.model[0][0].nextPosY = 1;
		w.attemptMove(w.model[0][0]);
		assertTrue(w.model[0][0] instanceof Empty && w.model[0][1] instanceof Wolf);
	}
	
	@Test
	void attemptMoveTestDeerToWolf() {
		w = new Wild();
		w.model[0][0] = new Deer(0, 0);
		w.model[0][1] = new Wolf(0, 1);
		w.model[0][0].nextPosX = 0;
		w.model[0][0].nextPosY = 1;
		w.attemptMove(w.model[0][0]);
		assertTrue(w.model[0][0] instanceof Empty && w.model[0][1] instanceof Wolf);
	}
	
	@Test
	void attemptMoveTestWolfToDeer() {
		w = new Wild();
		w.model[0][0] = new Wolf(0, 0);
		w.model[0][1] = new Deer(0, 1);
		w.model[0][0].nextPosX = 0;
		w.model[0][0].nextPosY = 1;
		w.attemptMove(w.model[0][0]);
		assertTrue(w.model[0][0] instanceof Empty && w.model[0][1] instanceof Wolf);
	}
	
	@Test
	void attemptMoveTestWolfToWolf() {
		w = new Wild();
		w.model[0][0] = new Wolf(0, 0);
		w.model[0][1] = new Wolf(0, 1);
		w.model[0][0].nextPosX = 0;
		w.model[0][0].nextPosY = 1;
		w.attemptMove(w.model[0][0]);
		assertTrue(w.model[0][0] instanceof Wolf && w.model[0][1] instanceof Wolf);
	}
	
	@Test
	void attemptMoveTestDeerToDeer() {
		w = new Wild();
		w.model[0][0] = new Deer(0, 0);
		w.model[0][1] = new Deer(0, 1);
		w.model[0][0].nextPosX = 0;
		w.model[0][0].nextPosY = 1;
		w.attemptMove(w.model[0][0]);
		assertTrue(w.model[0][0] instanceof Deer && w.model[0][1] instanceof Deer);
	}
	
	@Test
	void toStringTest() { 
		w = new Wild();
		String s = w.toString();
		int deers = 0;
		int wolves = 0;
		int leftbracks = 0;
		int rightbracks = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'D') {deers++;}
			else if(s.charAt(i) == 'W') {wolves++;}
			else if(s.charAt(i) == '[') {leftbracks++;}
			else if(s.charAt(i) == ']') {rightbracks++;}
		}
		assertTrue(leftbracks == rightbracks && (leftbracks + rightbracks) / 2 == w.MAXX * w.MAXY && deers == w.numDeer && wolves == w.numWolves);
	}
	
	@Test
	void getMovesTest() { 
		w = new Wild();
		int xbefore = w.model[0][0].nextPosX;
		int ybefore = w.model[0][0].nextPosY;
		w.getMoves();
		int xafter = w.model[0][0].nextPosX;
		int yafter = w.model[0][0].nextPosY;
		int count = 0;
		for(int i = 0; i < w.order.length; i++) {
			if(!(w.order[i] == null))
				count++;
		}
		int count2 = w.numDeer + w.numWolves;
		assertTrue(count == count2 && (xbefore != xafter ^ ybefore != yafter));
		
	}
}
