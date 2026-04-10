package src;

import java.util.Random;

public class GameLogic {

    public static void heroAttacks(Dragon[] dragons, int choice, int heroDamage, Random rng) {
        int index = choice - 1;

        if (index < 0 || index >= dragons.length) {
            System.out.println("Invalid choice. You wasted your turn!");
            return;
        }

        if (!dragons[index].isAlive()) {
            System.out.println("Dragon is already dead. You wasted your turn!");
            return;
        }

        int damage = rng.nextInt(heroDamage) + 1;
        dragons[index].hitPoints -= damage;

        System.out.println("\nHero attacks Dragon " + choice + " for " + damage + " damage!");

        if (dragons[index].hitPoints <= 0) {
            AsciiArt.printDeadDragon();
            System.out.println("Dragon " + choice + " has been slain!");
        }
    }

    public static int dragonAttacks(Dragon[] dragons, int heroHP, Random rng) {
        System.out.println("\nThe dragons attack!");

        for (int i = 0; i < dragons.length; i++) {
            if (dragons[i].isAlive()) {
                int dmg = rng.nextInt(dragons[i].damage) + 1;
                heroHP -= dmg;
                System.out.println("Dragon " + (i + 1) + " hits for " + dmg);
            } else {
                System.out.println("Dragon " + (i + 1) + " is dead.");
            }
        }

        return heroHP;
    }

    public static void gameEnd(boolean victory) {
        if (victory) {
            AsciiArt.printVictory();
        } else {
            AsciiArt.printDefeat();
        }
    }

    public static boolean allDead(Dragon[] dragons) {
        for (Dragon d : dragons) {
            if (d.isAlive()) {
                return false;
            }
        }
        return true;
    }

    public static void showStatus(int heroHP, Dragon[] dragons) {
        System.out.println("\n========== STATUS ==========");
        System.out.println("Hero HP: " + heroHP);

        for (int i = 0; i < dragons.length; i++) {
            if (dragons[i].isAlive()) {
                System.out.println("Dragon " + (i + 1) + ": " + dragons[i].hitPoints + " HP");
            } else {
                System.out.println("Dragon " + (i + 1) + ": DEAD");
            }
        }

        System.out.println("============================");
    }
}