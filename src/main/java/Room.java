import org.codehaus.jackson.annotate.JsonAutoDetect;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
public class Room {
    public String type; // варианты: Спальня, Гостиная, Душевая, Кухня
    public Thing[] things = new Thing[1];
}

