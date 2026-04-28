package model.Cultures;
import java.util.*;

import model.Culture;
import model.Warrior;
import model.Warriors.Tank;

/*
 * Representa la cultura Maya
 * y sus guerreros iniciales.
 */
public class MayaCulture extends Culture {

    public MayaCulture(){

        super(
            "Maya",
            0,
            "Habilidad Maya"
        );

        /*
         * Registro inicial de guerreros.
         */
        //addWarrior(new Tank(
          //  "Balam",0,0,0,
            //"Escudo"
        //));
        
    } 

    @Override
        public List<String> getWarriorNameList(){
            List<String> nameList = new ArrayList<>();
            nameList.add("Itzamná");
            nameList.add("K’inich");
            nameList.add("Ixchel");
            nameList.add("Balam");
            nameList.add("Yaxun");
            nameList.add("Naabil");
            nameList.add("Zac-Nicté");
            nameList.add("Kaknab");
            nameList.add("Canek");
            nameList.add("Nicte-Ha");
            return nameList;
        }

}    