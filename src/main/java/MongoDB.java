import com.mongodb.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mowall on 14/9/16.
 */
public class MongoDB implements UserDB {
    private MongoClient mongoClient;
    private DBCollection dbCollection;
    private String url;
    private int port;
    private String database;
    private String collection;

    public MongoDB(String url, int port, String database, String collection) {
        this.url = url;
        this.port = port;
        this.database = database;
        this.collection = collection;
    }

    public void getConnection() {
        try{
            tryConnecting();

        }
        catch (Exception exception){
            System.out.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
    }
    private void tryConnecting() throws Exception {
        mongoClient = new MongoClient(url,port);
        DB db = mongoClient.getDB(database);
        System.out.println("Connect to database successfully");
       dbCollection = db.getCollection(collection);
    }

    public List<User> selectAll() {
        List<User> users = new ArrayList<User>();
        try {
            DBCursor cursor = dbCollection.find();
            BasicDBObject obj;
            User user;

            while (cursor.hasNext()) {
                obj = (BasicDBObject) cursor.next();
                String name = obj.getString("name");
                String DOB = obj.getString("DOB");
                String email = obj.getString("email");
                user = new User(name, DOB, email);
                users.add(user);

            }


        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally {
            closeConnection();
            return users;
        }

    }

    private void closeConnection() {
            mongoClient.close();
        }
}
