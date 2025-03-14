package io;

import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {

    /**
     * Write lines to the file
     * @param lines array of strings
     * @param filename name of the output file
     */
    public static void printToFile(String[] lines, String filename) {
        if (lines == null || lines.length == 0) {
            System.out.println("No lines.");
            return;
        }
        try (PrintWriter pw = new PrintWriter(filename)){
            for (String line: lines) {
                pw.println(line);
            }
            pw.flush();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String filename = "output.txt";
        String[] lines = {"line1", "line2", "line3"};
        printToFile(lines, filename);
    }
}
