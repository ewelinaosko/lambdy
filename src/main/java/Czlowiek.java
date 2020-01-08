import java.util.regex.Pattern;

public class Czlowiek {

    private String imie;
    private String wiek;

    public String getImie() {
        return imie;
    }

    public String getWiek() {
        return wiek;
    }

    public Czlowiek(String input){
        Pattern separator = Pattern.compile(";");
        imie = separator.split(input)[0];
        wiek = separator.split(input)[1];
    }

}
