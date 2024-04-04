// package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * FileIO.java.
 *
 * @author Spencer Scarlett
 * @version 1.0
 * @since 2024-03-19
 */

// FileIO class
public final class FileIO {

  /**
   * Makes style checker happy.
   *
   * @exception IllegalStateException Utility class.
   * @see IllegalStateException
   */
  private FileIO() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * This is the main method.
   *
   * @param args Unused.
   */

  // Main function
  public static void main(final String[] args) {
    // Finds and preps filepaths
    final File fileInput = new File("input.txt");
    final File fileOutput = new File("output.txt");

    try {
      // Preps fileWriter for output file (allows output)
      final FileWriter fW = new FileWriter(fileOutput);
      // Preps scanner for input file (reads file)
      final Scanner sc = new Scanner(fileInput);
      // Preps printWriter object for output file
      final PrintWriter write = new PrintWriter(fW);

      while (sc.hasNextLine()) {
        // Input as string (first)
        final String newLine = sc.nextLine();

        // Checks for invalid cases of nothing
        if (newLine.isEmpty()) {
          write.println("No inputs detected");
          continue;
        }

        // Splits inputs into arrays
        final String[] stringArray = newLine.split(" ");

        // Variables for later
        int sum = 0;
        int sizeEleInt = 0;

        // For loop for each line within the file
        for (String elementString : stringArray) {
          // Try catch for invalid elements in input
          try {
            // Pass int from string
            sizeEleInt = Integer.parseInt(elementString);

            // Calculate sum value
            sum = sum + sizeEleInt;

          } catch (NumberFormatException error) {
            // Invalid inputs
            write.println("Invalid input, " + error.getMessage());
            // Continue to next line (doesn't break the program)
            continue;
          }
        }
        // writes output of the sum in output file
        write.println("The sum of numbers is: " + sum);
      }
      // Closing utils (scanner and writer)
      write.close();
      sc.close();
      // Bad errors
    } catch (IOException error) {
      System.out.println("Error: " + error.getMessage());
    }
  }
}
