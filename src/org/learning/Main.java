package org.learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        File file = new File("./resources/books.txt");

        int nBooks = 0;
        while (true) {
            System.out.print("How many books do you want to enter? ");
            try {
                nBooks = Integer.parseInt(scann.nextLine());
                if (nBooks >= 1) {
                    break;
                } else {
                    System.out.println("Enter a number greater than zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        Book[] library = new Book[nBooks];

        try {
            for (int i = 0; i < library.length; i++) {
                System.out.println("********************************************************");
                System.out.println("Book number " + (i+1));
                System.out.print("Insert title: ");
                String title = scann.nextLine();
                System.out.print("Insert author: ");
                String author = scann.nextLine();
                System.out.print("Insert publisher: ");
                String publisher = scann.nextLine();
                System.out.print("Numbers of page: ");
                int nPage = 0;
                while (true) {
                    System.out.print("Number of pages: ");
                    try {
                        nPage = Integer.parseInt(scann.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number of pages.");
                    }
                }
                library[i] = new Book(title, author, publisher, nPage);
                if(file.exists()){
                    writeToFile(file, library[i].toString());
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                scann = new Scanner(file);
                while (scann.hasNextLine()) {
                    String line = scann.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Cannot read to file");
            }
            scann.close();
        }

    }

    private static void writeToFile(File file, String string) {
        try(FileWriter fw = new FileWriter(file, true)){
            fw.write(string);
            fw.write("********************************************************\n");
        } catch (IOException e) {
            System.out.println("Cannot write to file");
        }
    }
}
