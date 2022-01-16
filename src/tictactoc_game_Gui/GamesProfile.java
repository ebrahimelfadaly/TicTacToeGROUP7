/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoc_game_Gui;

/**
 *
 * @author asus
 */
public class GamesProfile {
    private String username;
     private String gamesnum;
      private String gameswin;
      private String gameslose;
       private String gamestie;

    public GamesProfile() {
    }

    public GamesProfile(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGamesnum() {
        return gamesnum;
    }

    public void setGamesnum(String gamesnum) {
        this.gamesnum = gamesnum;
    }

    public String getGameswin() {
        return gameswin;
    }

    public void setGameswin(String gameswin) {
        this.gameswin = gameswin;
    }

    public String getGameslose() {
        return gameslose;
    }

    public void setGameslose(String gameslose) {
        this.gameslose = gameslose;
    }

    public String getGamestie() {
        return gamestie;
    }

    public void setGamestie(String gamestie) {
        this.gamestie = gamestie;
    }

    public GamesProfile(String gamesnum, String gameswin, String gameslose, String gamestie) {
        this.gamesnum = gamesnum;
        this.gameswin = gameswin;
        this.gameslose = gameslose;
        this.gamestie = gamestie;
    }
       
    
    
}
