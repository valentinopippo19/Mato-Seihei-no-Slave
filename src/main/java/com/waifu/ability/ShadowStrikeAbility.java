package com.waifu.ability;

import com.waifu.model.Waifu;

public class ShadowStrikeAbility implements SpecialAbility {
    public String name() { return "GOLPE DE SOMBRA"; }
    public String description() { return "+40 ATK para el resto del combate."; }
    public String activate(Waifu user, Waifu target) {
        user.increaseAttack(40);
        return user.getName() + " activa GOLPE DE SOMBRA: +40 ATK.";
    }
}
