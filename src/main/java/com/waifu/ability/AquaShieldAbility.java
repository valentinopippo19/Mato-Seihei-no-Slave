package com.waifu.ability;

import com.waifu.model.Waifu;

public class AquaShieldAbility implements SpecialAbility {
    public String name() { return "ESCUDO ACUÁTICO"; }
    public String description() { return "+30 DEF para el resto del combate."; }
    public String activate(Waifu user, Waifu target) {
        user.increaseDefense(30);
        return user.getName() + " activa ESCUDO ACUÁTICO: +30 DEF.";
    }
}
