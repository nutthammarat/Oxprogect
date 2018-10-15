import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.*;
import org.bson.types.ObjectId;
import java.util.*;

public class LobbyDB {
    MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds135866.mlab.com:35866/oxproject");
    MongoClient client = new MongoClient(uri);
    MongoDatabase db = client.getDatabase(uri.getDatabase());
    MongoCollection<Document> col = db.getCollection("rooms");

    public void createRoom(String name) {
        col.insertOne(new Document("name",name).append("units",(int)1));
    }

    public List<Document> showRoom(){
        List<Document> list = new ArrayList<>();
        MongoCursor<Document> cursor = col.find().iterator();
        while(cursor.hasNext()){
            Document rooms = cursor.next();
            list.add(rooms);
        }
        return list;
    }

    public boolean joinRoom(String name){
        Document findRoom = new Document("name",new String(name));
        MongoCursor<Document> cursor = col.find(findRoom).iterator();
        if(cursor.hasNext()) {
            Document room = cursor.next();
            if((int)room.get("units") == 2)
                return false;
            else {
                col.updateOne(findRoom,new Document("$set",new Document("units",2)));
                return true;
            }
        }
        return false;
    }
   
    
}