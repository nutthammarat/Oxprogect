
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class RegisterDB {
    MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds135866.mlab.com:35866/oxproject");
    MongoClient client = new MongoClient(uri);
    MongoDatabase db = client.getDatabase(uri.getDatabase());
    BasicDBObject query = new BasicDBObject();
    MongoCollection<Document> col = db.getCollection("users");

    public boolean checkUserExists(String username){
        Document findQuery = new Document("user",username);
        MongoCursor<Document> cursor = col.find(findQuery).iterator();
            if(cursor.hasNext())
                return true;
            else
                return false;
    }

    public void addUser(String username,String password,String nickname){
        col.insertOne(new Document("user",username).append("pass",password).append("nickname",nickname)
                .append("scoreWin",0).append("scoreLose",0).append("scoreDraw",0));
    }

    
}
