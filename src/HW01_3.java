import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class HW01_3 {

	private static BufferedReader in;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("C:\\Users\\Naum Apostol\\Desktop\\zadaca2\\izvor.txt"));
		BufferedWriter outputStream = new BufferedWriter(new FileWriter("C:\\Users\\Naum Apostol\\Desktop\\zadaca2\\destinacija.txt"));
		String nekoj;
		String revert="";
		while((nekoj=in.readLine())!=null)
		{
			revert+= new StringBuilder(nekoj).reverse().toString();
			
		}
		outputStream.write(revert);
		outputStream.close();

	}

}
