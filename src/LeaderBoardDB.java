
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import org.bson.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nutth
 */
public class LeaderBoardDB {
    static MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds135866.mlab.com:35866/oxproject");
    static MongoClient client = new MongoClient(uri);
    static MongoDatabase db = client.getDatabase(uri.getDatabase());
    static MongoCollection<Document> col = db.getCollection("users");

   public static List<Document> showLeaderBoard() {
        List<Document> list = new ArrayList<>();
        MongoCursor<Document> cursor = col.find().sort(new BasicDBObject("scoreWin", 1).
                append("scoreDraw", 1).append("scoreLose", -1)).iterator();
        while (cursor.hasNext()) {
            list.add(cursor.next());
        }
        return list;
    }
   public static void showLeader(JList<String>nickname,JList<String>scorewin,JList<String>scoredraw,JList<String>scorelose){
        DefaultListModel model1 = new DefaultListModel();
        DefaultListModel model2 = new DefaultListModel();
        DefaultListModel model3 = new DefaultListModel();
        DefaultListModel model4 = new DefaultListModel();
        DefaultListModel model5 = new DefaultListModel();
        List<Document> list = showLeaderBoard();
        for(int i = 0 ; i<list.size() ; i++){
            model5.addElement(i+1);
            model1.addElement(list.get(i).get("nickname"));
            model2.addElement(list.get(i).get("scoreWin"));
            model3.addElement(list.get(i).get("scoreDraw"));
            model4.addElement(list.get(i).get("scoreLose"));
            
        }
        nickname.setModel(model1);
        scorewin.setModel(model2);
        scoredraw.setModel(model3);
        scorelose.setModel(model4);
       // LeaderBoardGUI.indexs.setModel(model5);
        
   }
    
}
