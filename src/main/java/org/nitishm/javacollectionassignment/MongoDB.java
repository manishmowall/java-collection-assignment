package org.nitishm.javacollectionassignment;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MongoDB implements UserDB {
    private MongoClient mongoClient;
    private DBCollection dbCollection;
    private String url;
    private int port;
    private String database;
    private String collection;

    public MongoDB(String url, int port, String database, String collection) throws Exception {
        this.url = url;
        this.port = port;
        this.database = database;
        this.collection = collection;
        getConnection();
    }

    private void getConnection() throws Exception {
        mongoClient = new MongoClient(url, port);
        DB db = mongoClient.getDB(database);
        System.out.println("Connect to database successfully");
        dbCollection = db.getCollection(collection);
    }

    public List<User> getListOfUsers() throws Exception {
        DBCursor cursor = dbCollection.find();
        BasicDBObject obj;
        List<User> users = new ArrayList<User>();;
        User user;

        while (cursor.hasNext()) {
            obj = (BasicDBObject) cursor.next();
            String name = obj.getString("name");
            String DOB = obj.getString("DOB");
            String email = obj.getString("email");
            user = new User(name, DOB, email);
            users.add(user);
        }

        closeConnection();
        return users;
    }

    public Set<User> getSetOfUsers() throws Exception {
        DBCursor cursor = dbCollection.find();
        BasicDBObject obj;
        Set<User> users = new HashSet<User>();;
        User user;

        while (cursor.hasNext()) {
            obj = (BasicDBObject) cursor.next();
            String name = obj.getString("name");
            String DOB = obj.getString("DOB");
            String email = obj.getString("email");
            user = new User(name, DOB, email);
            users.add(user);
        }

        closeConnection();
        return users;
    }

    private void closeConnection() {
        mongoClient.close();
    }
}
