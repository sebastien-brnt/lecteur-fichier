package fileReader.myFileReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public abstract class MyFilesReader implements ActionFileReader {

    // Attributes
    private final String path;
    private FileInputStream file;

    // Constructor
    public MyFilesReader(String path) {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("Path cannot be null or empty");
        } else {
            this.path = path;
        }
    }

    // Open the file
    @Override
    public void openFile() {
        File file = new File(path);
        try {
            this.file = new FileInputStream(file);
        } catch (Exception e){
            e.getStackTrace();
        }
    }

    // Close the file
    @Override
    public void closeFile() {
        if (this.file != null) {
            try {
                this.file.close();
            } catch (Exception e){
                e.getStackTrace();
            }
        }
    }

    // Get the file
    @Override
    public FileInputStream getFile() {
        return this.file;
    }

    // Get path of file
    @Override
    public String getPath() {
        return path;
    }

    public void compareLinesDiff(ArrayList<String> buffer1, ArrayList<String> buffer2) {
        // Initialization of flag and counter
        boolean equals = true;
        int differences = 0;

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
    }



    //Abstract methods to be implemented by subclasses
    public abstract void normalRead();
    public abstract void reverseRead();
    public abstract void palindromicRead();
}
