package fileReader;

import fileReader.fileType.TextFile;
import fileReader.fileType.CsvFile;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        TextFile fileText = new TextFile("/Users/sebastien/Documents/Sorbonne/Cours/Java/Devoirs maison/lecteur-fichier/src/fileReader/monficher.txt");
        CsvFile fileCsv = new CsvFile("/Users/sebastien/Documents/Sorbonne/Cours/Java/Devoirs maison/lecteur-fichier/src/fileReader/monfichier.csv");

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
    }
}