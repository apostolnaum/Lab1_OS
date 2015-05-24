import java.io.File;

public class HW01_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File path = new File("C:\\Users\\Naum Apostol\\Desktop\\dadoteka");
		long broj = 0;
		long size = 0;
		if (path.isDirectory()) {
			File[] files = path.listFiles();
			for (File file : files) {
				if (file.isFile()) {
					broj++;
					size = file.getTotalSpace();

				}

			}
		}
		double averageSize = size / broj;
		System.out.println(averageSize);
	}


}
