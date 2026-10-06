# Análisis GRASP — Mato Seihei no Slave — Battle Arena

## Controller

`WaifuController` concentra la coordinación de casos de uso de la versión de consola. En la aplicación gráfica, `WaifuGameFrame` recibe eventos de la interfaz y delega las operaciones de dominio en `AnimeGameFacade`.

**Justificación:** el Controller recibe eventos del sistema y evita que la vista tenga que conocer todos los objetos internos del dominio.

## Creator

`WaifuFactory` crea instancias de `Waifu`. `SpecialAbilityFactory` crea la habilidad asociada a cada personaje.

**Justificación:** la responsabilidad de creación se asigna a una clase que conoce los tipos concretos y centraliza las decisiones de instanciación.

## Information Expert

`Waifu` conoce HP, ATK, DEF y estado, por lo que administra `receiveDamage()`, `heal()`, `canAttack()` y el uso de su habilidad.

**Justificación:** el comportamiento que depende directamente de los datos de la entidad se mantiene próximo a esos datos.

## Low Coupling

`AnimeGameFacade` utiliza `WaifuRepository`, `CombatStrategy` y `Observer` mediante abstracciones.

**Resultado:** las implementaciones pueden cambiar sin modificar las clases que dependen de ellas.

## High Cohesion

Las responsabilidades están separadas en paquetes: `model`, `strategy`, `observer`, `persistence`, `adapter`, `factory`, `facade`, `ui`.

## Polymorphism

Se aplica en `CombatStrategy`, `WaifuState`, `Observer`, `WaifuPower`, `SquadComponent` y `SpecialAbility`.

## Pure Fabrication

`WaifuRepository`, DAO, Table Data Gateway, `MediaLauncher` y las factories son responsabilidades técnicas creadas para evitar cargar esas funciones sobre las entidades del dominio.

## Indirection

`Facade`, `Adapter`, `Repository` y `DAO` introducen intermediarios que reducen el acoplamiento entre capas.

## Protected Variations

Las variaciones de estrategia, estados, habilidades y fuentes externas están protegidas mediante interfaces y clases concretas. Por ejemplo, agregar una nueva `CombatStrategy` no obliga a modificar la interfaz de `Waifu`.
