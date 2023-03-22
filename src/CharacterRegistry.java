import java.util.ArrayList;

public class CharacterRegistry {
    ArrayList<Character> CHARACTERS = new ArrayList<>();
    CharacterRegistry(){
        init();
    }

    public void init(){
        final Sylas SYLAS = new Sylas();
        CHARACTERS.add(SYLAS);
    }
}
