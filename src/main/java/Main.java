
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main<T> {
    public static void main(String[] args) throws IOException, ParseException {
        Thing thing = new Thing();
        House house = new House();
        House h1 = Read("example.json", House.class);
        System.out.println(h1);
        System.out.println(h1.nameHouse);
        System.out.println("Консоль? (y или n)");
        Scanner scanner = new Scanner(System.in);
        String flag = scanner.nextLine();
//        scanner.nextLine();
        if ((flag.equals("y")) || (flag.equals("Y")) || (flag.equals("н")) || (flag.equals("Н"))) {
            System.out.println("Введите класс: ");
            String clazz = scanner.nextLine();
            if (Objects.equals(clazz, "Thing")) {
//                Thing thing = CreateThing();
                Write("example.json", Thing.class, thing);
                Thing t = Read("example.json", Thing.class);
                System.out.println(t);
            } else if (Objects.equals(clazz, "Room")) {
//                System.out.println("Room");
                Room room = CreateRoom();
                Write("example.json", Room.class, room);
//                System.out.println("Э");
                Room r = Read("example.json", Room.class);
                System.out.println(r);
            } else if (Objects.equals(clazz, "Home")) {
                Home home = CreateHome();
                Write("example.json", Home.class, home);
                Home ho = Read("example.json", Home.class);
                System.out.println(ho);
            } else if (Objects.equals(clazz, "House")) {
//                House house = CreateHouse();
                Write("example.json", House.class, house);
                House h = Read("example.json", House.class);
                System.out.println(h);
            }
        } else {
            Random rnd = new Random();
            int number = rnd.nextInt(2) + 1;
            switch (number) {
                case 1:
//                    Thing thing = new Thing();
//        scanner.nextLine();
                    //scanner.nextLine();
//                    System.out.println(flag);
                    thing.type = "Холодильник";
                    Write("example.json", Thing.class, thing);
                    Read("example.json", Thing.class);
                    break;
                case 2:
                    Room room = new Room();
//        scanner.nextLine();
                    room.type = "Спальня";
                    Thing thingg = new Thing();
                    thingg.type = "Кровать";
                    room.things[0] = thingg;
                    Write("example.json", Room.class, room);
                    Read("example.json", Room.class);
            }
        }
    }

    public static <T> T Write(String filename, Class<T> tClass, Object obj) throws IOException {
        JSONObject sampleObject = new JSONObject();
        Thing thing = new Thing();
        thing.type = "Телевизор";
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(writer, (T) obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = writer.toString();
//        Files.write(Paths.get(filename), sampleObject.toJSONString().getBytes());
        Files.write(Paths.get(filename), Collections.singleton(result));
        return null;
    }

    public static <T> T Read(String filename, Class<T> tClass) throws IOException, ParseException {        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        JSONObject object = (JSONObject) jsonParser.parse(reader);
        StringReader reader1 = new StringReader(object.toJSONString());
//        System.out.println(reader1);
        ObjectMapper mapper = new ObjectMapper();
        T obj = null;
        try {
//            System.out.println(tClass);
            obj = (T) mapper.readValue(reader1, tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(object);
//        System.out.println(obj);
        return (T) obj;
//        return null;
    }

    public static Thing CreateThing() {
        System.out.println("Введите название вещи");
        Thing thing = new Thing();
        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine();
        String flag = scanner.nextLine();
        //scanner.nextLine();
        System.out.println(flag);
        thing.type = flag;
        return thing;
    }

    public static Room CreateRoom() {
        System.out.println("Введите название комнаты");
        Room room = new Room();
        Scanner scanner = new Scanner(System.in);
        String flag = scanner.nextLine();
//        scanner.nextLine();
        room.type = flag;
        Thing thing = CreateThing();
        room.things[0] = thing;
        return room;
    }

    public static Home CreateHome(){
        System.out.println("Введите номер квартиры");
        Home home = new Home();
        Scanner scanner = new Scanner(System.in);
        int flag = scanner.nextInt();
        home.number = flag;
        System.out.println("Введите какая комната есть в этой квартире");
        Room room = CreateRoom();
        home.rooms[0] = room;
        return home;
    }

    public static House CreateHouse(){
        System.out.println("Введите имя дома");
        House house = new House();
        Scanner scanner = new Scanner(System.in);
        String flag = scanner.nextLine();
        house.nameHouse = flag;
        house.homes[0] = CreateHome();
        return house;
    }
    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }
        else {
            return false;
        }
    }
}
