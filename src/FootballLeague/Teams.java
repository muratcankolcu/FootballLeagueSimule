package FootballLeague;

import java.util.Arrays;

public class Teams {
    private String teamName;
    private int teamScore;
    private int goalA;
    private int goalY;
    private int goalAverage;
    private double averagePower = 0;
    private double defensePower = 0;
    private double attackPower = 0;
    private double middlePower = 0;
    private double goalKeeperPower = 0;

    public double getGoalKeeperPower() {
        return goalKeeperPower;
    }

    public void setGoalKeeperPower(double goalKeeperPower) {
        this.goalKeeperPower = goalKeeperPower;
    }

    private int win;
    private int lose;
    private int draw;
    private int matchCount = 0;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(int teamScore) {
        this.teamScore += teamScore;
    }

    public double getAveragePower() {
        return averagePower;
    }

    public void setAveragePower(double averagePower) {
        this.averagePower = averagePower;
    }

    public double getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(double defensePower) {
        this.defensePower = defensePower;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }

    public double getMiddlePower() {
        return middlePower;
    }

    public void setMiddlePower(double middlePower) {
        this.middlePower = middlePower;
    }

    public int getGoalA() {
        return goalA;
    }

    public void setGoalA(int goalA) {
        this.goalA += goalA;
    }

    public int getGoalY() {
        return goalY;
    }

    public void setGoalY(int goalY) {
        this.goalY += goalY;
    }

    public int getGoalAverage() {
        return goalAverage;
    }

    public void setGoalAverage(int goalAverage) {
        this.goalAverage += goalAverage;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win += win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose += lose;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw += draw;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount += matchCount;
    }

    Players[] players = {
            new Players("GoalKeeper"),
            new Players("GoalKeeper"),
            new Players("GoalKeeper"),
            new Players("Defense"),
            new Players("Defense"),
            new Players("Defense"),
            new Players("Defense"),
            new Players("Defense"),
            new Players("Defense"),
            new Players("Defense"),
            new Players("Defense"),
            new Players("Defense"),
            new Players("Defense"),
            new Players("Midfielder"),
            new Players("Midfielder"),
            new Players("Midfielder"),
            new Players("Midfielder"),
            new Players("Midfielder"),
            new Players("Midfielder"),
            new Players("Striker"),
            new Players("Striker"),
            new Players("Striker"),
            new Players("Striker"),
            new Players("Striker"),
            new Players("Striker"),
    };

    public Teams(String teamName, int teamScore) {
        this.teamName = teamName;
        this.teamScore = teamScore;

        for (int i = 0; i < 25; i++) {
            averagePower += players[i].getAverage();
            if (players[i].getPosition().equals("Defense")) {
                defensePower += players[i].getAverage();
            }
            if (players[i].getPosition().equals("Striker")) {
                attackPower += players[i].getAverage();
            }
            if (players[i].getPosition().equals("Midfielder")) {
                middlePower += players[i].getAverage();
            }
            if (players[i].getPosition().equals("GoalKeeper")) {
                goalKeeperPower += players[i].getAverage();
            }
        }

        averagePower = averagePower / 25;
        defensePower = defensePower / 10;
        attackPower = attackPower / 6;
        middlePower = middlePower / 6;
        goalKeeperPower = goalKeeperPower / 3;
    }
}

