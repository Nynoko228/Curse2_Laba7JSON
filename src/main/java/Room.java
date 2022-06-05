import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Room {
    public String type; // варианты: Спальня, Гостиная, Душевая, Кухня
    public Thing[] things;
}
