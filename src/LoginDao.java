


import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author GGG
 */
public class LoginDao {
   static MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds135866.mlab.com:35866/oxproject");
   static MongoClient client = new MongoClient(uri);
   static MongoDatabase db = client.getDatabase(uri.getDatabase());
   static BasicDBObject query = new BasicDBObject();
   static MongoCollection<Document> col = db.getCollection("users");

    public static boolean checkUserExisth(String username) {
        Document findQuery = new Document("user",username);
        MongoCursor<Document> cursor = col.find(findQuery).iterator();
        if(cursor.hasNext())
            return true;
        else
            return false;
    }

    public static boolean checkPassCorrect(String username, String password) {
         Document findUserPass = new Document("user",username).append("pass",password);
        MongoCursor<Document> cursor = col.find(findUserPass).iterator();
        if(cursor.hasNext())
            return true;
        else
            return false;
    }
    public static String getNickname(String username){
        Document findNickname = new Document("user",username);
        MongoCursor<Document> cursor = col.find(findNickname).iterator();
        if(cursor.hasNext()) {
            Document nickname = cursor.next();
            return (String)nickname.get("nickname");
        }
        return "?????";
    }

   
    
    
}
