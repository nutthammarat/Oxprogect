
import javax.swing.*;

public class Registerservice {

    static Object[] options = {"Login"};

    public static void Registerservice(String user, String pass, String confirmpass, String nickname) {
        if (!Registerservice.checkFieldnotnull(user, pass.toString(), nickname, confirmpass)) {
            if (Registerservice.checkUserExist(user)) {
                JOptionPane.showMessageDialog(null, "Username is exists or to short please fill again", "Register Error", JOptionPane.ERROR_MESSAGE);
                Register.usernamefield.setText("");
            }
            if (Registerservice.checkNickname(nickname) || Registerservice.checkPass(pass, confirmpass)) {
                JOptionPane.showMessageDialog(null, "Please set Nickname more than 3 charactor "
                        + "and check Password and comfirm Password to more than 6 number!", "Register Error", JOptionPane.ERROR_MESSAGE);
                Register.nicknamefield.setText("");
                Register.confirmpassfield.setText("");
            } else if (!Registerservice.checkUserExist(user)) {

                Registerservice.addUsers(user, pass, nickname);
                int input = JOptionPane.showOptionDialog(null, "Welcome, " + Registerservice.getnickname(nickname), "Register Success",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (input == 0) {
                    Login log = new Login();

                    log.setVisible(true);
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Please fill all of information");
        }
    }

    public static boolean checkFieldnotnull(String username, String password, String nickname, String confirmpassword) {
        boolean flag = false;
        if (username.equals("") || password.equals("") || nickname.equals("") || confirmpassword.equals("")) {
            flag = true;
            return flag;//true
        }
        return flag;//false
    }

    public static boolean checkUserExist(String username) {
        return RegisterDao.checkUserExists(username);
    }

    public static void addUsers(String username, String password, String nickname) {
        RegisterDao.addUser(username, password, nickname);
    }

    public static boolean checkNickname(String nickname) {
        if (nickname.length() < 3) {
            return true;
        }
        return false;
    }

    public static boolean checkPass(String password, String confirmpassword) {
        if (!password.equals(confirmpassword) || password.length() < 6) {
            return true;
        }
        return false;
    }

    public static String getnickname(String nickname) {
        String a = nickname;
        return a;
    }
}
