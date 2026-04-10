public class Dragon {
    String name;
    int hitPoints;
    int damage;
    int x;
    int y;

    public Dragon(String name, int x, int y) {
        this.name = name;
        this.hitPoints = 100;
        this.damage = 20;
        this.x = x;
        this.y = y;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }
}