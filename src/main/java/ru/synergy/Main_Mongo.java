package ru.synergy;

import com.mongodb.client.MongoClients;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.function.Consumer;

public class Main_Mongo {
    public static void main(String[] args) {
        try (var mongoClient = MongoClients.create()) {
//  1. Получение списка баз данных
//            mongoClient.listDatabases()
//                    .forEach((Consumer<Document>) System.out::println);
//            // show dbs
//           // Document{{name=test, sizeOnDisk=1.385336832E9, empty=false}}
//            mongoClient.listDatabaseNames()
//                    .forEach((Consumer<String>) System.out::println);

//  2. Создание и получение базы данных
            var database = mongoClient.getDatabase("syn");

//  3. Получение списка коллекций в текущей БД
//            database.listCollectionNames()
//                    .forEach((Consumer<String>) System.out::println);
//            // todo
//            database.listCollections()
//                    .forEach((Consumer<Document>) System.out::println);

//  4.  Создание и получение коллекции
            var todoCollection = database.getCollection("todo");

//  5.  Создание документа
            var todoDocument = new Document(Map.of(
                    "id", new ObjectId(),
                    "task", "Drink some coffee",
                    "dateCreated", LocalDateTime.now(),
                    "done", false));
            todoCollection.insertOne(todoDocument);


//  6.  Поиск по документам
            //Поиск всех документов
//            todoCollection.find()
//                    .forEach((Consumer<Document>) System.out::println);
            //Поиск документов, task которых содержит "coffee"
            todoCollection.find(new Document("task", new Document("$regex", "coffee")))
                    .forEach((Consumer<Document>) System.out::println);

//  7.  Изменение документов
//            todoCollection.updateOne(new Document("id", new ObjectId("65b54e03eda5af649460959f")),
//                    new Document(Map.of(
//                            "$set", new Document("done", true),
//                            "$currentDate", new Document("dateDone", true),
//                            "$unset", new Document("dateCreated", true))));
//
//            todoCollection.find()
//                    .forEach((Consumer<Document>) System.out::println);

//  8.  Удаление документов
//            todoCollection.deleteMany(new Document("done", true));
            todoCollection.deleteOne(new Document("id", new ObjectId("65b54e03eda5af649460959f")));
//            todoCollection.deleteOne(new Document("done", true));

//  9.  Функции агрегации данных (аналог JOIN в SQL)
//            todoCollection.aggregate();
//            todoCollection.mapReduce();

        }
    }
}