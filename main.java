import java.util.ArrayList;
 class Team {
    private String name;
    private int wins;
    private int losses;
    
    public Team(String name) {
        this.name = name;
        this.wins = 0;
        this.losses = 0;
    }
    
    public void playMatch(Team opponent, boolean win) {
        if (win) {
            this.wins++;
            opponent.losses++;
        } else {
            this.losses++;
            opponent.wins++;
        }
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getWins() {
        return this.wins;
    }
    
    public int getLosses() {
        return this.losses;
    }
}

class Schedule {
    private Team[] teams;
    private List<Match> matches;
    
    public Schedule(Team[] teams) {
        this.teams = teams;
        this.matches = new ArrayList<>();
        this.generateSchedule();
    }
    
    private void generateSchedule() {
        for (int i = 0; i < teams.length; i++) {
            for (int j = i+1; j < teams.length; j++) {
                matches.add(new Match(teams[i], teams[j]));
            }
        }
    }
    
    public void playMatches() {
        for (Match match : matches) {
            boolean homeTeamWins = Math.random() < 0.5;
            match.play(homeTeamWins);
        }
    }
    
    public void printTeamStats() {
        for (Team team : teams) {
            System.out.println(team.getName() + " - Wins: " + team.getWins() + ", Losses: " + team.getLosses());
        }
    }
}

 class Match {
    private Team homeTeam;
    private Team awayTeam;
    
    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }
    
    public void play(boolean homeTeamWins) {
        homeTeam.playMatch(awayTeam, homeTeamWins);
    }
}

public class Main {
    public static void main(String[] args) {
        Team[] teams = new Team[] {
            new Team("IND"),
            new Team("ENG"),
            new Team("PAk"),
            new Team("SRILANKA"),
            new Team("USa")
        };
        
        Schedule schedule = new Schedule(teams);
        schedule.playMatches();
        schedule.printTeamStats();
    }
}
