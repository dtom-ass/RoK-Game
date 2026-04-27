package controller;
import java.util.*;
import model.*;

public class CreateTeam {
    private String TeamName;
    private Culture culture;

    public CreateTeam(String TeamName, Culture culture){
        this.TeamName = TeamName;
        this.culture = culture;
    }

    public String testTeam(){
        return this.TeamName;
    }
    public List<Warrior> testTeamSt(){
        return this.culture.getWarriorList();
    }
    public Culture testCult(){
        return this.culture;
    }
    
}
