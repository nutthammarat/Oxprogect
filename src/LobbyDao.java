
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.*;
import java.util.*;

public class LobbyDao {

    static MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds135866.mlab.com:35866/oxproject");
    static MongoClient client = new MongoClient(uri);
    static MongoDatabase db = client.getDatabase(uri.getDatabase());
    static MongoCollection<Document> col = db.getCollection("rooms");

    

    public static List<Document> getRoom() {
        List<Document> list = new ArrayList<>();
        MongoCursor<Document> cursor = col.find().iterator();
        while (cursor.hasNext()) {
            Document rooms = cursor.next();
            list.add(rooms);
        }
        return list;
    }

    public static boolean joinRoom(String name) {
        Document findRoom = new Document("name", new String(name));
        MongoCursor<Document> cursor = col.find(findRoom).iterator();
        if (cursor.hasNext()) {
            Document room = cursor.next();
            if ((int) room.get("units") == 2) {
                return false;
            } else {
                col.updateOne(findRoom, new Document("$set", new Document("units", 2)));
                return true;
            }
        }
        return false;
    }

}
