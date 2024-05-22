package org.exercise.java;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Library {
    public static void main(String[] args) {
        // Open Scanner
        Scanner scanner = new Scanner(System.in);

        // Generate empty array
        int booksArraySize;
        System.out.print("How many books would you like to add? ");
        booksArraySize = Integer.parseInt(scanner.nextLine());
        Book[] bookArray = new Book[booksArraySize];

        // Add books
        int i = 0;
        while (i < booksArraySize) {
            System.out.println("Please enter the book's details:");

            String title, author, publisher;
            int pages;

            try {
                System.out.print("Book title: ");
                title = scanner.nextLine();
                System.out.print("Page count: ");
                pages = Integer.parseInt(scanner.nextLine());
                System.out.print("Author: ");
                author = scanner.nextLine();
                System.out.print("Publisher: ");
                publisher = scanner.nextLine();

                bookArray[i] = new Book(title, pages, author, publisher);
                i++;
            } catch (NumberFormatException e) {
                System.out.println("Error: Page number must be an integer.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("****************");

        // Write books to file
        writer(bookArray, "./resources/data.txt");

        // Read books from file and print
        reader("./resources/data.txt");

        // Close Scanner
        scanner.close();
    }

    // Writer method
    public static void writer(Book[] books, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Book book : books) {
                writer.write(book.toString() + "\n");
            }
            System.out.println("Books saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Writing error: couldn't write to file");
        }
    }

    // Reader method
    public static void reader(String filePath) {
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to read from " + filePath);
        }
    }
}

