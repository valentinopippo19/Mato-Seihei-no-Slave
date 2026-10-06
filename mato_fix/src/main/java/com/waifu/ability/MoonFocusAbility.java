package com.waifu.ability;

import com.waifu.model.Waifu;

public class MoonFocusAbility implements SpecialAbility {
    public String name() { return "FOCO LUNAR"; }
    public String description() { return "+20 ATK y +10 DEF para el resto del combate."; }
    public String activate(Waifu user, Waifu target) {
        user.increaseAttack(20);
        user.increaseDefense(10);
        return user.getName() + " activa FOCO LUNAR: +20 ATK y +10 DEF.";
    }
}
