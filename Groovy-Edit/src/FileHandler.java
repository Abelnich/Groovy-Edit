
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public FileHandler(String fileName, String fileExtension) {
        this.fileName = fileName;
        myFile = new File(fileName);
        
        if (!myFile.isFile()) {
            // creates the file if it doesn't exist
            try {
                myFile.createNewFile();
            } catch (IOException ioe) {
                System.out.println("File creation error: " + ioe.getMessage());
            }
        }
        
        fileContents = new ArrayList();

        boolean extension = false;
        String tempStr = ""; // Temporary string for file name w/o extension
        for (char ch : fileName.toCharArray()) {
            // look for the file extension
            if (ch == '.' || extension) {
                extension = true;
            } else {
                tempStr += ch;
            }
        } // end for each
        
        fileName = tempStr;
        
        switch (fileExtension) {
            case ".txt":
                readTxtFile();
                break;
            default:
                fileExtension = ".txt";
                readTxtFile();
                break;
        } // end switch
    } // end constructor
    
    public void readFile(String ext) {
        // will route to correct read function based on extension
        switch (ext) {
            case ".txt":
                readTxtFile();
                break;
        }
    } // end readFile()
    
    public void writeFile(String contents, String ext) {
        // will route to correct write function based on extension
        switch (ext) {
            case ".txt":
                writeTxtFile(contents);
                break;
        }
    } // end readFile()

    public void readTxtFile() {
        fileContents.clear(); // clears the saved contents so it isn't duplicated

        try {
            fileIn = new Scanner(myFile);
        } catch (Exception e) {
            // Will print any exception to the console
            System.out.println("readTxtFile() error: " + e.getMessage());
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

    public void writeTxtFile(String writeMe) {

        try {
            FileWriter myWriter = new FileWriter(this.fileName);
            myWriter.write(writeMe);
            myWriter.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

    public String getFileExt() {
        return fileExtension;
    }

    public String arraylistToString(ArrayList<String> changeMe) {
        // Converts writeMe Array to a String seperated by a new line character
        String arrayToString = String.join("\n", changeMe);
        return arrayToString;
    }
    
    public void stringToArrayList(String changeMe, String delim) {
        String[] strArry = changeMe.split(delim);
        
        
    }
    
    public String getContents() {
        return arraylistToString(fileContents);
    }
    
    public ArrayList<String> getContentsArry() {
        return fileContents;
    }
    
    public void clearTxtFile() {
        writeTxtFile("");
    }

}
