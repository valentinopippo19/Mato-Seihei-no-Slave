package com.waifu.controller;

import com.waifu.facade.AnimeGameFacade;
import com.waifu.model.*;
import com.waifu.strategy.*;
import com.waifu.view.ConsoleView;

public class WaifuController {
    private final AnimeGameFacade facade;
    private final ConsoleView view;

    public WaifuController(AnimeGameFacade facade, ConsoleView view) {
        this.facade = facade;
        this.view = view;
    }

    public void runDemo() {
        view.title();

        Waifu konomi = facade.createAndSave("konomi");
        Waifu kyouka = facade.createAndSave("kyouka");
        Waifu tenka = facade.createAndSave("tenka");

        view.section("MVC + FACTORY + ADAPTER + REPOSITORY");
        facade.list().forEach(view::showWaifu);

        view.section("COMPOSITE");
        Squad squad = facade.buildSquad("Escuadron 7", konomi, kyouka, tenka);
        squad.print("");

        view.section("DECORATOR");
        WaifuPower build = facade.createBuild(tenka);
        view.showBuild(build);

        view.section("STRATEGY + STATE + OBSERVER");
        facade.fight(kyouka, tenka, new BalancedStrategy());
        facade.fight(konomi, tenka, new DefensiveStrategy());
        tenka.receiveDamage(200);
        facade.fight(tenka, konomi, new AggressiveStrategy());

        view.section("PERSISTENCIA");
        view.showCount(facade.list().size());
    }
}
