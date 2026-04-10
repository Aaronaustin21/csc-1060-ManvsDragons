import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rng = new Random();

        AsciiArt.intro();

        System.out.print("Enter hero name: ");
        String name = scanner.nextLine();

        System.out.print("Enter hero HP: ");
        int hp = scanner.nextInt();

        System.out.print("Enter hero damage: ");
        int dmg = scanner.nextInt();

        Hero hero = new Hero(name, hp, dmg);

        Dragon[] dragons = new Dragon[3];
        Dungeon dungeon = new Dungeon();
        dungeon.placeDragons(dragons);

        while (true) {

            System.out.println("\nHero at (" + hero.x + "," + hero.y + ")");
            for (Dragon d : dragons) {
                System.out.println(d.name + " at (" + d.x + "," + d.y + ") HP: " + d.hitPoints);
            }

            System.out.print("\nMove X: ");
            int x = scanner.nextInt();
            System.out.print("Move Y: ");
            int y = scanner.nextInt();

            hero.move(x, y);

            System.out.print("Choose dragon (1-3): ");
            int choice = scanner.nextInt();

            BattleEngine.heroAttack(hero, dragons[choice - 1], rng);

            if (BattleEngine.allDead(dragons)) {
                AsciiArt.victory();
                break;
            }

            BattleEngine.dragonsAttack(hero, dragons, rng);

            if (!hero.isAlive()) {
                AsciiArt.defeat();
                break;
            }
        }

        scanner.close();
    }
}