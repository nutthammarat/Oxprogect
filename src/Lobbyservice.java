
import java.util.*;
import javax.swing.*;
import org.bson.*;


public class Lobbyservice {
    public static void showList(JList<String>listname,JList<String>listunit){
        DefaultListModel model1 = new DefaultListModel();
        DefaultListModel model2 = new DefaultListModel();
        List<Document> list = LobbyDao.getRoom();
        for(int i = 0 ; i<list.size() ; i++){
            model1.addElement(list.get(i).get("name"));
            model2.addElement("("+list.get(i).get("units")+"/2)");
        }
        listname.setModel(model1);
        listunit.setModel(model2);
    }
    public static String getuUser(){
        return Lobby.testfield.getText();
    }
    public static void Lobbyshow(){
        Lobby lobby = new Lobby();
        lobby.setVisible(true);
    }
    
}
