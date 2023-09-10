package FootballLeague;

import java.util.Arrays;
import java.util.Comparator;

public class League {
    public static void main(String[] args) {
        Fixture fixture = new Fixture(18);

        //18 takım olacağından 18 yazarız.

        Teams[] teams = new Teams[18];

        for (int i = 0; i < teams.length; i++) {
            teams[i] = new Teams("Team " + (i + 1), 0);
        }

        //Burada 18 takımı oluşturur.

        fixture.createFixture();

        Matches matchHandler = new Matches();
        for (int week = 1; week <= fixture.getTotalRounds() * 2; week++) {
            System.out.println("Week " + week + ":");

            //Toplam hafta sayısı kadar haftaları yazar.

            for (int match = 0; match < fixture.getMatchesPerRound(); match++) {
                String homeTeamName = fixture.getHomeTeam(week - 1, match);
                String awayTeamName = fixture.getAwayTeam(week - 1, match);
                Teams homeTeam = findTeam(teams, homeTeamName);
                Teams awayTeam = findTeam(teams, awayTeamName);

                matchHandler.match(homeTeam, awayTeam);
            }

            //Burada tüm haftların maçlarını oynatan işlemler mavcut.

            Arrays.sort(teams, (team1, team2) -> {
                int scoreComparison = Integer.compare(team2.getTeamScore(), team1.getTeamScore());

                if (scoreComparison == 0) {
                    return Double.compare(team2.getGoalAverage(), team1.getGoalAverage());
                }
                return scoreComparison;
            });
            System.out.println("");

            //Takımları puan sıralamasına göre sıralar.

            for (Teams team : teams) {
                System.out.printf("Takım Gücü:\t\t\t\t\t\t\t\t\t\t\tTakım İsmi:\t\t\tTakım İstatistikleri:%n");
                System.out.println("AP:" + String.format("%.2f", team.getAveragePower()) + " " + "DP:" + String.format("%.2f", team.getDefensePower())
                        + " " + "MP:" + String.format("%.2f", team.getMiddlePower()) + " " + "SP:" + String.format("%.2f", team.getAttackPower())
                        + " " + "GP:" + String.format("%.2f", team.getGoalKeeperPower())
                        + "\t\t" + team.getTeamName() + "\t\t\t\t"
                        + "P:" + team.getTeamScore()
                        + "  " + "O:" + team.getMatchCount() +
                        "  " + "G:" + team.getWin()
                        + "  " + "M:" + team.getLose() + "  " + "B:" + team.getDraw() + "  "
                        + "A:" + team.getGoalA() + "  " + "Y:" + team.getGoalY()
                        + "  " + "Av:" + team.getGoalAverage() + "  "
                );
            }


            //Haftanın sonuçlarını ekrana basar.

            System.out.println();
        }
    }

    private static Teams findTeam(Teams[] teams, String teamName) {
        for (Teams team : teams) {
            if (team.getTeamName().equals(teamName)) {
                return team;
            }
        }
        return null;
    }
}

//Takım adına göre takımları bulup matchHandler.match içine atar.
