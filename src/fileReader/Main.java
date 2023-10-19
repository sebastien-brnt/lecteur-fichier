package fileReader;

import fileReader.fileType.TextFile;

import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        TextFile file = new TextFile("/Users/sebastien/Documents/Sorbonne/Cours/Java/Devoirs maison/lecteur-fichier/src/fileReader/monficher.txt");
        file.openFile();
        file.normalRead();
    }
}