import java.util.Random;

class SudNum {

int value;
boolean fixed; // if true, wont be randomized

public SudNum() {
	Random rand = new Random();
	value = 1 + rand.nextInt(8);
	fixed = false;
}

public int getValue() {
	return value;
}

public void setRand() {
	if (!fixed) {
		Random rand = new Random();
		value = 1 + rand.nextInt(9);
	}
}

public void setValue(int v) {
	value = v;
	fixed = true;		
}

public void fix(){
	fixed = true;
}

}