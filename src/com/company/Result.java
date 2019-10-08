package com.company;

import java.util.Date;

public class Result {
    String winner;
    String winnerMove;
    String loser;
    String loserMove;
    Date date;
    boolean tie;

    public Result(String winner, String winnerMove, String loser, String loserMove, Date date, boolean tie){
        this.winner = winner;
        this.winnerMove = winnerMove;
        this.loser = loser;
        this.loserMove = loserMove;
        this.date = date;
        this.tie = tie;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getWinnerMove() {
        return winnerMove;
    }

    public void setWinnerMove(String winnerMove) {
        this.winnerMove = winnerMove;
    }

    public String getLoser() {
        return loser;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }

    public String getLoserMove() {
        return loserMove;
    }

    public void setLoserMove(String loserMove) {
        this.loserMove = loserMove;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isTie() {
        return tie;
    }

    public void setTie(boolean tie) {
        this.tie = tie;
    }
}
