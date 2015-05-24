import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HW01_5 {
    public static void main(String[] args) throws IOException {
        File dest = new File("rezultati.tsv");
        File rez = new File("rezProsek");
        File f;
        if (args.length != 1) {
            System.out.println("izberete datoteka");
            System.exit(0);
        }
        f = new File(args[0]);
        if (f.exists()) {
            String line;
            String[] iminjaPredmeti = null;
            int brStudenti = 0;
            BufferedReader br = new BufferedReader(new FileReader(f));
            if ((line = br.readLine()) != null) {
                iminjaPredmeti = line.split(",");
            }
            int[] prosek = new int[iminjaPredmeti.length];
            while ((line = br.readLine()) != null) {
                String[] st = line.split(","); //presmetuva prosek po predmet
                for (int i = 1; i < st.length; i++) {
                    prosek[i] += Integer.parseInt(st[i].substring(1));
                }
                //presmetuva prosek na student
                int prosekStudent = 0;
                for (int i = 1; i < st.length; i++) {
                    prosekStudent += Integer.parseInt(st[i].substring(1));
                }
                writeToFile(dest.getAbsolutePath(), st[0] + "\t" + (float) prosekStudent / (iminjaPredmeti.length - 1) + "\n", true);
                brStudenti++;
            }
            br.close();
            for (int i = 1; i < iminjaPredmeti.length; i++)
                writeToFile(dest.getAbsolutePath(), iminjaPredmeti[i] + "\t" + prosek[i] / brStudenti + "\n", true);
        }
        BufferedReader reader = new BufferedReader(new FileReader(dest));
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null)
            builder.append(line + "\n");
        reader.close();
        System.out.println(builder.toString());
    }
    public static void writeToFile(String path, String linija, boolean append) throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter(path, append));
        br.write(linija);
        br.close();
    }
}