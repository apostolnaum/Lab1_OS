import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HW01_2 {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		FileReader vlez = new FileReader(
				"C:\\Users\\Naum Apostol\\Desktop\\zadaca2\\izvor.txt");
		FileWriter izlez = new FileWriter(
				"C:\\Users\\Naum Apostol\\Desktop\\zadaca2\\destinacija.txt");
		try {
			int c;
			String red = "";
			String prevrten = "";
			String konecen = "";
			while ((c = vlez.read()) != -1) {

				char bukva = (char) c;
				if (bukva == '\n') {
					prevrten = new StringBuilder(red).reverse().toString()
							+ "\r\n";
					konecen += prevrten;
					red = "";
				} else {
					red += bukva;
				}

			}
			konecen += new StringBuilder(red).reverse().toString();

			izlez.write(konecen);

		} finally {
			if (vlez != null) {
				vlez.close();
			}
			if (izlez != null) {
				izlez.close();
			}
		}
	}

}