package ohtu;

public class TennisGame {

    private int score1 = 0;
    private int score2 = 0;
    private String player1;
    private String player2;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = player1Name;
        this.player2 = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1)) {
            score1 += 1;
        } else {
            score2 += 1;
        }
    }

    public String getScore() {
        if (score1 == score2) {
            return scoreWhenEqual();
        } else if (score1 >= 4 || score2 >= 4) {
            return ScoreWhenBig();
        } else {
            return scoreWhenSmall();
        }
    }

    private String scoreWhenSmall() {
        return scoreName(score1) + "-" + scoreName(score2);
    }

    private String scoreName(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }

    private String ScoreWhenBig() {
        int difference = score1 - score2;
        String winner = difference > 0 ? player1 : player2;
        return bigScorePrefix(difference) + " " + winner;
    }

    private String bigScorePrefix(int difference) {
        difference = Math.abs(difference);
        if (difference == 1) {
            return "Advantage";
        } else {
            return "Win for";
        }
    }

    private String scoreWhenEqual() {
        switch (score1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }
}

