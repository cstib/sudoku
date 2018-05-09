import java.util.Scanner;
import java.sql.Timestamp;

class Sudoku {

SudNum[][] table;

public Sudoku() {
		//Scanner in = new Scanner(System.in);
		System.out.println("a");
		table = new SudNum[9][9];
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {	
				table[i][j] = new SudNum();
				System.out.println(table[i][j].getValue());
			}
		}

	}


public void display() {
	for(int i = 0; i<9; i++) {
		for(int j = 0; j<9; j++) {			
			System.out.print(table[i][j].getValue() + " ");
			if ((j+1)%3 == 0) {
				System.out.print("|");
				}
			}
		System.out.println();
		if ((i+1)%3 == 0) {
			for(int j = 0; j<9; j++) {
				System.out.print("- ");
				}
			}
		System.out.println();
		}
	
	}

public void getInput() {
	Scanner in = new Scanner(System.in);
	System.out.println("Enter command: r)andomize, s)et, i)s solved, t)ry random algorithm triv)ial solution e)xit");
	String s = in.nextLine();
	System.out.println("You entered string "+s);
	switch (s) {
		//TODO get rid of exit
		case "e": 
			System.exit(0);
			break;  //why
		case "r":
			this.randomize();
			this.display();
			break;
		case "s":
			this.setElement();
			break;
		case "i":
			System.out.println(this.isSolved());
			break;	
		case "t":
			System.out.println("trying setting random values, and checking if the rows are solved. might take awhile");
			this.random_rows();
			break;
		case "v":
			System.out.println("Setting a trivial solution");
			this.trivial();
			break;
		default:
			System.out.println("Unknown command");	
			break;
		}
	}


public void randomize() {
	//System.out.println("Randomizing");
	for(int i = 0; i<9; i++) {
		for(int j = 0; j<9; j++) {		
			table[i][j].setRand();	
		}
	}
	this.display();
}

public void setElement() {
	Scanner in = new Scanner(System.in);
	System.out.println("please enter column, row and value, no separation");	
	String paramsString = in.nextLine();
	//TODO check String lenght
	int i = Character.getNumericValue(paramsString.charAt(0));
	System.out.println(i);
	int j = Character.getNumericValue(paramsString.charAt(1));
	int v = Character.getNumericValue(paramsString.charAt(2));
	System.out.println(i);
	System.out.println(j);
	System.out.println(v);
	//input check, maybe try catching exceptions
	if ( (i==(int)i) &&  (j==(int)j) && (v==(int)v) ) {
		table[i][j].setValue(v);
		System.out.println("setting row " + i + "column " + j + "to " + v);  
		this.display(); 
	}
		
	else {
		System.out.println("wrong format");
	}
}


//set the table to a trivial solution
public void trivial() {
	for (int i = 0; i<9; i++){
		for (int j = 0; j< 9; j++){
			int value = (i+j)%9+1; 
			table[i][j].setValue(value);		}
	}
	this.display();	

}


public boolean isSolved() {

  boolean rowsSoved     = this.rowsSolved();
  boolean columnsSoved  = this.columnsSolved();
  boolean squaresSolves = this.squaresSolved(); 	
  return rowsSoved && columnsSoved && squaresSolves;			
}

//check if all rows are correct
public boolean rowsSolved() {
	boolean containsAll = true;
	int i = 0;
	while (i<9 && containsAll) {
		int [] row = getRow(i);	
		containsAll = containsAll(row); //if false set containsAll to false, the loop will stop
		if (containsAll) {
				System.out.println("row fixed");
				this.fixRow(i); //this row wont be randomized
		}
		//System.out.println(i);
		i++;
	}
	if (containsAll) {
		this.display();
	}
		
	return containsAll;
}

public boolean columnsSolved() {
	return true;
}

public boolean squaresSolved() {
	return true;
}


public int[] getRow(int row) {
	int[] result = new int[9];
	for(int i = 0; i<9; i++) {
		result[i] = table[row][i].getValue();	
		//System.out.print(result[i]+ " ");
	}
	//System.out.println();
	return result;

}

//TODO ArrayList?
//checks if the list conatins all number from 1 to 10
public boolean containsAll(int[] list) {
	int i = 1;
	boolean contains = true;
	while (i<10 && contains) {
		contains = contains(list, i);
		i++;	
	}
	if (contains) {
	//	System.out.println("list is correct!");
		
	}
	return contains;
	
}

//checks if the list contains a specific number
public boolean contains(int [] list, int num) {
	boolean contains = false;
	for (int i = 0; i<9; i++){
		if (list[i] == num) {
			contains = true;
		}
	}
	return contains;	
}


public void random() {
	while(!this.rowsSolved()) {
		this.randomize();
	}
}

//check if all rows are correct. if not, randimize all elements and try again
public void random_rows() {

	java.util.Date date = new java.util.Date();
	Timestamp startTime =  new Timestamp(date.getTime());
	System.out.println(startTime);
	while(!this.rowsSolved()) {
		this.randomize();
	}
	java.util.Date date1 = new java.util.Date();	
	Timestamp stopTime =  new Timestamp(date1.getTime());
	System.out.println("The rows are correct!");
	System.out.println(stopTime);
	long milliseconds = stopTime.getTime() - startTime.getTime();
	System.out.println("Solved in " + milliseconds/1000 + "seconds");
	
}

public void fixRow(int row) {
	for (int i = 0; i<9; i++) {
		table[row][i].fix();
	}
}

public static void main(String[] args) {


	System.out.println("Hello World");
	Sudoku sudoku = new Sudoku();
	sudoku.display();
	for(;;) {
		sudoku.getInput();
	}

}

}