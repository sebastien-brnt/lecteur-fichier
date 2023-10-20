package fileReader.fileReader;

import java.io.FileInputStream;

public interface ActionFileReader {

    // Open the file
    public void openFile();

    // Close the file
    public void closeFile();

    // Get the file
    public FileInputStream getFile();
}
