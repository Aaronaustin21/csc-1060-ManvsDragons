import java.util.Random;

public class BattleEngine {

    public static void heroAttack(Hero hero, Dragon dragon, Random rng) {
        if (!dragon.isAlive()) {
            System.out.println(dragon.name + " is already dead.");
            return;
        }

        if (hero.x != dragon.x || hero.y != dragon.y) {
            System.out.println("You are not at the dragon's location!");
            return;
        }

        int dmg = rng.nextInt(hero.damage) + 1;
        dragon.hitPoints -= dmg;

        System.out.println(hero.name + " attacks " + dragon.name + " for " + dmg);

        if (dragon.hitPoints <= 0) {
            System.out.println(dragon.name + " has been slain!");
            AsciiArt.printDeadDragon();
        }
    }

    public static void dragonsAttack(Hero hero, Dragon[] dragons, Random rng) {
        System.out.println("\nDragons attack!");

        for (Dragon d : dragons) {
            if (d.isAlive()) {
                int dmg = rng.nextInt(d.damage) + 1;
                hero.hitPoints -= dmg;
                System.out.println(d.name + " hits for " + dmg);
            }
        }
    }

    public static boolean allDead(Dragon[] dragons) {
        for (Dragon d : dragons) {
            if (d.isAlive()) return false;
        }
        return true;
    }
}