package com.waifu.ability;
import com.waifu.model.Waifu;
public class AmeNoMitoriAbility implements SpecialAbility {
 public String name(){return "AME-NO-MITORI";}
 public String description(){return "+30 ATK y +15 DEF.";}
 public String activate(Waifu user, Waifu target){user.increaseAttack(30); user.increaseDefense(15);return user.getName()+" activa AME-NO-MITORI.";}
}
