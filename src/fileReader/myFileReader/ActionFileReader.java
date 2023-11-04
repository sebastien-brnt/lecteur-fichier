package fileReader.myFileReader;

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

    /**
     * Gets the String for file path.
     *
     * @return The file path String
     */
    public String getPath();

    /**
     * Sets the file path.
     */
    public void setPath(String path);
}
