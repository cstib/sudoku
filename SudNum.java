import java.util.Random;
import java.util.*;

class SudNum {

    int value;
    boolean fixed; // if true, wont be randomized
    ArrayList<Integer> possible;  //possible values
    
public SudNum() {
	Random rand = new Random();
	value = 1 + rand.nextInt(8);
	fixed = false;
	possible = new  ArrayList<Integer>();
	//TODO use a collection?
	possible.add(1);
	possible.add(2);
	possible.add(3);
	possible.add(4);
	possible.add(5);
	possible.add(6);
	possible.add(7);
	possible.add(8);
	possible.add(9);
}

public int getValue() {
	if (fixed) {
		return value;
	} else {
		return 0;
	}
}

public void setRand() {

	if (!fixed) {
		
	

	  Random rand = new Random();
	  //value = 1 + rand.nextInt(9);
	  //choose a random form possible
	  int rand_pos = rand.nextInt(possible.size());
	  value = possible.get(rand_pos);
  }

}

public boolean setValue(int v) {
	if (possible.contains(v)) {
		value = v;
		fixed = true;
		return true;
	} else {
		//Move to display class
		return false;
		
	}
}


public void fix(){
	fixed = true;
}



    public boolean removePossible(int num) {
	//check that it is in?
		possible.remove(Integer.valueOf(num));
		if (possible.size() == 1) {
			Integer lastPossible = possible.get(0);
			//TODO move tho display class
			System.out.println("Only one possible value left " + lastPossible + ", setting to that value");
			value = lastPossible;
			fixed = true;
			return true;
		} else {
			return false;	
		}
	}
	
	public ArrayList<Integer> getPossible() {
		return possible;
	}
}

