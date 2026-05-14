# RoK Combat Game

Juego de combate por turnos desarrollado en Java y JavaFX.

## Descripción

Proyecto académico enfocado en:

- Programación Orientada a Objetos
- Arquitectura MVC
- Generación aleatoria de guerreros
- Combate por turnos
- Migración de interfaz de consola a JavaFX

Actualmente el proyecto mantiene:
- Sistema funcional por consola
- Pruebas y migración parcial hacia interfaz gráfica con JavaFX

---

## Tecnologías

- Java
- JavaFX

---

## Estado actual del proyecto

Actualmente la ejecución principal se realiza desde:

```text
view/GUI/guitest.java
```

Este archivo se utiliza para:
- pruebas de interfaz
- migración a JavaFX
- validación de escenas y componentes gráficos

El sistema original por consola continúa presente mientras avanza la migración hacia JavaFX.

---

## Estructura del proyecto

```text
ROK_COMBAT_GAME/
│
├── app/
│   └── Main.java
│
├── controller/
│   ├── BattleController.java
│   ├── EnemyBot.java
│   ├── PlayerController.java
│   ├── PlayerPanel.java
│   └── SelectionController.java
│
├── model/
│   ├── Culture.java
│   ├── Warrior.java
│   │
│   ├── Cultures/
│   └── Warriors/
│
├── view/
│   ├── console/
│   ├── GUI/
│   │   └── guitest.java
│   │
│   └── scenes/
│
├── lib/
│   └── JavaFX SDK y dependencias
│
└── .vscode/
    └── launch.json
```

---

## JavaFX

La carpeta:

```text
/lib
```

contiene las librerías y archivos necesarios para ejecutar JavaFX localmente en el proyecto.

El archivo:

```text
.vscode/launch.json
```

ya se encuentra configurado con:
- configuración mediante rutas relativas
- módulos JavaFX
- clase principal de pruebas (`guitest.java`)

Configuración utilizada:

```json
"vmArgs": "--module-path \"${workspaceFolder}/lib\" --add-modules javafx.controls,javafx.fxml -Djava.library.path=\"${workspaceFolder}/lib\""
```

---

## Ejecutar el proyecto

1. Clonar el repositorio

```bash
git clone https://github.com/dtom-ass/RoK_Combat_Game.git
```

2. Abrir el proyecto en VSCode

3. Ejecutar:

```text
view/GUI/guitest.java
```

---

## Objetivos del proyecto

- Consolidar arquitectura MVC
- Migrar completamente a JavaFX
- Mejorar interfaz gráfica
- Implementar escenas de juego dinámicas
- Separar lógica de combate de la vista

---
