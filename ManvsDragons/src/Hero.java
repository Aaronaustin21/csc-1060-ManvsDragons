public class Hero {
    String name;
    int hitPoints;
    int damage;
    int x;
    int y;

    public Hero(String name, int hp, int dmg) {
        this.name = name;
        hitPoints = hp;
        damage = dmg;
        x = 0;
        y = 0;
    }

    public void move(int newX, int newY) {
        x = newX;
        y = newY;
        System.out.println(name + " moved to (" + x + ", " + y + ")");
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }
}