import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Home {
    public int number; // 1-99
    public Room[] rooms = new Room[1];
}
