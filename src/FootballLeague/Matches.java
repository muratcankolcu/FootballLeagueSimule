package FootballLeague;

public class Matches {
    public void match(Teams team1, Teams team2) {
        double randomHomeAttack = team1.getAttackPower()*1.2;
        double randomAwayAttack = team2.getAttackPower();
        double randomHomeDefense = team1.getDefensePower()*1.2;
        double randomAwayDefense = team2.getDefensePower();

        double t = 2.5;
        int goal =0;
        int goal2=0;

        int homeAttackNumber = (int) ((Math.random() * (team1.getAttackPower()) + 1));
        int awayAttackNumber = (int) ((Math.random() * (team2.getAttackPower()) + 1));

        for (int i = 0; i < homeAttackNumber; i++) {
            double result = (randomHomeAttack / randomAwayDefense) + t;
            double randomValue = ((Math.random()) * (result));

            if (randomValue > t) {
                goal++;
            }
        }

        for (int j=0; j<awayAttackNumber;j++){
            double  result2=(randomAwayAttack/randomHomeDefense)+t;
            double randomValue2= ((Math.random()) * (result2));

            if(randomValue2>t){
                goal2++;
            }
        }

        if(goal>goal2){
            System.out.println(team1.getTeamName() + "  " + goal + " - " + goal2 + "  " + team2.getTeamName());
            team1.setWin(1);
            team2.setLose(1);
            team1.setGoalA(goal);
            team2.setGoalY(goal);
            team1.setGoalY(goal2);
            team2.setGoalA(goal2);
            team1.setTeamScore(3);
            team2.setTeamScore(0);
            team1.setMatchCount(1);
            team2.setMatchCount(1);
            team1.setGoalAverage (goal-goal2);
            team2.setGoalAverage (goal2-goal);
        } else if (goal2>goal) {
            System.out.println(team1.getTeamName() + "  " + goal + " - " + goal2 + "  " + team2.getTeamName());
            team2.setWin(1);
            team1.setLose(1);
            team1.setGoalA(goal);
            team2.setGoalY(goal);
            team1.setGoalY(goal2);
            team2.setGoalA(goal2);
            team1.setTeamScore(0);
            team2.setTeamScore(3);
            team1.setMatchCount(1);
            team2.setMatchCount(1);
            team1.setGoalAverage(goal-goal2);
            team2.setGoalAverage (goal2-goal);
        }
        else{
            System.out.println(team1.getTeamName() + "  " + goal + " - " + goal2 + "  " + team2.getTeamName());
            team2.setDraw(1);
            team1.setDraw(1);
            team1.setGoalA(goal);
            team2.setGoalY(goal);
            team1.setGoalY(goal2);
            team2.setGoalA(goal2);
            team1.setTeamScore(1);
            team2.setTeamScore(1);
            team1.setMatchCount(1);
            team2.setMatchCount(1);
            team1.setGoalAverage (goal-goal2);
            team2.setGoalAverage (goal2-goal);
        }
    }
}
