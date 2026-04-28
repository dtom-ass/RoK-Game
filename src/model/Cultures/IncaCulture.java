package model.Cultures;

import java.util.ArrayList;
import java.util.List;

import model.Culture;

public class IncaCulture extends Culture {
    public IncaCulture(){
        super("Inca", 0 , "Poder Inca");

    }
    @Override
         public List<String> getWarriorNameList(){
            List<String> nameList = new ArrayList<>();
            nameList.add("Pachacútec");
            nameList.add("Huayna Cápac");
            nameList.add("Atahualpa");
            nameList.add("Tupac Yupanqui");
            nameList.add("Manco Cápac");
            nameList.add("Quispe");
            nameList.add("Sayri");
            nameList.add("Amaru");
            nameList.add("Illapa");
            nameList.add("Chasca");
            return nameList;
        }
}
