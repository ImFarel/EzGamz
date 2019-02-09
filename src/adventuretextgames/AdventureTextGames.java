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
        Scanner sn = new Scanner(System.in); //Object Variabel untuk semua inputan
        Random rn = new Random(); //Object Variabel untuk menggenerate angka random

        String[] enemies = {"Skeleton", "Zombie", "Rogue", "Assassin"}; //Variabel String untuk mendefinisikan List musuh yang tersedia
        int maxEnemyHealth = 100; // Variabel integer untuk mendefinisikan Maximal Health Musuh
        int enemyAttackDamage = 26; // Variabel integer untuk mendefinisikan Maximal serangan musuh

        int heroHealth = 100; // Variabel HP player secara default
        int heroAttackDamage = 50; // Var Max damage yang di berikan hero ke musuh
        int numHealthPotions = 3; // Var Default jumlah health potion player ketika memulai permainan
        int healthPotionHealAmount = 50; // var max heal player menggunakan potion
        int healthPotionDropChance = 30; // var batasan kemungkinan musuh ketika kalah men-drop health potion

        boolean start; // variabel status game mulai atau tidak (true / false)
        /*
        Ketika menjalan kan file ini
        akan muncul menu berikut
        user memilih mau mulai atai tidak
        Mulai = 1
        Exit = 2
         */
        System.out.println("####### Welcome to the Dungeon!");
        System.out.println("####### Start the journey?!");
        System.out.println("####### > 1. Start");
        System.out.println("####### > 2. Exit");
        System.out.print("####### > ");
        String menu = sn.nextLine(); //Inputan menu mulai atau tidak
        if (menu.equals("1")) { // Validasi inputan menu jika user memilih 1
            start = true; // Maka variabel START ber-isi TRUE dan memulai
        } else {// jika yang lain nya/ 2
            start = false;// Maka variabel START ber-isi FALSE dan keluar
        }

        GAME: //Ini ada lah TAG untuk sintak WHILE di bawah ini while(start) nah itu di beri nama GAME
        while (start) {// while ber TAG GAME ini untuk meng-inisialisasi game sudah mulai
            /*
            Jadi ter dapat aktifitas
            1. Player Bertemu musuh
            2. Player memilih Action nya
            3. Player menang/kalah
             */

            System.out.println("=============================================");
            // Disini kita melakukan Random untuk meng-init jumlah HP musuh.
            //Mengenerate random angka dari 0 sampai jumlah var maxEnemyHealth(100) [0 ... 100]Random
            int enemyHealth = rn.nextInt(maxEnemyHealth);

            //Disini kita melakikan Random untuk meng generate nama musuh.
            //Menggenerate dari variabel enemies[] karena array kita tinggal random indeks nya saja.
            String enemy = enemies[rn.nextInt(enemies.length)];
            //rn.nextInt(enemies.length) ketiaka di eksekusi. jika di baca | Generate angka random sepanjang indeks dari array enemies (lenghtnya 4)
            //{"Skeleton", "Zombie", "Rogue", "Assassin"}
            //  indeks 0   indeks 1  indeks 2  indeks 3     (Jadi length nya 4)

            // Note:Escape Sequence \n = ENTER atau Line Baru
            // Note:Escape Sequence \t = 1 Tab

            //Print Nama musuh
            System.out.println("\n\t#" + enemy + " has appeared ! #\n");
            while (enemyHealth > 0) { //Validasi jika health hero masih di atas 0 maka belom game over
                //Print HP player
                System.out.println("\tYour HP: " + heroHealth);
                //Print HP musuh
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                //Menu aksi
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack"); //Serang
                System.out.println("\t2. Drink health potion(" + numHealthPotions + " left)."); //gunakan Potion health
                System.out.println("\t3. Run!\n"); //Lari
                System.out.print("\thero@dungeon: #");
                String input = sn.nextLine();// inputan menu aksi

                if (input.equals("1")) { //Jika inputan Aksi menu adalah 1
                    int damageDealt = rn.nextInt(heroAttackDamage); //Random serangan dari hero ke musuh. jadi Random dari range 0 - var heroAttackDamage(50)
                    int damageTaken = rn.nextInt(enemyAttackDamage); //Random serangan dari musuh ke hero. jadi Random dari range 0 - var enemyAttackDamage(26)

                    enemyHealth -= damageDealt; // dari variabel damageDealt kita kurangi dengan health musuh
                    heroHealth -= damageTaken; // dari variabel damageTaken kita kurangi dengan health hero

                    System.out.println("\n\t> You hit the " + enemy + ". " + damageDealt + " damage dealt.");
                    System.out.println("\t> You recieve " + damageTaken + " damage in the figth!.");

                    if (heroHealth < 1) { //Jika ketika pengurangan health hero adalah di bawah 1 maka dia kalah
                        System.out.println("\t> You are too week to go on\n");
                        break;
                    }

                } else if (input.equals("2")) { //Jika inputan Aksi menu adalah 2

                    if (numHealthPotions > 0) { //Validasi terlebih dahulu apakah heri memiliki Health potion
                        heroHealth += healthPotionHealAmount; //tambah health hero sebesar 50
                        numHealthPotions--; //Mengurangi jumlah potion yang ada
                        System.out.println("\n\t> You drink a health potion. "
                                + healthPotionHealAmount + "+ to your current HP"
                                + "\n\tHP now " + heroHealth
                                + "\n\tAmount Health Potions now " + numHealthPotions + "\n");

                    } else {// Jika tidak punya, ya ga nambah
                        System.out.println("\n\t> You dont have any health potion anymore. Kill enemy for a chance get health potion\n");
                    }

                } else if (input.equals("3")) { //Jika inputan Aksi menu adalah 3
                    System.out.println("\t>You run away from the " + enemy + ""); //Print kalo hero kabur dari musuh nya
                    System.out.println("=============================================");
                    continue GAME; // DAN KEMBALI KE KONDISI WHILE BER TAG GAME
                } else {
                    System.out.println("\tInvalid command\n"); //Kalo pilihan menu aksi tidak valid
                }

            }

            if (heroHealth < 1) { // Ketika health Hero kurang dari 1. then kalah
                System.out.println(">You are too week for the battle.\n");
                break;
            }

            //Bakalan masuk ke bawah ini kalo sudah kalahin musuh
            //Summary fight barusan
            System.out.println("=============================================");
            System.out.println("# " + enemy + " was defeated #");
            System.out.println("# Your health : " + heroHealth + " Left");
            if (rn.nextInt(100) > healthPotionDropChance) { //Ini random kemungkinan dapet health potion dari musuh yang kalah
                numHealthPotions++; //nambah
                System.out.println("# The " + enemy + " dropped a health potion! #");
                System.out.println("# Now you have " + numHealthPotions + " health potion(s). #");
            }
            //nah ini pilihan jika user mau lanjut main apa engga
            System.out.println("=============================================");
            System.out.println("What your next move?");
            System.out.println("1. Continue fighting");
            System.out.println("2. End the journey");
            System.out.print("hero@dungeon: ");
            String input = sn.nextLine(); //inputan
            while (!input.equals("1") && !input.equals("2")) { //Validaasi menu
                System.out.println("Invalid command");
                System.out.print("hero@dungeon: ");

                input = sn.nextLine();
            }

            if (input.equals("1")) { //Kalo pilihan nya 1
                System.out.println("You take another step through the dungeon");
                continue GAME; //Maka lanjut dan masuk KE WHILE GAME
            } else if (input.equals("2")) {//Kalo 2
                System.out.println("#########################################");
                System.out.println("That's was a nice story. ~Fin");
                break; // Ya kelar
            }
        }
        System.out.println("###############");
        System.out.println("Thanks!");
        System.out.println("Inspired by : https://www.youtube.com/watch?v=EpB9u4ItOYU");
        System.out.println("Re-coded");

    }
}
