package fileReader.fileType;


import fileReader.fileReader.FilesReader;

import java.io.FileInputStream;

public class TextFile extends FilesReader {

    public TextFile(String path) {
        super(path);
    }

    public void normalRead() {
        System.out.println("======= Normal file playback =======");
        char[] buffer = new char[50];

        try {
            FileInputStream myFile = this.getFile();
            int data;

            int i = 0;
            while ( (data = myFile.read()) != -1) {
                buffer[i] = (char) data;
                i++;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        System.out.println(buffer);
    }


    public void reverseRead() {
        System.out.println("======= Reverse file playback =======");
        char[] buffer = new char[50];

        try {
            FileInputStream myFile = this.getFile();
            int data;

            int i = 0;
            while ( (data = myFile.read()) != -1) {
                buffer[i] = (char) data;
                i++;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        System.out.println(buffer);
    }


    public void palindromicRead() {
        System.out.println("======= Palindromic file playback =======");
        char[] buffer = new char[50];
        char[] bufferPalindromic = new char[50];

        try {
            FileInputStream myFile = this.getFile();
            int data;

            int i = 0;
            while ( (data = myFile.read()) != -1) {
                buffer[i] = (char) data;
                i++;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        int i = 0;
        for (int j = buffer.length - 1; j >= 0; j--) {
            if (buffer[j] != '\0') {
                bufferPalindromic[i] = buffer[j];
                i++;
            }
        }

        System.out.println(bufferPalindromic);
    }
}
