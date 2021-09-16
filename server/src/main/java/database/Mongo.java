package database;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class Mongo {

  private static final MongoClient mongoClient = MongoClients.create();
  private static final CodecRegistry pojoCodecRegistry = fromRegistries(
      MongoClientSettings.getDefaultCodecRegistry(),
      fromProviders(PojoCodecProvider.builder().automatic(true).build()));
  private static MongoDatabase database = null;

  static {
    String dbName = "java_db";

    try {
      database = mongoClient.getDatabase(dbName).withCodecRegistry(pojoCodecRegistry);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static MongoDatabase getDB(){
    return database;
  }





}


