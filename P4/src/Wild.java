import java.util.*;

public class Wild {
	static final int MAXT = 3,//maximum number of simulation time steps
                MAXX=2, //maximum number of cells on the x-axis
                MAXY=4; //maximum number of cells on the y-axis
//TO DO: write your code here; create as many classes, interfaces, etc. that you see fit
	
	int numWolves;
	int numDeer;
	
	public Animal[][] model = new Animal[MAXX][MAXY];
	public Animal[] order = new Animal[MAXX * MAXY];
	Wild() { //Default constructor, randomly initializes either a deer or a wolf into every stop
		for(int i = 0; i < MAXX; i++) {
			for(int j = 0; j < MAXY; j++) {
				double dub = Math.random();
				int rand = ((int) (dub * 2));
				switch(rand) {
				case 0: model[i][j] = new Wolf(i, j); numWolves++; break;
				case 1: model[i][j] = new Deer(i, j); numDeer++; break;
				}
			}
		}
	}
	
	public void getMoves() { //Assigns a legal next move to each of the remaining animals in the simulation
		for(int i = 0; i < MAXX; i++) {
			for(int j = 0; j < MAXY; j++) {
				if(!(model[i][j] instanceof Empty)) {
					Cell c = getMove(model[i][j]);
					boolean ordered = true;
					model[i][j].nextPosX = c.x;
					model[i][j].nextPosY = c.y;
					while(ordered) { //This block of code ensures that the animals move in a random order for each time step
						int idx = (int) (Math.random() * (MAXX * MAXY));
						if(order[idx] == null) {
							order[idx] = model[i][j];
							ordered = false;
						}
					}
				}
			}
		}
	}
	
	public void timestep() { // Calls getmoves method and goes through all the moves
		getMoves();
		for(int i = 0; i < order.length; i++) {
			if(!(order[i] == null)) {
				attemptMove(order[i]);
			}
		}
		order = new Animal[MAXX * MAXY];
	}
	public void attemptMove(Animal a) { //Attempts to move an animal. Attempts as in an animal won't move if it tries to move onto another instance of itself
		//System.out.println("Beginning of attempt: \n" + toString());
		Animal other = model[a.nextPosX][a.nextPosY];
		if(other instanceof Empty) {
			model[a.posX][a.posY] = new Empty();
			a.posX = a.nextPosX;
			a.posY = a.nextPosY;
			model[a.posX][a.posY] = a;
		} else if(other instanceof Wolf) {
			if(a instanceof Deer) {
				model[a.posX][a.posY] = new Empty();
				numDeer--;
			}
		} else if(other instanceof Deer) {
			if(a instanceof Wolf) { 
				for(int i = 0; i < order.length; i++) {
					if(model[a.nextPosX][a.nextPosY].equals(order[i])) {
						order[i] = null;
						break;
					}
				}
				model[a.posX][a.posY] = new Empty();
				a.posX = a.nextPosX;
				a.posY = a.nextPosY;
				model[a.posX][a.posY] = a;
				numDeer--;
			}
		}
		//System.out.println("End of attempt: \n" + toString() + "\n\n\n\n\n");
	}
	
	public Cell getMove(Animal a) { // Gives an animal a legal next move. Won't allow it to move out of bounds
		//Returns the cell that an animal will move to next
		int x = a.posX;
		int y = a.posY;
		Cell c = new Cell();
		boolean findMove = true;
		while(findMove) {
			int tempX = (x + (int) Math.floor((Math.random() * 3 - 1)));
			int tempY = (y + (int) Math.floor((Math.random() * 3 - 1)));
			if(tempX < MAXX && tempX >= 0 && tempY < MAXY && tempY >= 0 && ((x + tempX) % 2 == 0 ^ (y + tempY) % 2 == 0)) {
				c.x = tempX;
				c.y = tempY;
				findMove = false;
			}
		}
		return c;
		
	}
	
	public String toString() { //Returns a string representation of the wild
		String s = "";
		for(int i = 0; i < MAXX; i++) {
			for(int j = 0; j < MAXY; j++) {
				if(model[i][j] instanceof Deer)
				s += "[D]";
				if(model[i][j] instanceof Wolf)
				s += "[W]";
				if(model[i][j] instanceof Empty)
				s += "[ ]";
			}
			s += "\n";
		}
		return s;
	}
	

	public static void main(String[] args) {
		Wild w = new Wild();
		System.out.println("Generation 0\n" + w.toString());
		for(int t=0; t < MAXT; t++) {
            //TO DO: write your code here
			w.timestep();
			System.out.println("Generation "+(t+1)+"\n"+w.toString());
		}
	}
}


