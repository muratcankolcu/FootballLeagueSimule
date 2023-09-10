package FootballLeague;

import java.util.Random;

public class PlayerAttributes {
    public  Random random = new Random();

    public  int generateRandom(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
