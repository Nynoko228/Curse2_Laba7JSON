import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class House {
    public String nameHouse;
    public Home[] homes = new Home[1];
}
