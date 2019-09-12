/*
*@author: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab1
*
*Input: Enter characters when running or redirect textfile
*Output: Reversed characters
*
*Goal: Use a recursive function in java to reverse characters.
*/

import java.io.*;

public class Recursivestack {

	static InputStreamReader in = new InputStreamReader(System.in);

	public static void rescursivefunct() throws IOException {

		char c;
		if ((c = (char) in.read()) != '\n') { //works the same as c, while c is not 'Enter' continue reading
			rescursivefunct(); //calls again, does not overwrite c.
		}
		System.out.print(c); //prints out c,
	}
}
