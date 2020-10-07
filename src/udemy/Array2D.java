package udemy;

import org.testng.annotations.Test;

public class Array2D {
	
	@Test
	public void twoDAarry(){
		int i;
		int j;
		int [][] myArray = new int[2][3]; //arrays of two arrays and each child array has 3 elements.
		
		myArray[0][0] = 1;
		myArray[0][1] = 2;
		myArray[0][2] = 3;
		
		myArray[1][0] = 4;
		myArray[1][1] = 5;
		myArray[1][2] = 6;
		
		for(i = 0; i < myArray.length;  i++) {
			for(j = 0; j < myArray[i].length; j++){
				
				System.out.print(myArray[i][j] +" ");
				
				
			}
			System.out.println(); //this line prints the second array in a new line. If you remove it, all the array elements
			//printed in the same line.
		}

	}

}
