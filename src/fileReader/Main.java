package fileReader;

import fileReader.fileType.TextFile;
import fileReader.fileType.CsvFile;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String baseDir = System.getProperty("user.dir") + "/src/fileReader/files/";

        // Recovery of text files
        TextFile fileText = new TextFile(baseDir + "monFicher.txt");
        TextFile fileTextCompare = new TextFile(baseDir + "monFicherCompare.txt");
        TextFile fileTextIdentical = new TextFile(baseDir + "monFicherCompare.txt");

        // Recovery of CSV files
        CsvFile fileCsv = new CsvFile(baseDir + "monFichier.csv");
        CsvFile fileCsvCompare = new CsvFile(baseDir + "monFichierCompare.csv");
        CsvFile fileCsvIdentical = new CsvFile(baseDir + "monFichier.csv");

        // Read text file
        System.out.println("\n=========================");
        System.out.println("======= TEXT FILE =======");
        System.out.println("=========================");
        System.out.println("\n======= Normal text file playback =======");
        fileText.normalRead();

        System.out.println("\n======= Reverse text file playback =======");
        fileText.reverseRead();

        System.out.println("\n======= Palindromic text file playback =======");
        fileText.palindromicRead();

        System.out.println("\n======= Compare Files =======");
        fileText.compareFiles(fileTextIdentical);

        System.out.println("\n======= Compare Files With Highlight =======");
        fileText.compareFilesWithHighlight(fileTextCompare);
        System.out.println();


        // Read CSV file
        System.out.println("\n========================");
        System.out.println("======= CSV FILE =======");
        System.out.println("========================");
        System.out.println("\n======= Normal text file playback =======");
        fileCsv.normalRead();

        System.out.println("\n======= Reverse text file playback =======");
        fileCsv.reverseRead();

        System.out.println("\n======= Palindromic text file playback =======");
        fileCsv.palindromicRead();

        System.out.println("\n======= Compare Files =======");
        fileCsv.compareFiles(fileCsvIdentical);

        System.out.println("\n======= Compare Files With Highlight =======");
        fileCsv.compareFilesWithHighlight(fileCsvCompare);
        System.out.println();
    }
}