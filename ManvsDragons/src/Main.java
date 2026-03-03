import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rng = new Random();

        System.out.println("================================================================================");
        System.out.println("*************************");
        System.out.println("Welcome to Man vs. Dragons");
        System.out.println("*************************");
        System.out.println("================================================================================");
        System.out.println();
        System.out.println("                                __====-_  _-====__");
        System.out.println("                          _--^^^#####//      \\\\#####^^^--_");
        System.out.println("                       _-^##########// (    ) \\\\##########^-_");
        System.out.println("                      -############//  |\\^^/|  \\\\############-");
        System.out.println("                    _/############//   (@::@)   \\\\############\\_");
        System.out.println("                   /#############((     \\\\//     ))#############\\");
        System.out.println("                  -###############\\\\    (oo)    //###############-");
        System.out.println("                 -#################\\\\  / VV \\  //#################-");
        System.out.println("                -###################\\\\/      \\//###################-");
        System.out.println("               _#/|##########/\\######(   /\\   )######/\\##########|\\#_");
        System.out.println("               |/ |#/\\#/\\#/\\/  \\#/\\##\\  |  |  /##/\\#/  \\/\\#/\\#/\\#| \\|");
        System.out.println("               `  |/  V  V  `   V  \\#\\| |  | |/#/  V   '  V  V  \\|  '");
        System.out.println("                  `   `  `      `   / | |  | | \\   '      '  '   '");
        System.out.println("                                   (  | |  | |  )");
        System.out.println("                                  __\\ | |  | | /__");
        System.out.println("                                 (vvv(VVV)(VVV)vvv)");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("RULES: Choose a dragon to attack. Then each living dragon attacks you once.");
        System.out.println("END: Hero HP <= 0 (defeat) OR all dragons HP <= 0 (victory).");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();

        // Splash page
        System.out.println();
        String splashScreen = "";
        System.out.println(splashScreen);
        System.out.println();

        // Grab user configuration data points
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Hero hit points: ");
        int heroHP = scanner.nextInt();

        System.out.print("Enter Hero damage points (MAX damage): ");
        int heroDamage = scanner.nextInt();

        System.out.println("Hero has " + heroHP + " HP and can deal up to " + heroDamage + " points of damage");

        int dragon1HP = 100;
        int dragon1Damage = 20; // MAX damage
        int dragon2HP = 100;
        int dragon2Damage = 20; // MAX damage
        int dragon3HP = 100;
        int dragon3Damage = 20; // MAX damage

        System.out.println();
        System.out.println("dragons status:");
        System.out.println("-------------");
        System.out.println("Dragon 1 has " + dragon1HP + " HP and deals up to " + dragon1Damage + " points of damage");
        System.out.println("Dragon 2 has " + dragon2HP + " HP and deals up to " + dragon2Damage + " points of damage");
        System.out.println("Dragon 3 has " + dragon3HP + " HP and deals up to " + dragon3Damage + " points of damage");

        // start the battle until either the hero or all dragons are defeated
        while (true) {

            // when hero hit points are 0 or less, the hero is defeated and the game is over
            if (heroHP <= 0) {
                System.out.println();
                System.out.println("================================================================================");
                System.out.println("██████╗ ███████╗███████╗███████╗ █████╗ ████████╗");
                System.out.println("██╔══██╗██╔════╝██╔════╝██╔════╝██╔══██╗╚══██╔══╝");
                System.out.println("██║  ██║█████╗  █████╗  █████╗  ███████║   ██║   ");
                System.out.println("██║  ██║██╔══╝  ██╔══╝  ██╔══╝  ██╔══██║   ██║   ");
                System.out.println("██████╔╝███████╗██║     ███████╗██║  ██║   ██║   ");
                System.out.println("╚═════╝ ╚══════╝╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   ");
                System.out.println("================================================================================");
                System.out.println("                 x_x   The Hero has fallen...");
                System.out.println("                 /|\\");
                System.out.println("                 / \\");
                System.out.println("================================================================================");
                break;
            }

            // when all dragons are defeated, the hero wins
            if (dragon1HP <= 0 && dragon2HP <= 0 && dragon3HP <= 0) {
                System.out.println();
                System.out.println("================================================================================");
                System.out.println("██╗   ██╗██╗ ██████╗████████╗ ██████╗ ██████╗ ██╗   ██╗");
                System.out.println("██║   ██║██║██╔════╝╚══██╔══╝██╔═══██╗██╔══██╗╚██╗ ██╔╝");
                System.out.println("██║   ██║██║██║        ██║   ██║   ██║██████╔╝ ╚████╔╝ ");
                System.out.println("╚██╗ ██╔╝██║██║        ██║   ██║   ██║██╔══██╗  ╚██╔╝  ");
                System.out.println(" ╚████╔╝ ██║╚██████╗   ██║   ╚██████╔╝██║  ██║   ██║   ");
                System.out.println("  ╚═══╝  ╚═╝ ╚═════╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ");
                System.out.println("================================================================================");
                System.out.println("            \\o/   All dragons defeated! The Hero survives!");
                System.out.println("             |");
                System.out.println("            / \\");
                System.out.println("================================================================================");
                break;
            }

            // Simulate a turn of battle
            System.out.println("\n--- New Turn ---");
            System.out.println("Hero HP: " + heroHP);
            System.out.println("Dragon 1 HP: " + dragon1HP + (dragon1HP <= 0 ? " (DEAD)" : ""));
            System.out.println("Dragon 2 HP: " + dragon2HP + (dragon2HP <= 0 ? " (DEAD)" : ""));
            System.out.println("Dragon 3 HP: " + dragon3HP + (dragon3HP <= 0 ? " (DEAD)" : ""));

            // Ask which dragon to attack (assignment requirement)
            System.out.print("Which Dragon do you want to attack (1, 2, or 3): ");
            int dragonChoice = scanner.nextInt();

            // Hero attacks chosen dragon using Random (assignment requirement)
            int heroHit = rng.nextInt(heroDamage) + 1; // 1..heroDamage

            switch (dragonChoice) {
                case 1:
                    if (dragon1HP > 0) {
                        dragon1HP -= heroHit;
                        System.out.println("Hero attacks Dragon 1 for " + heroHit + " damage.");
                        if (dragon1HP <= 0) {
                            System.out.println(" Dragon 1 has been slain!");
                        }
                    } else {
                        System.out.println("Dragon 1 is already dead. You wasted your turn!");
                    }
                    break;

                case 2:
                    if (dragon2HP > 0) {
                        dragon2HP -= heroHit;
                        System.out.println("Hero attacks Dragon 2 for " + heroHit + " damage.");
                        if (dragon2HP <= 0) {
                            System.out.println(" Dragon 2 has been slain!");
                        }
                    } else {
                        System.out.println("Dragon 2 is already dead. You wasted your turn!");
                    }
                    break;

                case 3:
                    if (dragon3HP > 0) {
                        dragon3HP -= heroHit;
                        System.out.println("Hero attacks Dragon 3 for " + heroHit + " damage.");
                        if (dragon3HP <= 0) {
                            System.out.println(" Dragon 3 has been slain!");
                        }
                    } else {
                        System.out.println("Dragon 3 is already dead. You wasted your turn!");
                    }
                    break;

                default:
                    System.out.println("Invalid choice. You wasted your turn!");
                    break;
            }

            // Dragons attack the hero (Random damage required)
            System.out.println("\nThe dragons attack!");

            if (dragon1HP > 0) {
                int d1Hit = rng.nextInt(dragon1Damage) + 1; // 1..20
                heroHP -= d1Hit;
                System.out.println("Dragon 1 attacks Hero for " + d1Hit + " damage.");
            } else {
                System.out.println("Dragon 1 is dead and cannot attack.");
            }

            if (dragon2HP > 0) {
                int d2Hit = rng.nextInt(dragon2Damage) + 1;
                heroHP -= d2Hit;
                System.out.println("Dragon 2 attacks Hero for " + d2Hit + " damage.");
            } else {
                System.out.println("Dragon 2 is dead and cannot attack.");
            }

            if (dragon3HP > 0) {
                int d3Hit = rng.nextInt(dragon3Damage) + 1;
                heroHP -= d3Hit;
                System.out.println("Dragon 3 attacks Hero for " + d3Hit + " damage.");
            } else {
                System.out.println("Dragon 3 is dead and cannot attack.");
            }
        }

        scanner.close();
    }
}