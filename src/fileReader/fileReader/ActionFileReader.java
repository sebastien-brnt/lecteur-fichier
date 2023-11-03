package fileReader.fileReader;

import java.io.FileInputStream;

public interface ActionFileReader {

    /**
     * Opens the file.
     */
    public void openFile();

    /**
     * Closes the file.
     */
    public void closeFile();

    /**
     * Gets the FileInputStream for the file.
     *
     * @return The FileInputStream for the file.
     */
    public FileInputStream getFile();
}
