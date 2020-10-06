
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NickAbel
 */
public class FileHandler {
    
    private String fileName;
    private String fileExtension = "";
    private File myFile;
    private Scanner fileIn;
    
    public FileHandler(String fileName) {
        this.fileName = fileName;

        try {
            // Creates an File object 
            myFile = new File(fileName);
            if (myFile.createNewFile()) {
                // if the file did not exist before
                System.out.println("File created: " + myFile.getName());
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        
        boolean extension = false;
        for (char ch: fileName.toCharArray()) {
            // look for the file extension
            if (ch == '.' || extension) {
                extension = true;
                fileExtension += ch;
            }
        }
        
    }

    public ArrayList<String> readFile() {
        ArrayList<String> contents = new ArrayList();

        try {
            fileIn = new Scanner(myFile);
        } catch (Exception e) {
            // Will print any exception to the console
            System.out.println(e.getMessage());
        }

        String line;

        while (fileIn.hasNext()) {
            // Iterates through the file line by line. Adds each whole line to the array.
            line = fileIn.nextLine();
            contents.add(line);
        }

        // Close file to avoid potential corruption.
        fileIn.close();

        return contents;
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
    
    public String getFileExt() {
        return fileExtension;
    }
    
}
