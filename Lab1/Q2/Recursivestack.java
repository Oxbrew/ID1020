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
