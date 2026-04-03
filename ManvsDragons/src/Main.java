import java.util.Random;
import java.util.Scanner;

class Dragon {
    int hitPoints;
    int damage;

    public Dragon(int hp, int dmg) {
        hitPoints = hp;
        damage = dmg;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }
}

public class Main {

    static void heroAttacks(Dragon[] dragons, int choice, int heroDamage, Random rng) {
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
            printDeadDragon();
            System.out.println("Dragon " + choice + " has been slain!");
        }
    }

    static int dragonAttacks(Dragon[] dragons, int heroHP, Random rng) {
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

    static void gameEnd(boolean victory) {
        System.out.println("\n======================================================");

        if (victory) {
            System.out.println("██╗   ██╗██╗ ██████╗████████╗ ██████╗ ██████╗ ██╗   ██╗");
            System.out.println("██║   ██║██║██╔════╝╚══██╔══╝██╔═══██╗██╔══██╗╚██╗ ██╔╝");
            System.out.println("██║   ██║██║██║        ██║   ██║   ██║██████╔╝ ╚████╔╝ ");
            System.out.println("╚██╗ ██╔╝██║██║        ██║   ██║   ██║██╔══██╗  ╚██╔╝  ");
            System.out.println(" ╚████╔╝ ██║╚██████╗   ██║   ╚██████╔╝██║  ██║   ██║   ");
            System.out.println("  ╚═══╝  ╚═╝ ╚═════╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ");
            System.out.println("\n   \\o/   The Hero stands victorious!");
            System.out.println("    |");
            System.out.println("   / \\");
        } else {
            System.out.println("██████╗ ███████╗███████╗███████╗ █████╗ ████████╗");
            System.out.println("██╔══██╗██╔════╝██╔════╝██╔════╝██╔══██╗╚══██╔══╝");
            System.out.println("██║  ██║█████╗  █████╗  █████╗  ███████║   ██║   ");
            System.out.println("██║  ██║██╔══╝  ██╔══╝  ██╔══╝  ██╔══██║   ██║   ");
            System.out.println("██████╔╝███████╗██║     ███████╗██║  ██║   ██║   ");
            System.out.println("╚═════╝ ╚══════╝╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   ");
            System.out.println("\n    x_x   The Hero has fallen...");
            System.out.println("    /|\\");
            System.out.println("    / \\");
        }

        System.out.println("======================================================");
    }

    static void printDeadDragon() {
        System.out.println("          x     x");
        System.out.println("           \\___/");
        System.out.println("          / RIP \\");
        System.out.println("         /_____\\");
    }

    static boolean allDead(Dragon[] dragons) {
        for (Dragon d : dragons) {
            if (d.isAlive()) return false;
        }
        return true;
    }

    static void showStatus(int heroHP, Dragon[] dragons) {
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

    public static void main(String[] args) {

        Random rng = new Random();
        Scanner scanner = new Scanner(System.in);

        // START ASCII ART
        System.out.println("===============================================");
        System.out.println("        HERO VS DRAGONS - PART 2");
        System.out.println("===============================================");
        System.out.println("                / \\  //\\\\");
        System.out.println("       |\\___/|      /   \\\\//  \\\\");
        System.out.println("       /O  O  \\__  /    //  | \\ \\");
        System.out.println("      /     /  \\/_/    //   |  \\  \\");
        System.out.println("      @___@'    \\/_   //    |   \\   \\");
        System.out.println("===============================================");

        System.out.print("Enter Hero HP: ");
        int heroHP = scanner.nextInt();

        System.out.print("Enter Hero Damage: ");
        int heroDamage = scanner.nextInt();

        Dragon[] dragons = new Dragon[3];
        for (int i = 0; i < dragons.length; i++) {
            dragons[i] = new Dragon(100, 20);
        }

        while (true) {

            showStatus(heroHP, dragons);

            System.out.print("\nChoose a dragon to attack (1-3): ");
            int choice = scanner.nextInt();

            heroAttacks(dragons, choice, heroDamage, rng);

            if (allDead(dragons)) {
                gameEnd(true);
                break;
            }

            heroHP = dragonAttacks(dragons, heroHP, rng);

            if (heroHP <= 0) {
                gameEnd(false);
                break;
            }
        }

        scanner.close();
    }
}