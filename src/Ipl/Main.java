package Ipl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static final String MATCHES_PATH = "src/Resources/matches.csv";
    private static final String DELIVERIES_PATH = "src/Resources/deliveries.csv";

    public static final int MATCH_ID = 0;
    public static final int MATCH_SEASON = 1;
    public static final int MATCH_CITY = 2;
    public static final int MATCH_DATE = 3;
    public static final int MATCH_TEAM1 = 4;
    public static final int MATCH_TEAM2 = 5;
    public static final int MATCH_TOSS_WINNER = 6;
    public static final int MATCH_TOSS_DECISION = 7;
    public static final int MATCH_RESULT = 8;
    public static final int MATCH_DL_APPLIED = 9;
    public static final int MATCH_WINNER = 10;
    public static final int MATCH_WIN_BY_RUNS = 11;
    public static final int MATCH_WIN_BY_WICKETS = 12;
    public static final int MATCH_PLAYER_OF_MATCH = 13;
    public static final int MATCH_VENUE = 14;
    public static final int MATCH_UMPIRE1 = 15;
    public static final int MATCH_UMPIRE2 = 16;
    public static final int MATCH_UMPIRE3 = 17;

    public static final int DELIVERIES_MATCH_ID = 0;
    public static final int DELIVERIES_INNING = 1;
    public static final int DELIVERIES_BATTING_TEAM = 2;
    public static final int DELIVERIES_BOWLING_TEAM = 3;
    public static final int DELIVERIES_OVER = 4;
    public static final int DELIVERIES_BALL = 5;
    public static final int DELIVERIES_BATSMAN = 6;
    public static final int DELIVERIES_NON_STRIKER = 7;
    public static final int DELIVERIES_BOWLER = 8;
    public static final int DELIVERIES_IS_SUPER_OVER = 9;
    public static final int DELIVERIES_WIDE_RUNS = 10;
    public static final int DELIVERIES_BYE_RUNS = 11;
    public static final int DELIVERIES_LEG_BYE_RUNS = 12;
    public static final int DELIVERIES_NO_BALL = 13;
    public static final int DELIVERIES_PENALTY_RUNS = 14;
    public static final int DELIVERIES_BATSMAN_RUNS = 15;
    public static final int DELIVERIES_EXTRA_RUNS = 16;
    public static final int DELIVERIES_TOTAL_RUNS = 17;
    public static final int DELIVERIES_PLAYER_DISMISSED = 18;
    public static final int DELIVERIES_DISMISSAL_KIND = 19;
    public static final int DELIVERIES_FIELDER = 20;

    //This will read the matches.csv
    public static List<Match> fetchMatches() {
        List<Match> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(MATCHES_PATH))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                Match match = new Match();
                match.setId(Integer.parseInt(parts[MATCH_ID]));
                match.setSeason(Integer.parseInt(parts[MATCH_SEASON]));
                match.setCity(parts[MATCH_CITY]);
                match.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(parts[MATCH_DATE]));
                match.setTeam1(parts[MATCH_TEAM1]);
                match.setTeam2(parts[MATCH_TEAM2]);
                match.setTossWinner(parts[MATCH_TOSS_WINNER]);
                match.setTossDecision(parts[MATCH_TOSS_DECISION]);
                match.setResult(parts[MATCH_RESULT]);
                match.setDlApplied(Integer.parseInt(parts[MATCH_DL_APPLIED]) == 1);
                match.setWinner(parts[MATCH_WINNER]);
                match.setWinByRuns(Integer.parseInt(parts[MATCH_WIN_BY_RUNS]));
                match.setWinByWickets(Integer.parseInt(parts[MATCH_WIN_BY_WICKETS]));
                match.setPlayerOfMatch(parts[MATCH_PLAYER_OF_MATCH]);
                match.setVenue(parts[MATCH_VENUE]);
                match.setUmpire1(parts[MATCH_UMPIRE1]);
                match.setUmpire2(parts[MATCH_UMPIRE2]);
                match.setUmpire3(parts[MATCH_UMPIRE3]);
                list.add(match);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    //For deliveries.csv
    public static List<Delivery> fetchDeliveries() {
        List<Delivery> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DELIVERIES_PATH))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                Delivery delivery = new Delivery();
                delivery.setMatchId(Integer.parseInt(parts[DELIVERIES_MATCH_ID]));
                delivery.setInning(Integer.parseInt(parts[DELIVERIES_INNING]));
                delivery.setBattingTeam(parts[DELIVERIES_BATTING_TEAM]);
                delivery.setBowlingTeam(parts[DELIVERIES_BOWLING_TEAM]);
                delivery.setOver(Integer.parseInt(parts[DELIVERIES_OVER]));
                delivery.setBall(Integer.parseInt(parts[DELIVERIES_BALL]));
                delivery.setBatsman(parts[DELIVERIES_BATSMAN]);
                delivery.setNonStriker(parts[DELIVERIES_NON_STRIKER]);
                delivery.setBowler(parts[DELIVERIES_BOWLER]);
                delivery.setSuperOver(Integer.parseInt(parts[DELIVERIES_IS_SUPER_OVER]) == 1);
                delivery.setWideRuns(Integer.parseInt(parts[DELIVERIES_WIDE_RUNS]));
                delivery.setByeRuns(Integer.parseInt(parts[DELIVERIES_BYE_RUNS]));
                delivery.setLegByeRuns(Integer.parseInt(parts[DELIVERIES_LEG_BYE_RUNS]));
                delivery.setNoBallRuns(Integer.parseInt(parts[DELIVERIES_NO_BALL]));
                delivery.setPenaltyRuns(Integer.parseInt(parts[DELIVERIES_PENALTY_RUNS]));
                delivery.setBatsmanRuns(Integer.parseInt(parts[DELIVERIES_BATSMAN_RUNS]));
                delivery.setExtraRuns(Integer.parseInt(parts[DELIVERIES_EXTRA_RUNS]));
                delivery.setTotalRuns(Integer.parseInt(parts[DELIVERIES_TOTAL_RUNS]));
                delivery.setPlayerDismissed(parts[DELIVERIES_PLAYER_DISMISSED]);
                delivery.setDismissalKind(parts[DELIVERIES_DISMISSAL_KIND]);
                delivery.setFielder(parts[DELIVERIES_FIELDER]);
                list.add(delivery);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        List<Match> matches = fetchMatches();
        List<Delivery> deliveries = fetchDeliveries();
        
        matchesPerYear(matches);

    }

    private static void matchesPerYear(List<Match> matches) {
        TreeMap<Integer,Integer> hm = new TreeMap<>();//TreeMap for sorting the Year

        for (int i = 0; i < matches.size(); i++) {
            int year = matches.get(i).getSeason();
            hm.put(year, hm.getOrDefault(year,0)+1);
        }

        for (int key : hm.keySet()){
            System.out.println(hm.get(key) + " matches played in year "+ key);
        }
    }
}
