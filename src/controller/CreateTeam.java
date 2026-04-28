package controller;
import java.util.*;
import model.*;
import model.Warriors.Archer;
import model.Warriors.Fighter;
import model.Warriors.Healer;
import model.Warriors.Lancer;
import model.Warriors.Tank;

public class CreateTeam {
    private String TeamName;
    private Culture culture;


    public CreateTeam(String TeamName, Culture culture){
        this.TeamName = TeamName;
        this.culture = culture;
    }

    public String getTeamName(){
        return this.TeamName;
    }
    public List<String> nameList(){
        return this.culture.getWarriorNameList();
    }
    public void setRandomWarriorType(){
        Random rand = new Random();
        
        for (int i = 0 ; i < 3 ; i++){
            int j = rand.nextInt(5);
            int k = rand.nextInt(10);

            // Los tipos de guerreros en  cada equipo creado con este metodo, sera de tipo, nombre y arma aleatoria.
            switch (j) {
                case 0:
                    // Archer
                    Warrior archer = new Archer(nameList().get(k), 0,0,0, "" );
                    archer.setArmor(archer.getArmsList().get(rand.nextInt(4)));
                    this.culture.addWarrior(archer);
                    break;
                case 1:
                    // Fighter
                    Warrior fighter = new Fighter(nameList().get(k), 0,0,0, "" );
                    fighter.setArmor(fighter.getArmsList().get(rand.nextInt(4)));
                    this.culture.addWarrior(fighter);
                    break;
                case 2:
                    // Healer
                    Warrior healer = new Healer(nameList().get(k), 0,0,0, "" );
                    healer.setArmor(healer.getArmsList().get(rand.nextInt(4)));
                    this.culture.addWarrior(healer);
                    break;
                case 3:
                    // Lancer
                    Warrior lancer = new Lancer(nameList().get(k), 0,0,0, "" );
                    lancer.setArmor(lancer.getArmsList().get(rand.nextInt(4)));
                    this.culture.addWarrior(lancer);
                    break;
                case 4:
                    // Tank
                    Warrior tank = new Tank(nameList().get(k), 0,0,0, "" );
                    tank.setArmor(tank.getArmsList().get(rand.nextInt(4)));
                    this.culture.addWarrior(tank);
                    break;
            }
        }
    }    
}

/** *Vamos a  crear una función random que defina:
 * Enemigo:
 *  - Cultura aleatoria:
 *  - 3 Tipos Guerreros aleatorios
//  - Nombre y Arma aleatoria para cada guerrero 


crear cultura
llamar lista de nombres de guerreros




*/

