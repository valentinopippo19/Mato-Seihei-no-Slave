# Justificación formal de MVC y demostración de Observer

## MVC

### Model

El modelo está formado por las entidades y reglas del dominio:

- `Waifu`
- `Squad`
- `WaifuState`
- `SpecialAbility`
- `CombatStrategy`
- decoradores de poder
- repositorios y abstracciones de persistencia

### View

`ConsoleView` representa la vista de consola. En la aplicación Swing, `WaifuGameFrame` construye y actualiza la interfaz gráfica. En la versión web, `index.html` y `styles.css` representan la presentación.

### Controller

`WaifuController` coordina los casos de uso de la aplicación de consola. En la interfaz gráfica/web, los eventos de botones y controles funcionan como entrada del usuario y delegan las operaciones en el dominio/facade.

### Facade como límite de aplicación

`AnimeGameFacade` actúa como punto de entrada simplificado para crear, importar, listar y combatir, evitando que el controlador deba conocer Factory, Adapter, Repository y las estrategias simultáneamente.

## Observer: demostración efectiva

`Waifu` implementa `Subject`. Los observers se registran al iniciar la interfaz:

- `ConsoleNotificationObserver`: muestra eventos en consola.
- `UiNotificationObserver`: agrega eventos al registro visual del combate.
- `AchievementObserver`: cuenta eventos y desbloquea un logro después del tercer evento.

Eventos observables:

1. recepción de daño;
2. recuperación de HP;
3. cambio de estado;
4. uso de habilidad;
5. preparación para una nueva batalla.

Ejemplo del flujo:

```text
Waifu.receiveDamage()
        |
        v
Waifu.notifyObservers(evento)
        |
   +----+----------------+
   |                     |
   v                     v
UiNotification       Achievement
Observer             Observer
   |                     |
   v                     v
Log visual          Logro / mensaje
```

Esto demuestra que el objeto `Waifu` no necesita conocer la interfaz ni el sistema de logros: solamente publica eventos mediante `Subject`.
