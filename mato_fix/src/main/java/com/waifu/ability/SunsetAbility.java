package com.waifu.ability;
import com.waifu.model.Waifu;
public class SunsetAbility implements SpecialAbility {
 public String name(){return "SUNSET";}
 public String description(){return "Recupera 55 HP.";}
 public String activate(Waifu user, Waifu target){int before=user.getHp(); user.heal(55);return user.getName()+" activa SUNSET.";}
}
