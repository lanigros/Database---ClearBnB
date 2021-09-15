package database;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class Mongo {

  MongoClient mongoClient = MongoClients.create();
  CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
      fromProviders(PojoCodecProvider.builder().automatic(true).build()));
  MongoDatabase database = mongoClient.getDatabase("java_db").withCodecRegistry(pojoCodecRegistry);


  Mongo() {
    MongoCollection<Document> collection = database.getCollection("test");
    ;
  }
}


