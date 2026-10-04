package com.waifu.ability;
import com.waifu.model.Waifu;
public class AllEncompassingAbility implements SpecialAbility {
 public String name(){return "ALL-ENCOMPASSING LORD OF THE COSMOS";}
 public String description(){return "+30 ATK y +25 DEF.";}
 public String activate(Waifu user, Waifu target){user.increaseAttack(30); user.increaseDefense(25);return user.getName()+" activa ALL-ENCOMPASSING LORD OF THE COSMOS.";}
}
