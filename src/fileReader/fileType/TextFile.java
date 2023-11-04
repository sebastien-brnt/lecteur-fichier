package fileReader.fileType;


import fileReader.myFileReader.MyFilesReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TextFile extends MyFilesReader implements ActionRead {

    public TextFile(String path) {
        super(path);
    }

    public void normalRead() {
        // Open the file
        this.openFile();

        // Parse the file
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
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

    public void compareFiles(TextFile file) {
        // Open the first file
        this.openFile();

        // Open the second file
        file.openFile();

        // Initialization of buffers for both files
        ArrayList<String> buffer1 = new ArrayList<>();
        ArrayList<String> buffer2 = new ArrayList<>();

        try (BufferedReader br1 = new BufferedReader(new InputStreamReader(this.getFile()));
             BufferedReader br2 = new BufferedReader(new InputStreamReader(file.getFile()))) {

            String line1, line2;

            // Read lines from both files
            while ((line1 = br1.readLine()) != null && (line2 = br2.readLine()) != null) {
                // Add lines to buffers
                buffer1.add(line1);
                buffer2.add(line2);
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

    public void compareFilesWithHighlight(TextFile file) {
        // Open the first file
        this.openFile();

        // Open the second file
        file.openFile();

        Boolean equals = true;
        int differences = 0;

        // Initialization of buffers for both files
        ArrayList<String> buffer1 = new ArrayList<>();
        ArrayList<String> buffer2 = new ArrayList<>();

        try (BufferedReader br1 = new BufferedReader(new InputStreamReader(this.getFile()));
             BufferedReader br2 = new BufferedReader(new InputStreamReader(file.getFile()))) {

            String line1, line2;

            // Read lines from both files
            while ((line1 = br1.readLine()) != null && (line2 = br2.readLine()) != null) {
                // Add lines to buffers
                buffer1.add(line1);
                buffer2.add(line2);
            }

            // Compare the two buffers and display differences
            for (int i = 0; i < buffer1.size(); i++) {
                String lineA = buffer1.get(i);
                String lineB = buffer2.get(i);

                if (!lineA.equals(lineB)) {
                    equals = false;
                    differences++;
                    System.out.println("Difference in line " + (i + 1) + ":");
                    System.out.println("File 1: " + lineA);
                    System.out.println("File 2: " + lineB);
                    System.out.println();
                }
            }

            if (equals) {
                System.out.println("The files are identical.");
            } else {
                System.out.println("Files have " + differences + " different lines");
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        // Close both files
        this.closeFile();
        file.closeFile();
    }
}
