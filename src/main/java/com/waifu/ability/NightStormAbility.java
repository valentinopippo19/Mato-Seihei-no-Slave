package com.waifu.ability;
import com.waifu.model.Waifu;
public class NightStormAbility implements SpecialAbility {
 public String name(){return "NIGHT STORM";}
 public String description(){return "+40 ATK.";}
 public String activate(Waifu user, Waifu target){user.increaseAttack(40);return user.getName()+" activa NIGHT STORM.";}
}
