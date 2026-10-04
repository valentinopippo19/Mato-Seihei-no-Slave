package com.waifu.observer;

import java.util.function.Consumer;

/** Observer utilizado por la interfaz para demostrar notificaciones del dominio en tiempo real. */
public class UiNotificationObserver implements Observer {
    private final Consumer<String> notification;

    public UiNotificationObserver(Consumer<String> notification) {
        this.notification = notification;
    }

    @Override
    public void update(String event) {
        notification.accept("[OBSERVER] " + event);
    }
}
