package udemy;

import org.testng.annotations.Test;

public class Array3D {

	@Test
	public void threeDArray() {

		int[][][] myArray = new int[2][3][4]; //arrays of three arrays, parent arrays with 2-arrays. Two children arrays each
		//has four (grand children) arrays

		for(int i= 0; i < myArray.length; i++) {
			for(int j = 0; j < myArray[i].length; j++) {
				for(int k = 0; k < myArray[i][j].length; k++) {
					myArray[i][j][k] = (int)(Math.random() * 100); //generating random number and multiplying by 100 generates two digit numbers.
					System.out.print(myArray[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}

	}
}


