/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guntingbatukertas;

/**
 *
 * @author ASUS
 */
import java.util.Random;
import java.util.Scanner;

/*
 * Define an enumeration called Sign, with 3 elements, referred to as:
 * HandSign.SCISSOR, HandSign.PAPER, HandSign.STONE.
 */
enum HandSign {
   GUNTING, KERTAS, BATU
}

/*
 * A game of scissor-paper-stone.
 */
public class GuntingBatuKertas {
   public static void main(String[] args) {
      Random random = new Random();   // Create a random number generator
      boolean gameOver = false;
      HandSign playerMove = HandSign.GUNTING;
      HandSign computerMove;
      int numTrials = 0;
      int numComputerWon = 0;
      int numPlayerWon = 0;
      int numTie = 0;

      Scanner in = new Scanner(System.in);
      System.out.println("Let us begin...");

      while (!gameOver) {
         System.out.printf("%nGunting-Batu-Kertas");

         // Player move
         // Use a do-while loop to handle invalid input
         boolean validInput;
         do {
            System.out.print("   Giliranmu (Ketik s untuk gunting, p untuk kertas, t untuk batu, q untuk keluar): ");
            char inChar = in.next().toLowerCase().charAt(0); // Convert to lowercase and extract first char
            validInput = true;
            if (inChar == 'q') {
               gameOver = true;
            } else if (inChar == 's') {
               playerMove = HandSign.GUNTING;
            } else if (inChar == 'p') {
               playerMove = HandSign.KERTAS;
            } else if (inChar == 't') {
               playerMove = HandSign.BATU;
            } else {
               System.out.println("   Kesalahan input, coba lagi...");
               validInput = false;
            }
         } while (!validInput);

         if (!gameOver) {
            // Computer Move
            int aRandomNumber = random.nextInt(3); // random int between 0 (inclusive) and 3 (exclusive)
            if (aRandomNumber == 0) {
               computerMove = HandSign.GUNTING;
               System.out.println("   Giliranku: GUNTING");
            } else if (aRandomNumber == 0) {
               computerMove = HandSign.KERTAS;
               System.out.println("   Giliranku : PAPER");
            } else {
               computerMove = HandSign.BATU;
               System.out.println("   Giliranku : STONE");
            }

            // Check result
            if (computerMove == playerMove) {
               System.out.println("   Seri!");
               ++numTie;
            } else if (computerMove == HandSign.GUNTING && playerMove == HandSign.KERTAS) {
               System.out.println("   Gunting Memotong Kertas, Aku Menang!");
               ++numComputerWon;
            } else if (computerMove == HandSign.KERTAS && playerMove == HandSign.BATU) {
               System.out.println("   Kertas Membungkus Batu, Aku Menang!");
               ++numComputerWon;
            } else if (computerMove == HandSign.BATU && playerMove == HandSign.GUNTING) {
               System.out.println("   Batu Mematahkan Gunting, Aku Menang!");
               ++numComputerWon;
            } else {
               System.out.println("   Kamu Menang!");
               ++numPlayerWon;
            }
            ++numTrials;
         }
      }
   
      // Print statistics
      System.out.printf("%nBanyak nya Percobaan : " + numTrials);
      System.out.printf(" Aku Menang %d(%.2f%%). Kamu Menang %d(%.2f%%).%n", numComputerWon, 
            100.0*numComputerWon/numTrials, numPlayerWon, 100.0*numPlayerWon/numTrials);
      System.out.println("Selesai! ");
   }
}

