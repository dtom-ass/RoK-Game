package view;

import java.util.List;
import model.Culture;
import model.Warrior;

public class MainMenuView {

    // ─── Título del juego ────────────────────────────────────────────────
    public static void showTitle() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║                              ║");
        System.out.println("║         ROK  GAME            ║");
        System.out.println("║                              ║");
        System.out.println("╚══════════════════════════════╝");
    }

    // ─── Opciones del menú principal ─────────────────────────────────────
    public static void showMenu() {
        System.out.println("  [1] Nueva partida");
        System.out.println("  [2] Selección de jugador");
        System.out.println("  [3] Mostrar enemigo");
        System.out.println("  [0] Salir");
        System.out.print("\nElige una opción: ");
    }

    // ─── Lista de culturas disponibles ───────────────────────────────────
    // El controlador le pasa la lista, la vista solo la imprime.
    public static void showAvailableCultures(List<Culture> cultures) {
        System.out.println("\n=== Culturas disponibles ===");
        for (int i = 0; i < cultures.size(); i++) {
            Culture c = cultures.get(i);
            System.out.printf("  [%d] %-12s — habilidad: %s%n",
                i + 1, c.getName(), c.getSkill());
        }
        System.out.print("\nElige tu cultura: ");
    }

    // ─── Equipo enemigo generado por EnemyBot ────────────────────────────
    // El controlador le pasa la Culture del bot, la vista solo la imprime.
    public static void showEnemyTeam(Culture enemyCulture) {
        System.out.printf("%n=== Equipo enemigo: %s ===%n", enemyCulture.getName());
        for (Warrior w : enemyCulture.getWarriorList()) {
            System.out.printf("  · %-12s | tipo: %-10s | arma: %s%n",
                w.getName(), w.getWarriorType(), w.getArmor());
        }
        System.out.println();
    }

    // ─── Mensajes de estado ───────────────────────────────────────────────
    public static void showInvalidOption() {
        System.out.println("  Opción no válida, intenta de nuevo.");
    }

    public static void showExit() {
        System.out.println("\n  ¡Hasta la próxima, guerrero!\n");
    }
}