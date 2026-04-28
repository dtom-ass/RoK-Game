package model.Cultures;

import java.util.ArrayList;
import java.util.List;

import model.Culture;
import model.Warrior;

public class MuiscaCulture extends Culture{
    public MuiscaCulture(){
        super("Muisca", 0 ,"Poder Muisca");
    }
    @Override
         public List<String> getWarriorNameList(){
            List<String> nameList = new ArrayList<>();
            nameList.add("Nemequene");
            nameList.add("Saguanmachica");
            nameList.add("Meicuchuca");
            nameList.add("Aquiminzaque");
            nameList.add("Michuá");
            nameList.add("Saguamanchica");
            nameList.add("Hunzahúa");
            nameList.add("Tundama");
            nameList.add("Idacansá");
            nameList.add("Sugamuxi");
            return nameList;

        }
}
