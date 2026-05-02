package view;

import java.util.List;
import model.Culture;
import model.Warrior;
import controller.*;

public class MainMenuView {
    /**
     * Limpia la consola de forma efectiva usando códigos ANSI.
     * Funciona en terminales modernos (CMD de Win 10+, PowerShell, Linux, macOS).
     */
    public static void clear() {
        // \033[H mueve el cursor al inicio, \033[2J limpia la pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Muestra un mensaje simple en pantalla.
     */
    public static void showMessage(String message) {
        System.out.println(message);
    }

    // Título del juego
    public static void showTitle() {
        clear();
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║.       -------------        .║");
        System.out.println("║.    <| COMBATE - ROK |>     .║");
        System.out.println("║.       -------------        .║");
        System.out.println("╚══════════════════════════════╝");
    }

    // Opciones del menú principal
    public static void showMenu() {
        System.out.println("  [1] Iniciar Juego");
        System.out.println("  [0] Salir");
        System.out.print("\nElige una opción: ");
    }

    // Lista de culturas disponibles
    // El controlador le pasa la lista, la vista solo la imprime.
    /**
     * Muestra la lista de culturas disponibles para que el usuario elija.
     * 
     * @param cultures Lista de objetos de tipo Culture provenientes del
     *                 controlador.
     */
    public static void showAvailableCultures(List<Culture> cultures) {
        System.out.println("\n========================================");
        System.out.println("       RISE OF KINGDOMS: SELECCIÓN      ");
        System.out.println("========================================");
        System.out.println("Culturas disponibles:");

        for (int i = 0; i < cultures.size(); i++) {
            System.out.printf("[%d] %s - %s%n",
                    (i + 1),
                    cultures.get(i).getName(),
                    cultures.get(i).getSkill()); // Muestra la habilidad especial de la cultura [3]
        }
        System.out.println("----------------------------------------");
        System.out.print("Escriba el número de su elección: ");
    }

    // Equipo enemigo generado por EnemyBot
    // El controlador le pasa la Culture del bot, la vista solo la imprime.
    public static void showEnemyTeam(Culture enemyCulture) {
        clear();
        System.out.printf("%n=== Equipo enemigo: %s ===%n", enemyCulture.getName());
        for (Warrior w : enemyCulture.getWarriorList()) {
            System.out.printf("  · %-12s | tipo: %-10s | arma: %s%n",
                    w.getName(), w.getWarriorType(), w.getWeapon());
        }
        System.out.println();
    }

    // Mensajes de estado
    public static void showInvalidOption() {
        System.out.println("  Opción no válida, intenta de nuevo.");
    }

    public static void showExit() {
        System.out.println("+==========================+");
        System.out.println("¡Hasta la próxima, guerrero!");
        System.out.println("+==========================+");
    }

    public static void showPlayerWarriors(PlayerController player) {

        System.err.println("\n-+== Guerreros del Jugador ==+-\n");
        for (int i = 0; i < player.getWarriorTeam().size(); i++) {
            System.out.printf(
                    "[%d] -> " + player.getWarriorTeam().get(i).getWarriorType()
                            + " | "
                            + player.getWarriorTeam().get(i).getName() + "\n",
                    i + 1);
        }
    }

    public static void showEnemyIniStat(EnemyBot enemy) {
        System.err.println("\n-+== Guerreros del Enemigo ==+-\n");
        for (Warrior warrior : enemy.getEnemyCulture().getWarriorList()) {
            System.out.printf("[+] %s | %s \n", warrior.getWarriorType(), warrior.getName());
        }
    }

    public static void showNewBattle(PlayerController player, EnemyBot enemy) {
        System.out.println("|==============================|");
        System.out.println("| NUEVA PARTIDA INICIADA |");
        System.out.printf("| Jugador %s -< VS >- Enemigo %s |", player.getPlayerCulture().getName(),
                enemy.getEnemyCulture().getName());
        System.out.println("\n|==============================|");
        showEnemyIniStat(enemy);
        showPlayerWarriors(player);
        System.out.println("\n|==============================|");
        System.out.println(
                "\n|Instrucciones: \n+ Cada ronda el jugador puede cambiar de guerrero. \n+ Despues de elegir tu guerrero, puedes atacar. \n+ El equipo enemigo decide si cambia de guerrero y realiza el ataque. \n+ El ataque enemigo afecta al ultimo guerrero seleccionado por el jugador.");
    }

}