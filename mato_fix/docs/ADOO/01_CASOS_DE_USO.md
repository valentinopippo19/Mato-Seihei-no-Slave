# Casos de uso formalizados — Mato Seihei no Slave — Battle Arena

## Actores

- **Jugador:** selecciona equipos, ejecuta acciones y decide atacante/objetivo en su turno.
- **Sistema de combate:** administra turnos, estados, daño, habilidades y condición de finalización.
- **Persistencia:** guarda y recupera el estado de un combate.
- **Reproductor multimedia del entorno:** reproduce automáticamente opening y ending.

## CU-01 — Iniciar combate

**Actor:** Jugador  
**Precondiciones:** existen al menos dos waifus disponibles.  
**Postcondición:** queda creado un combate con 1 a 3 aliadas y 1 a 3 enemigas.

**Flujo principal**
1. El jugador selecciona entre 1 y 3 waifus propias.
2. El jugador selecciona entre 1 y 3 waifus enemigas.
3. El sistema valida que ninguna waifu pertenezca a ambos equipos.
4. El sistema reinicia HP, estadísticas modificadas y habilidades utilizadas.
5. El sistema reproduce automáticamente el opening.
6. Finalizado el opening, comienza el turno 1.
7. El sistema guarda el combate.

**Alternativas:** si un equipo está vacío o supera tres integrantes, el sistema rechaza el inicio.

## CU-02 — Atacar con una waifu

**Actor:** Jugador  
**Precondiciones:** existe un combate activo y la waifu atacante no está KO.  
**Postcondición:** el objetivo recibe daño y el turno pasa al oponente.

1. El jugador selecciona la waifu atacante.
2. Selecciona la waifu enemiga objetivo.
3. Selecciona una estrategia de combate.
4. `AnimeGameFacade` delega el cálculo a `CombatStrategy`.
5. El objetivo recibe el daño mediante `Waifu.receiveDamage()`.
6. El cambio de HP/estado notifica a los observers.
7. El sistema verifica si terminó el combate.
8. Si continúa, el oponente ejecuta su turno.

## CU-03 — Utilizar habilidad especial

**Actor:** Jugador  
**Precondiciones:** la waifu está viva y no utilizó su habilidad en el combate.  
**Postcondición:** se aplica el efecto único de la habilidad y se consume su uso.

Cada personaje posee una habilidad diferente:

| Waifu | Habilidad | Efecto |
|---|---|---|
| Konomi Tatara | Explosión Ígnea | +30 ATK |
| Bell Tsukiyono | Golpe de Sombra | +40 ATK |
| Tenka Izumo | Foco Tenka Izumor | +20 ATK y +10 DEF |
| Yakumo Ezo | Guardia del Viento | +20 DEF |
| Kyouka Uzen | Sanación Radiante | +45 HP |

## CU-04 — Turno del oponente

**Actor:** Sistema de combate  
**Precondiciones:** el combate continúa después del turno del jugador.  
**Postcondición:** una waifu enemiga ataca a una waifu aliada.

1. El sistema selecciona como atacante a la enemiga viva con mayor ATK.
2. Selecciona como objetivo a la aliada viva con menor HP.
3. Si corresponde, utiliza la habilidad especial de la atacante una vez por combate.
4. Selecciona una estrategia según ATK/DEF.
5. Ejecuta el ataque.
6. Notifica el evento mediante Observer.
7. Verifica condición de victoria/derrota.

## CU-05 — Curar personaje

**Actor:** Jugador  
**Precondiciones:** la waifu seleccionada está viva.  
**Postcondición:** recupera hasta 35 HP sin superar su máximo.

## CU-06 — Guardar / continuar combate

**Actor:** Jugador  
**Precondiciones:** existe un combate activo.  
**Postcondición:** el estado puede recuperarse posteriormente.

Se persisten equipos, turno, selección, estrategia, HP, habilidades utilizadas, registro y daño acumulado.

## CU-07 — Finalizar combate

**Actor:** Sistema de combate  
**Postcondición:** se muestra el resultado y se reproduce automáticamente el ending.

El caso termina cuando todas las waifus de un equipo quedan KO. Después se muestra el resultado y el score final.
