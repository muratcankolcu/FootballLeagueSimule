package FootballLeague;

import java.util.Objects;

public class Players {
    private String position;
    private double average;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    PlayerAttributes playerAttributes = new PlayerAttributes();

    public Players(String position) {
        this.position = position;
        double total = 0;
        double total2 = 0;
        double carpim = 0;

        if (Objects.equals(position, "Defense")) {
            for (int i = 0; i < 25; i++) {
                int x = playerAttributes.generateRandom(15, 20);
                total+=x;
            }
            for (int i = 0; i < 11; i++) {
                total2 += playerAttributes.generateRandom(1, 10);
                carpim += (int) (total2 * 0.2);
            }
            average = (total + carpim) / 36;
        } else if (Objects.equals(position, "Midfielder")) {
            for (int i = 0; i < 28; i++) {
                total += playerAttributes.generateRandom(12, 20);
            }
            for (int i = 0; i < 8; i++) {
                total2 += playerAttributes.generateRandom(1, 15);
                carpim += (int) (total2 * 0.2);
            }
            average = (total + carpim) / 36;
        } else if (Objects.equals(position, "Striker")) {
            for (int i = 0; i < 28; i++) {
                total += playerAttributes.generateRandom(12, 20);
            }
            for (int i = 0; i < 8; i++) {
                total2 += playerAttributes.generateRandom(1, 15);
                carpim += (int) (total2 * 0.2);
            }
            average = (total + carpim) / 36;
        } else if (Objects.equals(position, "GoalKeeper")) {
            for (int i = 0; i < 26; i++) {
                total += playerAttributes.generateRandom(12, 20);
            }
            for (int i = 0; i < 12; i++) {
                total2 += playerAttributes.generateRandom(1, 15);
                carpim += (int) (total2 * 0.2);
            }
            average = (total + carpim) / 36;
        }
    }
}
