# Análisis SOLID — Mato Seihei no Slave — Battle Arena

## S — Single Responsibility

- `Waifu`: comportamiento propio del personaje.
- `WaifuFactory`: creación de waifus.
- `SpecialAbilityFactory`: asociación de habilidades.
- `AnimeApiAdapter`: adaptación de una fuente externa.
- `WaifuDAO`: acceso a datos.
- `WaifuRepository`: abstracción de persistencia.
- `MediaLauncher`: reproducción automática de medios.

La extracción de `MediaLauncher`, `SpecialAbility` y `SpecialAbilityFactory` reduce responsabilidades que antes estaban concentradas en clases de aplicación.

## O — Open/Closed

El sistema permite agregar nuevas estrategias implementando `CombatStrategy`, nuevos estados implementando `WaifuState`, nuevos observers implementando `Observer` y nuevas habilidades implementando `SpecialAbility`.

## L — Liskov Substitution

Una instancia de `AggressiveStrategy`, `BalancedStrategy` o `DefensiveStrategy` puede utilizarse donde se espera `CombatStrategy`. Lo mismo sucede con los estados, observers y decoradores.

## I — Interface Segregation

Las interfaces son pequeñas y enfocadas: `Observer`, `Subject`, `CombatStrategy`, `WaifuDAO`, `WaifuRepository`, `SquadComponent` y `SpecialAbility`.

## D — Dependency Inversion

Las capas de negocio dependen de abstracciones (`WaifuRepository`, `CombatStrategy`, `Observer`) y no de implementaciones concretas. `AnimeGameFacade` recibe un `WaifuRepository` por constructor.
