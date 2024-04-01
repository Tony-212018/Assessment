package org.example;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String inputFile = "C:\\folder\\input.json";
        String outputFile = "C:\\folder\\output.json";

        JSONObject jsonObject = readJSONFromFile(inputFile);
        if (jsonObject != null) {
            modifyJSON(jsonObject);
            writeJSONToFile(jsonObject, outputFile);
            System.out.println("JSON file has been modified and saved as " + outputFile);
        }
    }

    public static JSONObject readJSONFromFile(String filePath) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            Object obj = parser.parse(reader);
            return (JSONObject) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void modifyJSON(JSONObject jsonObject) {

        jsonObject.put("key1", "value2");
        jsonObject.put("key2", "value3");

        // Add two additional keys and their values
        jsonObject.put("new_key1", "value4");
        jsonObject.put("new_key2", "value5");
    }

    public static void writeJSONToFile(JSONObject jsonObject, String filePath) {
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonObject.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
