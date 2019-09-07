import java.io.*;

public class Recursivestack {

	static InputStreamReader in = new InputStreamReader(System.in);

	public static void rescursivefunct() throws IOException {

		char c;
		if ((c = (char) in.read()) != '\n') {
			rescursivefunct();
		}
		System.out.print(c);
	}
}
