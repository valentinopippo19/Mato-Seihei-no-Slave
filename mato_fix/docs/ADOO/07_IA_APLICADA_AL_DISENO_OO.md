# IA aplicada al diseño orientado a objetos

## Objetivo

La IA se incorpora como herramienta de apoyo al análisis y diseño, no como sustituto de la decisión de diseño del desarrollador.

## Actividad 1 — Identificación de responsabilidades

**Consulta utilizada:**

> Analizar el diseño de Mato Seihei no Slave — Battle Arena y detectar responsabilidades mezcladas, code smells y posibles aplicaciones de GRASP/SOLID.

**Resultado utilizado:** se identificaron responsabilidades que podían extraerse, especialmente creación de habilidades y gestión de multimedia.

**Decisión humana:** se aceptó separar `SpecialAbility`/`SpecialAbilityFactory` y `MediaLauncher` porque disminuyen el acoplamiento de la interfaz.

## Actividad 2 — Selección de patrones

**Consulta utilizada:**

> Para un sistema de combate con personajes que tienen estrategias variables, estados, observadores y habilidades únicas, proponer patrones y justificar su aplicación.

**Resultado utilizado:**

- Strategy para algoritmos de combate.
- State para estados de una waifu.
- Observer para eventos del dominio.
- Factory para creación.
- Decorator para modificaciones de poder.
- Facade para simplificar la coordinación.

**Decisión humana:** los patrones se mantuvieron solamente cuando existía una variación real de comportamiento o una responsabilidad claramente separable.

## Actividad 3 — Revisión crítica

La propuesta generada por IA se revisó contra el código existente y contra el cronograma de la materia. No se incorporaron patrones únicamente por aumentar la cantidad de patrones.

## Evidencia técnica

El resultado de esta actividad se refleja en:

- `SpecialAbility` y sus implementaciones.
- `SpecialAbilityFactory`.
- `MediaLauncher`.
- `UiNotificationObserver`.
- documentación GRASP/SOLID y code smells.
- diagramas de secuencia.

## Criterio académico

La IA se utiliza como herramienta de exploración, crítica y generación de alternativas. La responsabilidad final sobre las decisiones arquitectónicas permanece en el desarrollador, que debe poder justificar cada patrón y cada refactorización frente al docente.
