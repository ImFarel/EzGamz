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
        int healthPotionDropChance = 30;

        boolean start;

        System.out.println("####### Welcome to the Dungeon!");
        System.out.println("####### Start the journey?!");
        System.out.println("####### > 1. Start");
        System.out.println("####### > 2. Exit");
        System.out.print("####### > ");
        String inputs = sn.nextLine();
        if (inputs.equals("1")) {
            start = true;
        } else {
            start = false;
        }
        GAME:
        while (start) {
            System.out.println("=============================================");

            int enemyHealth = rn.nextInt(maxEnemyHealth);
            String enemy = enemies[rn.nextInt(enemies.length)];

            System.out.println("\n\t#" + enemy + " has appeared ! #\n");
            while (enemyHealth > 0) {
//                System.out.println("\t");
                System.out.println("\tYour HP: " + heroHealth);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);

                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion(" + numHealthPotions + " now).");
                System.out.println("\t3. Run!\n");
                System.out.print("\thero@dungeon: #");
                String input = sn.nextLine();

                if (input.equals("1")) {
                    int damageDealt = rn.nextInt(heroAttackDamage);
                    int damageTaken = rn.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    heroHealth -= damageTaken;

                    System.out.println("\n\t> You hit the " + enemy + ". " + damageDealt + " damage dealt.");
                    System.out.println("\t> You recieve " + damageTaken + " damage in the figth!.");

                    if (heroHealth < 1) {
                        System.out.println("\t> You are too week to go on\n");
                        break;
                    }

                } else if (input.equals("2")) {
                    if (numHealthPotions > 0) {
                        heroHealth += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\n\t> You drink a health potion. " + healthPotionHealAmount + "+ to your current HP"
                                + "\n\tHP now " + heroHealth
                                + "\n\tAmount Health Potions now " + numHealthPotions + "\n");
                    } else {
                        System.out.println("\n\t> You dont have any health potion anymore. Kill enemy for a chance get health potion\n");
                    }

                } else if (input.equals("3")) {
                    System.out.println("\t>You run away from the " + enemy + "");
                    System.out.println("=============================================");
                    continue GAME;
                } else {
                    System.out.println("\tInvalid command\n");
                }
            }
            if (heroHealth < 1) {
                System.out.println(">You are too week for the battle.\n");
                break;
            }
            System.out.println("=============================================");
            System.out.println("# " + enemy + " was defeated #");
            System.out.println("# Your health : " + heroHealth + " Left");
            if (rn.nextInt(100) > healthPotionDropChance) {
                numHealthPotions++;
                System.out.println("# The " + enemy + " dropped a health potion! #");
                System.out.println("# Now you have " + numHealthPotions + " health potion(s). #");
            }
            System.out.println("=============================================");
            System.out.println("What your next move?");
            System.out.println("1. Continue fighting");
            System.out.println("2. End the journey");
            System.out.print("hero@dungeon: ");
            String input = sn.nextLine();
            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command");
                System.out.print("hero@dungeon: ");

                input = sn.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("You take another step through the dungeon");
                continue;
            } else if (input.equals("2")) {
                System.out.println("#########################################");
                System.out.println("That's was a nice story. ~Fin");
                break;
            }
        }
        System.out.println("###############");
        System.out.println("Thanks!");
        System.out.println("Inspired by : https://www.youtube.com/watch?v=EpB9u4ItOYU");
        System.out.println("Re-coded");

    }
}
