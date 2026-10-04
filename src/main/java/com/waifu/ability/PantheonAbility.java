package com.waifu.ability;
import com.waifu.model.Waifu;
public class PantheonAbility implements SpecialAbility {
 public String name(){return "PANTHEON";}
 public String description(){return "+40 DEF para el resto del combate.";}
 public String activate(Waifu user, Waifu target){user.increaseDefense(40);return user.getName()+" activa PANTHEON: +40 DEF.";}
}
