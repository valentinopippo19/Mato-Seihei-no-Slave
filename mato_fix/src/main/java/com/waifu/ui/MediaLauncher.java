package com.waifu.ui;

import java.awt.Desktop;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Reproduce automáticamente los videos incluidos y permite detener el opening
 * cuando el usuario entra al combate.
 */
public final class MediaLauncher {
    private static Process mediaProcess;
    private static Path currentMedia;

    private MediaLauncher() {}

    public static boolean playOpening() { return open(find("Opening.mp4")); }
    public static boolean playEnding() { return open(find("Ending.mp4")); }

    /** Detiene el opening/medio actualmente reproducido antes de entrar al combate. */
    public static synchronized void stopOpening() {
        stopCurrent();
        closeWindowByTitle("Opening.mp4");
    }

    /** Detiene cualquier medio lanzado por esta clase. */
    public static synchronized void stop() {
        stopCurrent();
    }

    private static synchronized boolean open(Path file) {
        stopCurrent();
        if (file == null || !Files.isRegularFile(file)) return false;
        currentMedia = file.toAbsolutePath();

        // En Windows intentamos usar Windows Media Player para conservar un
        // proceso controlable. Si no está disponible, usamos la aplicación
        // predeterminada del sistema como fallback.
        if (isWindows()) {
            try {
                Process p = new ProcessBuilder("wmplayer.exe", currentMedia.toString()).start();
                mediaProcess = p;
                return true;
            } catch (IOException ignored) {
                // Fallback debajo.
            }
        }

        if (!Desktop.isDesktopSupported()) return false;
        try {
            Desktop.getDesktop().open(currentMedia.toFile());
            return true;
        } catch (IOException | UnsupportedOperationException ignored) {
            return false;
        }
    }

    private static synchronized void stopCurrent() {
        if (mediaProcess != null) {
            try {
                mediaProcess.destroy();
                if (mediaProcess.isAlive()) mediaProcess.destroyForcibly();
            } catch (Exception ignored) {}
            mediaProcess = null;
        }
        currentMedia = null;
    }

    private static void closeWindowByTitle(String titlePart) {
        if (!isWindows()) return;
        String script = "$p=Get-Process | Where-Object {$_.MainWindowTitle -like '*" + titlePart + "*'}; "
                + "$p | ForEach-Object {$_.CloseMainWindow() | Out-Null}";
        try {
            new ProcessBuilder("powershell.exe", "-NoProfile", "-ExecutionPolicy", "Bypass", "-Command", script)
                    .start()
                    .waitFor();
        } catch (Exception ignored) {}
    }

    private static boolean isWindows() {
        return System.getProperty("os.name", "").toLowerCase().contains("win");
    }

    private static Path find(String fileName) {
        Path[] candidates = {
                Path.of(fileName),
                Path.of("media", fileName),
                Path.of("..", fileName).normalize()
        };
        for (Path p : candidates) if (Files.isRegularFile(p)) return p.toAbsolutePath();
        return null;
    }
}
