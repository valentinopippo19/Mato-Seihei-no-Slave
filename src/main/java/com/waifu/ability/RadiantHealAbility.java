package com.waifu.ability;

import com.waifu.model.Waifu;

public class RadiantHealAbility implements SpecialAbility {
    public String name() { return "SANACIÓN RADIANTE"; }
    public String description() { return "Recupera 45 HP."; }
    public String activate(Waifu user, Waifu target) {
        int before = user.getHp();
        user.heal(45);
        return user.getName() + " activa SANACIÓN RADIANTE: recupera " + (user.getHp() - before) + " HP.";
    }
}
