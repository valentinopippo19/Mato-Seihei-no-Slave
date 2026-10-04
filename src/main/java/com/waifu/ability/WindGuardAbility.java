package com.waifu.ability;

import com.waifu.model.Waifu;

public class WindGuardAbility implements SpecialAbility {
    public String name() { return "GUARDIA DEL VIENTO"; }
    public String description() { return "+20 DEF para el resto del combate."; }
    public String activate(Waifu user, Waifu target) {
        user.increaseDefense(20);
        return user.getName() + " activa GUARDIA DEL VIENTO: +20 DEF.";
    }
}
