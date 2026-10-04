package com.waifu.ability;

import com.waifu.model.Waifu;

/** Habilidad especial única de cada waifu. Se puede utilizar una vez por combate. */
public interface SpecialAbility {
    String name();
    String description();
    String activate(Waifu user, Waifu target);
}
