
import javax.swing.*;

public class Loginservice {

    public static void Loginservice(String user, String pass) {
        if (checkUserandPasslegnth(user, pass)) {
            if (Loginservice.checkUserexists(user)) {
                if (Loginservice.checkPasscorrect(user, pass)) {
                    Loginservice.gotoLobby(user);
                    ProfileDB.getNickname(user);
                    Lobby.testfield.setText(user);
                    //Login.setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Password isn't valid plaese again");
                    Login.passwordfield.setText(null);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Username isn't valid plaese again");
                Login.usernamefield.setText(null);
                Login.passwordfield.setText(null);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Username or Password is short! pls try again");
            Login.usernamefield.setText(null);
            Login.passwordfield.setText(null);
        }
    }

    public static boolean checkUserandPasslegnth(String username, String password) {
        if (username.length() > 3 && password.length() > 3) {
            return true;
        }
        return false;
    }

    public static boolean checkUserexists(String username) {
        if (LoginDao.checkUserExisth(username)) {
            return true;
        }
        return false;
    }

    public static boolean checkPasscorrect(String username, String password) {
        if (LoginDao.checkPassCorrect(username, password)) {
            return true;
        }
        return false;
    }

    public static void gotoLobby(String username) {
        String nickname = LoginDao.getNickname(username);
        JOptionPane.showMessageDialog(null, "Welcome " + nickname);
        Lobby lobby = new Lobby();
        lobby.setVisible(true);

    }

}
