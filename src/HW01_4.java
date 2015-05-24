import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HW01_4 {
	private static BufferedReader br;

	public static void citajTekst(String path, String word)
			throws IOException {
		br = new BufferedReader(new FileReader(path));
		String line;
		int bro = 0;

		while ((line = br.readLine()) != null) {
			String[] zborivi = line.split(" ");
			for (String zbor : zborivi) {
				if (zbor.equalsIgnoreCase(word)) {
					bro++;

				}

			}

		}

		System.out.println(bro);
	}

	public static void main(String[] args) throws IOException {
		String path = "example4.txt";
		citajTekst(path, "test");

	}

}