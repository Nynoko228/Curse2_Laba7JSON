
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main<T> {
    public static void main(String[] args) throws IOException, ParseException {
        Thing thing = new Thing();
//
//        StringWriter writer = new StringWriter();
//        ObjectMapper mapper = new ObjectMapper();
//
//        try {
//            mapper.writeValue(writer, thing);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String result = writer.toString();
//        System.out.println(result);
//        JSONObject sampleObject = new JSONObject();
        Write("example.json");
        Read("example.json", thing, Thing.class);
        
    }
    public static void Write(String filename) throws IOException {
        JSONObject sampleObject = new JSONObject();
        Thing thing = new Thing();
        thing.type = "Телевизор";
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(writer, thing);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = writer.toString();
        sampleObject.put("name", "Stackaffffffffffffbuser");
        sampleObject.put("age", 35);

        JSONArray messages = new JSONArray();
        messages.add("Hey!");
        messages.add("What's up?!");

        sampleObject.put("messages", messages);
//        Files.write(Paths.get(filename), sampleObject.toJSONString().getBytes());
        Files.write(Paths.get(filename), Collections.singleton(result));
    }

    public static <T> T Read(String filename, Object obj, Class<T> tClass) throws IOException, ParseException {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        JSONObject object = (JSONObject) jsonParser.parse(reader);
        StringReader reader1 = new StringReader(object.toJSONString());
//        System.out.println(reader1);
        ObjectMapper mapper = new ObjectMapper();
        try {
//            System.out.println(tClass);
            obj = (T) mapper.readValue(reader1, Thing.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(object);
        System.out.println(obj);
        return (T) obj;
//        return null;
    }
}
