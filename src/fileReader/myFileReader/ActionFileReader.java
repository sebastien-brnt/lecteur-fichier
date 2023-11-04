package fileReader.myFileReader;

import java.io.FileInputStream;
import java.util.ArrayList;

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
     * Compares lines from two buffers with the ability to show differences.
     *
     *  @param buffer1 The first buffer containing lines from the first file.
     *  @param buffer2 The second buffer containing lines from the second file.
     *  @param showDiff A boolean flag indicating whether differences should be displayed.
     */
    public void compareLinesDiff(ArrayList<String> buffer1, ArrayList<String> buffer2, boolean showDiff);
}
