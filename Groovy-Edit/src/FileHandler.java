
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NickAbel
 */
public class FileHandler {
    
    private File myFile;
    private Scanner fileIn;
    
    private String fileName;
    private String fileExtension = "";
    private ArrayList<String> fileContents;
    
    public FileHandler(String fileName) {
        this.fileName = fileName;
        myFile = new File(fileName);
        fileContents = new ArrayList();

        boolean extension = false;
        for (char ch: fileName.toCharArray()) {
            // look for the file extension
            if (ch == '.' || extension) {
                extension = true;
                fileExtension += ch;
            }
        } // end for each
        
        readFile();
        
    }

    public void readFile() {

        try {
            fileIn = new Scanner(myFile);
        } catch (Exception e) {
            // Will print any exception to the console
            System.out.println("ReadFile() error: " + e.getMessage());
        }

        String line;

        while (fileIn.hasNext()) {
            // Iterates through the file line by line. Adds each whole line to the array.
            line = fileIn.nextLine();
            fileContents.add(line);
        }

        // Close file to avoid potential corruption.
        fileIn.close();
    }

    public void writeFile(ArrayList<String> writeMe) {

        // Converts writeMe Array to a String seperated by a new line character
        String arrayToString = String.join("\n", writeMe);

        try {
            FileWriter myWriter = new FileWriter(this.fileName);
            myWriter.write(arrayToString);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        
    }
    
        public void writeFile(String writeMe) {

        // Same as above but with a string parameter

        try {
            FileWriter myWriter = new FileWriter(this.fileName);
            myWriter.write(writeMe);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        
    }
    
    public String getFileExt() {
        return fileExtension;
    }
    
    public String arraylistToString() {
        String arrayToString = String.join("\n", fileContents);
        return arrayToString;
    }
    
}
