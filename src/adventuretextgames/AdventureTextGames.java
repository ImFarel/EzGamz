/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuretextgames;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author farewell
 */
public class AdventureTextGames {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        Random rn = new Random();

        String[] enemies = {"Skeleton", "Zombie", "Rogue", "Assassin"};
        int maxEnemyHealth = 100;
        int enemyAttackDamage = 26;

        int heroHealth = 100;
        int heroAttackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;

        boolean start = true;

        System.out.println("####### Welcome to the Dungeon!");

        GAME:
        while (start) {
            System.out.println("=============================================");
            int enemyHealth = rn.nextInt(maxEnemyHealth);
            String enemy = enemies[rn.nextInt(enemies.length)];
            System.out.println("\t#" + enemy + " has appeared ! #\n");
            while (enemyHealth > 0) {
//                System.out.println("\t");
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\t1. Attacc");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");
                System.out.print("@Hero : ");
                String input = sn.nextLine();

                if (input.equals("1")) {
                    int damageDealt = rn.nextInt(heroAttackDamage);
                    int damageTaken = rn.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    heroHealth -= damageTaken;

                    System.out.println("\t> You hit the " + enemy + ". " + damageDealt + " damage dealt.");
                    System.out.println("\t> You recieve the " + damageTaken + " in retaliation!.");

                    if (heroHealth < 1) {
                        System.out.println("\t> You are too week to go on");
                    }

                } else if (input.equals("2")) {
                    if (numHealthPotions > 0) {
                        heroHealth += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink a health potion");
                    }

                } else if (input.equals("3")) {
                }
            }
        }
    }

}
