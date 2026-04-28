package model.Cultures;
import java.util.*;

import model.Culture;
import model.Warriors.Lancer;

public class AztecaCulture extends Culture {
    public AztecaCulture(){
        super("Azteca", 0, "Habilidad Azteca");

        addWarrior(new Lancer("K'awii",0,0,0,"Lanza"));
    };
    @Override
        public List<String> getWarriorNameList(){
            List<String> nameList = new ArrayList<>();
            nameList.add("Cuauhtémoc");
            nameList.add("Moctezuma");
            nameList.add("Cuitláhuac");
            nameList.add("Itzcóatl");
            nameList.add("Axayácatl");
            nameList.add("Xipil");
            nameList.add("Ilhuicamina");
            nameList.add("Tenoch");
            nameList.add("Citlalli");
            nameList.add("Tizoc");
            return nameList;
        }
    
}
