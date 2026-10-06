# Code smells y refactorizaciones

## 1. Responsabilidad excesiva en la interfaz

**Smell:** la interfaz de juego concentraba creación de pantallas, combate, persistencia, selección de medios y decisiones de flujo.

**Refactor aplicado:** extracción de `MediaLauncher`, que encapsula la reproducción automática de opening/ending.

**Beneficio:** la UI deja de conocer los detalles de localización y apertura de archivos multimedia.

## 2. Lógica de creación de habilidades dispersa

**Smell:** asociar manualmente habilidades a cada personaje desde diferentes puntos del programa produciría condicionales repetidos.

**Refactor aplicado:** `SpecialAbility`, implementaciones concretas y `SpecialAbilityFactory`.

**Beneficio:** se centraliza la variación y se habilita agregar nuevas habilidades mediante polimorfismo.

## 3. Condicionales de estrategia

**Smell:** seleccionar la estrategia mediante `switch` podría convertirse en una condición creciente.

**Refactor:** el cálculo de daño ya está encapsulado en `CombatStrategy` y sus tres implementaciones.

**Beneficio:** el algoritmo de combate queda desacoplado de la UI.

## 4. Selección de comportamiento del enemigo

**Smell:** la lógica de selección de atacante, objetivo y estrategia puede mezclarse con la interfaz.

**Refactor recomendado para futuras iteraciones:** extraer una `EnemyCombatPolicy` que encapsule la decisión de IA del oponente.

**Estado actual:** la selección ya está separada conceptualmente mediante métodos `chooseEnemyAttacker`, `chooseEnemyTarget` y `chooseEnemyStrategy`.

## 5. Primitive obsession en estrategias

**Smell:** los nombres de estrategia se representan como `String`.

**Refactor recomendado:** introducir un enum `StrategyType` o un selector que devuelva directamente `CombatStrategy`.

**Estado actual:** se mantiene `String` en la UI para facilitar la persistencia y presentación, mientras que el comportamiento real está polimorfizado.

## 6. Long Method

**Smell:** algunos métodos de construcción de Swing son largos porque generan varios componentes.

**Refactor aplicado parcialmente:** la UI ya está dividida en `homeScreen`, `selectionScreen`, `teamSelector`, `combatScreen`, `teamArea`, `actionBar`, `logPanel`, `refreshBattle` y `resultCard`.

**Beneficio:** cada método representa una sección concreta de la interfaz.
