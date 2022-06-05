import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Room {
    private String type; // варианты: Спальня, Гостиная, Душевая, Кухня
    private Thing[] things;
}
