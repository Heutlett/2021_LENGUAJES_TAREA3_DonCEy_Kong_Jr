package utility;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {

    public ReadFile() {
    }

    public static String getData(String file) {
        try {
            File myObj = new File(file);
            StringBuilder data = new StringBuilder();
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data.append(myReader.nextLine());
            }
            myReader.close();
            return data.toString();
        } catch (FileNotFoundException e) {
            System.out.printf("An error occurred reading %s%n.", file);
            e.printStackTrace();
        }
        return "";
    }
}
