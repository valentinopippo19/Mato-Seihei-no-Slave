package com.waifu.ability;
import com.waifu.model.Waifu;
public class BeastPowerAbility implements SpecialAbility {
 public String name(){return "BEAST POWER";}
 public String description(){return "+35 ATK para el resto del combate.";}
 public String activate(Waifu user, Waifu target){user.increaseAttack(35);return user.getName()+" activa BEAST POWER: +35 ATK.";}
}
