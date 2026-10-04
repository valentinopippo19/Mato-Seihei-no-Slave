package com.waifu.ability;

import com.waifu.model.Waifu;

public class FlameBurstAbility implements SpecialAbility {
    public String name() { return "EXPLOSIÓN ÍGNEA"; }
    public String description() { return "+30 ATK para el resto del combate."; }
    public String activate(Waifu user, Waifu target) {
        user.increaseAttack(30);
        return user.getName() + " activa EXPLOSIÓN ÍGNEA: +30 ATK.";
    }
}
