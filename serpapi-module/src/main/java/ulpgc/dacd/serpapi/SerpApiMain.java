package ulpgc.dacd.serpapi;

import ulpgc.dacd.serpapi.database.SerpApiDatabaseInitializer;

public class SerpApiMain {
    public static void main(String[] args) {
        try {
            SerpApiDatabaseInitializer db = new SerpApiDatabaseInitializer();
            db.initialize();

            System.out.println("Database initialized");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}