
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Thing thing = new Thing();

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(writer, thing);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = writer.toString();
        System.out.println(result);
        JSONObject sampleObject = new JSONObject();
        Write("example.json");
        Read("example.json");
    }
    public static void Write(String filename) throws IOException {
        JSONObject sampleObject = new JSONObject();
        sampleObject.put("name", "Stackaffffffffffffbuser");
        sampleObject.put("age", 35);

        JSONArray messages = new JSONArray();
        messages.add("Hey!");
        messages.add("What's up?!");

        sampleObject.put("messages", messages);
        Files.write(Paths.get(filename), sampleObject.toJSONString().getBytes());
    }

    public static void Read(String filename) throws IOException, ParseException {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        System.out.println((JSONObject) jsonParser.parse(reader));
    }
}
