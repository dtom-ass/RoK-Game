package model;

/*
 * Clase abstracta que define los atributos
 * y comportamientos básicos de un guerrero.
 */
public abstract class Warrior {

    // Atributos principales del guerrero
    private String name;
    private double lifePoints;
    private double attackPer;
    private double defencePer;
    private String specialArm;
    private String nativeFrom;
    private String warriorType;

    /*
     * Constructor base del guerrero.
     */
    public Warrior(
            String name,
            double lifePoints,
            double attackPer,
            double defencePer,
            String specialArm) {

        this.name = name;
        this.lifePoints = lifePoints;
        this.attackPer = attackPer;
        this.defencePer = defencePer;
        this.specialArm = specialArm;
        this.warriorType = getWarriorType();
    }

    protected void setLifePoints(double addLife) {
        this.lifePoints += addLife;
    }

    protected void setAttack(double addAttack) {
        this.attackPer += addAttack;
    }

    protected void setDefence(double addDefence) {
        this.defencePer += addDefence;
    }

    protected void setFrom(String editFrom) {
        this.nativeFrom = editFrom;
    }

    protected void setWarriorType(String type) {
        this.warriorType = type;
    }

    /*
     * Aplica una bonificación especial.
     */
    protected void setSpecial(int special){

        switch (special){
            case 1:
                lifePoints += 0.5;
                break;

            case 2:
                attackPer += 0.5;
                break;

            case 3:
                defencePer += 0.5;
                break;
        }
    }

    public double getLife(){
        return lifePoints;
    }

    public double getAttack(){
        return attackPer;
    }

    public double getDefence(){
        return defencePer;
    }

    public String getName(){
        return name;
    }

    public String getWarriorType(){
        return warriorType;
    }
    public abstract void setArmsList();
}