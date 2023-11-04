package fileReader.fileType;

import fileReader.myFileReader.MyFilesReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CsvFile extends MyFilesReader implements ActionRead {

    // Attributes
    private String separator = ";";
    private String separatorForDisplay = " | ";


    // Constructor only with path
    public CsvFile(String path) {
        super(path);
    }

    // Constructor with path, separator and separator for display
    public CsvFile(String path, String separator, String separatorForDisplay) {
        super(path);
        this.separator = separator;
        this.separatorForDisplay = separatorForDisplay;
    }

    // Constructor with path and separator
    public CsvFile(String path, String separator) {
        super(path);
        this.separator = separator;
    }


    // Get separator of file
    public String getSeparator() {
        return separator;
    }

    // Get separator for display
    public String getSeparatorForDisplay() {
        return separatorForDisplay;
    }

    // Set separator of file
    public void setSeparator(String separator) {
        this.separator =  separator;
    }

    // Set separator for display
    public void setSeparatorForDisplay(String separatorForDisplay) {
        this.separatorForDisplay = separatorForDisplay;
    }

    public String replaceSeparator(String stringToReplace) {
        return stringToReplace.replace(this.getSeparator(), this.getSeparatorForDisplay());
    }

    @Override
    public void normalRead() {
        // Open the file
        this.openFile();

        // parse the file
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Replace the separator to space
                line = replaceSeparator(line);

                // Display the line
                System.out.println(line);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        // Close the file
        this.closeFile();
    }

    @Override
    public void reverseRead() {
        // Open the file
        this.openFile();

        // Initialization of buffers
        ArrayList<String> buffer = new ArrayList<String>();
        ArrayList<String> reversedBuffer = new ArrayList<String>();

        // Parse the file and add each line to our buffer
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Add line to buffer with replaced separator
                buffer.add(replaceSeparator(line));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        // Parse each element of buffer in reverse to add to reversedBuffer
        for (int i = buffer.size() - 1; i >= 0; i--) {
            reversedBuffer.add(buffer.get(i));
        }

        // Display
        for (String bufferedLine : reversedBuffer) {
            System.out.println(bufferedLine);
        }

        // Close the file
        this.closeFile();
    }

    @Override
    public void palindromicRead() {
        // Open the file
        this.openFile();

        // Initialization of buffer
        ArrayList<String> buffer = new ArrayList<String>();

        // Parse the file and add each line to our buffer
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Replace the separator to space
                line = replaceSeparator(line);

                // Reverse char in the line
                String reversedLine = new StringBuilder(line).reverse().toString();

                // Add line to buffer
                buffer.add(reversedLine);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        // Display
        for (String bufferedLine : buffer) {
            System.out.println(bufferedLine);
        }

        // Close the file
        this.closeFile();
    }

    // Compare file without showing differences
    public void compareFiles(CsvFile file) {
        // Open both files
        this.openFile();
        file.openFile();

        // Initialization of buffers for both files
        ArrayList<String> buffer1 = new ArrayList<>();
        ArrayList<String> buffer2 = new ArrayList<>();

        try (BufferedReader br1 = new BufferedReader(new InputStreamReader(this.getFile()));
             BufferedReader br2 = new BufferedReader(new InputStreamReader(file.getFile()))) {

            String line1, line2;

            // Read lines from both files
            while ((line1 = br1.readLine()) != null && (line2 = br2.readLine()) != null) {
                // Adding lines to the buffer with replaced separators
                buffer1.add(replaceSeparator(line1));
                buffer2.add(replaceSeparator(line2));
            }

            // Compare the two buffers
            if (buffer1.equals(buffer2)) {
                System.out.println("The files are identical.");
            } else {
                System.out.println("The files are not identical.");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        // Close both files
        this.closeFile();
        file.closeFile();
    }

    // Compare file with showing differences
    public void compareFilesWithHighlight(CsvFile file) {
        // Open both files
        this.openFile();
        file.openFile();

        // Initialization of buffers for both files
        ArrayList<String> buffer1 = new ArrayList<>();
        ArrayList<String> buffer2 = new ArrayList<>();

        try (BufferedReader br1 = new BufferedReader(new InputStreamReader(this.getFile()));
             BufferedReader br2 = new BufferedReader(new InputStreamReader(file.getFile()))) {

            String line1, line2;

            // Read lines from both files
            while ((line1 = br1.readLine()) != null && (line2 = br2.readLine()) != null) {
                // Adding lines to the buffer with replaced separators
                buffer1.add(replaceSeparator(line1));
                buffer2.add(replaceSeparator(line2));
            }

            // Using the parent method to compare and show differences of lines
            this.compareLinesDiff(buffer1, buffer2);

        } catch (Exception e) {
            e.getStackTrace();
        }

        // Close both files
        this.closeFile();
        file.closeFile();
    }
}
