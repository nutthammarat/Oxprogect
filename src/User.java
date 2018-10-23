import java.util.*;
public class User {
    private String username;
    private String password;
    private String nickname;
    private int scorewin;
    private int scorelose;
    private int scoredraw;
    ArrayList<User> user;

    /**
     * @return the username
     */
    public ArrayList<User> getAll(String username ,String password,String nickname,int scorewin,int scorelose,int scoredraw){
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.scorewin = scorewin;
        this.scoredraw = scoredraw;
        this.scorelose = scorelose;
        return user;
    }
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public  void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the scorewin
     */
    public int getScorewin() {
        return scorewin;
    }

    /**
     * @param scorewin the scorewin to set
     */
    public void setScorewin(int scorewin) {
        this.scorewin = scorewin;
    }

    /**
     * @return the scorelose
     */
    public int getScorelose() {
        return scorelose;
    }

    /**
     * @param scorelose the scorelose to set
     */
    public void setScorelose(int scorelose) {
        this.scorelose = scorelose;
    }

    /**
     * @return the scoredraw
     */
    public int getScoredraw() {
        return scoredraw;
    }

    /**
     * @param scoredraw the scoredraw to set
     */
    public void setScoredraw(int scoredraw) {
        this.scoredraw = scoredraw;
    }
    
}
