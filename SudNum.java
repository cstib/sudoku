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
	return value;
}

public void setRand() {
	Random rand = new Random();
	//value = 1 + rand.nextInt(9);
	//choose a random form possible
	int rand_pos = rand.nextInt(possible.size());
	value = possible.get(rand_pos);
	
}

public void setValue(int v) {
	value = v;
	fixed = true;
}

    public void remove_possible(int num) {
	//check that it is in?
	possible.remove(new Integer(num));
    }
}
