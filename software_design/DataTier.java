/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */
package Homeworks.SD2x.software_design;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataTier {

    private String fileName; // the name of the file to read

    public DataTier(String inputSource) {
        fileName = inputSource;
    }
    // ./submissions/Homeworks/SD2x/software_design/assets/books.txt
    public List<Book> getAllBooks() {
        String splitBy = "\t";
        String line;

        List<Book> bookList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while((line = br.readLine()) != null) {
                String[] bookString = line.split(splitBy);
                Book book = new Book(bookString[0], bookString[1], Integer.parseInt(bookString[2]));
                bookList.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
