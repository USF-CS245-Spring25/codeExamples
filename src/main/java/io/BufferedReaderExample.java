package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** Shows how to read data from the file using a BufferedReader */
public class BufferedReaderExample {

    /**
     * Reads lines from the given text file and prints each line to the console
     * @param filename name of the input file
     */
    public static void readFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String filename = "file.txt";
        readFromFile(filename);
    }
}
