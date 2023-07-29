import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Location loc = new Location(49.45, 123.75);
        PetRock rck = new PetRock("Stoney", 25.5, loc);

        // GSON Library work
        Gson gson = new Gson();

        // Convert to JSON
        // String myJson = gson.toJson(rck);
        // System.out.println(myJson);

        // Write to the file
        try (FileWriter writer = new FileWriter("rock.json")){
            gson.toJson(rck, writer);
            // writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Read from the File
        try {
            FileReader reader = new FileReader("rock.json");
            PetRock rocky = gson.fromJson(reader, PetRock.class);
            System.out.println(rocky);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}