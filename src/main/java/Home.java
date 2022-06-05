import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Home {
    private int number; // 1-99
    private Room[] rooms;
}
