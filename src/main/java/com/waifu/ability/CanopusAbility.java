package com.waifu.ability;
import com.waifu.model.Waifu;
public class CanopusAbility implements SpecialAbility {
 public String name(){return "CANOPUS";}
 public String description(){return "+25 ATK y +20 DEF.";}
 public String activate(Waifu user, Waifu target){user.increaseAttack(25); user.increaseDefense(20);return user.getName()+" activa CANOPUS.";}
}
