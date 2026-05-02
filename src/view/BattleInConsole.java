package view;

import model.Warrior;

public class BattleInConsole {

    /**
     * Muestra detalladamente el resultado de una acción de ataque.
     * 
     * @param attacker El guerrero que realiza la acción.
     * @param target   El guerrero que recibe el impacto.
     * @param damage   El daño final calculado tras aplicar defensas.
     */

    public static void showWarriorChange(Warrior activeWarrior) {
        System.out.printf(
                "# Guerrero seleccionado: %s | %s | vida:%.1f atk:%.2f def:%.2f%n | arma:%s ",
                activeWarrior.getWarriorType(),
                activeWarrior.getName(),
                activeWarrior.getLife(),
                activeWarrior.getAttack(),
                activeWarrior.getDefence(),
                activeWarrior.getWeapon());
    }

    public static void attackSelector() {
        System.out.println("- Lanzar ataque -");
        System.out.println("[1]: Basico \n[2]: Especial");
    }

    public static void showAttack(Warrior attacker, Warrior target, double damage) {
        System.out.println("\n------------------------------------------------");
        System.out.printf("¡%s (%s) lanza un ataque a %s.%n",
                attacker.getName(), attacker.getWarriorType(), target.getName());
        System.out.printf(">> Daño infligido: %.1f puntos.%n", damage);

        // Se asegura de no mostrar vida negativa en consola
        double remainingLife = Math.max(0, target.getLife());
        System.out.printf(">> Vida restante de %s: %.1f%n", target.getName(), remainingLife);

        if (remainingLife <= 0) {
            System.out.printf("¡%s ha caído en combate!%n", target.getName());
        }
        System.out.println("------------------------------------------------");

    }

}
