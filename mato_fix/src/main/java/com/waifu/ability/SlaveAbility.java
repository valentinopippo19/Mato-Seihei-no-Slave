package com.waifu.ability;
import com.waifu.model.Waifu;
public class SlaveAbility implements SpecialAbility {
 public String name(){return "SLAVE";}
 public String description(){return "+45 ATK.";}
 public String activate(Waifu user, Waifu target){user.increaseAttack(45);return user.getName()+" activa SLAVE.";}
}
