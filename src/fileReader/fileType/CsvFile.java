package fileReader.fileType;

import fileReader.fileReader.FilesReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CsvFile extends FilesReader implements ActionRead {

    private String separator = ";";

    public CsvFile(String path) {
        super(path);
    }

    public CsvFile(String path, String separator) {
        super(path);
        this.separator = separator;
    }

    public void normalRead() {
        // Open the file
        this.openFile();

        // parse the file
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Replace the separator to space
                line = line.replace(this.separator, " ");

                // Display the line
                System.out.println(line);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        // Close the file
        this.closeFile();
    }

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
                // Replace the separator to space
                line = line.replace(this.separator, " ");

                // Add line to buffer
                buffer.add(line);
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
                line = line.replace(this.separator, " ");

                // Reverse lines
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
}
