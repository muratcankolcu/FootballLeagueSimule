package FootballLeague;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fixture {

    private List<String> teams;
    private int totalRounds;
    private int matchesPerRound;
    private String[][] fixtures;

    //Burada tanımlama işlemlerini yaptım.

    public Fixture(int teamCount) {
        teams = new ArrayList<>();
        for (int i = 1; i <= teamCount; i++) {
            teams.add("Team " + i);
        }
        totalRounds = teams.size() - 1;
        matchesPerRound = teams.size() / 2;
        shuffleTeams();
        generateFixtures();
    }
    private void shuffleTeams() {
        Collections.shuffle(teams);
    }

    //Takım sayısının değerini alan constructor oluşturdum.
    //teams adlı ArrayListe takımları takım sayısı kadar oluşturup atacak. Team 1, Team 2 gibi.
    //totalRounds, takım sayısının 1 eksiğidir. Çünkü 18 takım var ve 17 maç oynanacak 1 dönem için.
    //matchesPerRound, takım sayısının yarısıdır. Çünkü hafta hafta kaç tane maç oynanacağını söyler. 18 takım var, her hafta 9 maç oynanır.
    //generateFixtures() metodu da çağırılaacak.

    public String getHomeTeam(int round, int match) {

        return fixtures[round][match * 2];
    }

    public String getAwayTeam(int round, int match) {
        return fixtures[round][match * 2 + 1];
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public int getMatchesPerRound() {
        return matchesPerRound;
    }

    private void generateFixtures() {
        fixtures = new String[totalRounds * 2][matchesPerRound * 2];
        for (int round = 0; round < totalRounds * 2; round++) {
            for (int match = 0; match < matchesPerRound; match++) {
                int homeIndex = (round - match + totalRounds) % totalRounds;
                int awayIndex = (round + match) % totalRounds;

                if (match == 0) {
                    homeIndex = teams.size() - 1;
                }

                String homeTeam = teams.get(homeIndex);
                String awayTeam = teams.get(awayIndex);

                //fixtures dizisini oluşturup diziye toplam round ve haftalık maçları alır.
                //Burada home ve away takımlarının indekslerini ayarlama işlemleri mevcut.
                //match==0 iken deplasman takımı 17 olur ki orada son takım olur ev takımı.
                //Mesela round=0, match=0 olsun.
                //homeIndex=17
                //awwayIndex=0
                //round=0, match=1 olsun. homeIndex(0-1+17)%17=16%17=16 olur.
                //awayIndex(0+1)%17=1%17=1 olur.
                //round=0, match=2 olsun. homeIndex(0-2+17)%17=15%17=15 olur.
                //awayIndex(0+2)%17=2%17=2 olur.
                //homeTeam ve awayTeam e bu indexler atanır.

                if (round >= totalRounds) {
                    String temp = homeTeam;
                    homeTeam = awayTeam;
                    awayTeam = temp;
                }

                //round sayısı 17 yi geçerse ev ve deplasman takımları yer değiştirir burada.

                fixtures[round][match * 2] = homeTeam;
                fixtures[round][match * 2 + 1] = awayTeam;

                //Burada da fixtures dizisinin içine ev ve deplasman takımlarının alacağı indeksleri atıyoruz.

            }
        }
    }
    public void createFixture() {

        for (int round = 0; round < totalRounds * 2; round++) {
            System.out.println("Week " + (round + 1) + ":");


            for (int match = 0; match < matchesPerRound; match++) {
                String homeTeam = getHomeTeam(round, match);
                String awayTeam = getAwayTeam(round, match);
                System.out.println(homeTeam + " vs " + awayTeam);
            }
            System.out.println("");
        }
    }

    //Fikstürü ekrana yazan metoddur.
    //İlk döngüde roundu totalRounds*2'ye kadar arttırır. Çünkü, toplam 34 hafta olacak ve haafta sayılarını yazdırır.
    //İkinci döngüde bir haftada kaç tane maç oynanacaksa oraya kadar matchi arttırır ve getlerle birlikte ev ve deplasman takımları alınır.
    //Diyelim round 0 yani week 1 olur. Match de 0 yani o haftanın ilk karşılaşması olur.
    //getHomeTeam için mesela (round,match)->(0,0)->(0,1)->(0,2)----->>>>(33,8)
    //getAwayTeam için mesela (round,match)->(0,0)->(0,1)->(0,2)----->>>>(33,8)
}
