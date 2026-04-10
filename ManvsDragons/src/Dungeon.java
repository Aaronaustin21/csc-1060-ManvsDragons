import java.util.Random;

public class Dungeon {
    int width = 5;
    int height = 5;

    public void placeDragons(Dragon[] dragons) {
        Random rng = new Random();

        for (int i = 0; i < dragons.length; i++) {
            int x = rng.nextInt(width);
            int y = rng.nextInt(height);

            dragons[i] = new Dragon("Dragon " + (i + 1), x, y);
        }
    }
}