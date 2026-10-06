package com.waifu;

import com.waifu.facade.AnimeGameFacade;
import com.waifu.model.Waifu;
import com.waifu.persistence.*;
import com.waifu.ui.MediaLauncher;
import com.waifu.ui.WaifuGameFrame;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MediaLauncher.playOpening();
        SwingUtilities.invokeLater(() -> {
            WaifuTableDataGateway gateway = new WaifuTableDataGateway();
            WaifuDAO dao = new InMemoryWaifuDAO(gateway);
            WaifuRepository repository = new WaifuRepositoryImpl(dao);
            AnimeGameFacade facade = new AnimeGameFacade(repository);

            facade.createAndSave("konomi");
            facade.createAndSave("bell");
            facade.createAndSave("yakumo");
            facade.createAndSave("tenka");
            facade.createAndSave("kyouka");
            facade.createAndSave("varvara");
            facade.createAndSave("fubuki");
            facade.createAndSave("ren");

            List<Waifu> waifus = facade.list();
            new WaifuGameFrame(facade, waifus).setVisible(true);
        });
    }
}
