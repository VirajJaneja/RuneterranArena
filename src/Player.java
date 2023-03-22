import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    ArrayList<String[]> charLevels = new ArrayList<>();




    public void setCharLevel(String charac, String lvl){
        String[] newSet = {charac, lvl};
        for(int i = 0; i<charLevels.size();i++){
            if(charLevels.get(i)[0].equals(charac))
                charLevels.set(i, newSet);
        }
    }
    
}
