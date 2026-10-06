package com.waifu.model;

import com.waifu.ability.SpecialAbility;
import com.waifu.observer.Observer;
import com.waifu.observer.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Waifu implements Subject {
    private final int id;
    private final String name;
    private final String anime;
    private final Element element;
    private int attack;
    private int defense;
    private final int baseAttack;
    private final int baseDefense;
    private int hp;
    private final int maxHp;
    private WaifuState state;
    private final List<Observer> observers = new ArrayList<>();
    private final SpecialAbility specialAbility;
    private boolean abilityUsed;

    public Waifu(int id, String name, String anime, Element element,
                 int attack, int defense, int maxHp) {
        this(id, name, anime, element, attack, defense, maxHp, com.waifu.ability.SpecialAbilityFactory.forWaifu(name));
    }

    public Waifu(int id, String name, String anime, Element element,
                 int attack, int defense, int maxHp, SpecialAbility specialAbility) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.anime = Objects.requireNonNull(anime);
        this.element = Objects.requireNonNull(element);
        this.attack = attack;
        this.defense = defense;
        this.baseAttack = attack;
        this.baseDefense = defense;
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.state = new HealthyState();
        this.specialAbility = Objects.requireNonNull(specialAbility);
    }

    public int calculateBaseDamage() { return Math.max(1, attack); }

    public void receiveDamage(int damage) {
        if (isKnockedOut()) return;
        int adjusted = state.modifyIncomingDamage(Math.max(0, damage));
        hp = Math.max(0, hp - adjusted);
        updateStateFromHp();
        notifyObservers(name + " recibió " + adjusted + " de daño. HP=" + hp);
    }

    public void heal(int amount) {
        if (isKnockedOut()) return;
        hp = Math.min(maxHp, hp + Math.max(0, amount));
        updateStateFromHp();
        notifyObservers(name + " recuperó vida. HP=" + hp);
    }

    /** Restaura una batalla guardada sin emitir eventos visuales de combate. */
    public void restoreBattleState(int savedHp) {
        hp = Math.max(0, Math.min(maxHp, savedHp));
        updateStateFromHp();
    }

    private void updateStateFromHp() {
        if (hp == 0) state = new KnockedOutState();
        else if (hp <= maxHp / 2) state = new InjuredState();
        else state = new HealthyState();
    }

    public void changeState(WaifuState newState) {
        this.state = Objects.requireNonNull(newState);
        notifyObservers(name + " cambió a estado " + state.name());
    }

    public boolean isKnockedOut() { return state instanceof KnockedOutState; }
    public boolean canAttack() { return state.canAttack(); }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getAnime() { return anime; }
    public Element getElement() { return element; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public SpecialAbility getSpecialAbility() { return specialAbility; }
    public boolean isAbilityUsed() { return abilityUsed; }
    public void restoreAbilityUsed(boolean used) { this.abilityUsed = used; }

    public String useAbility(Waifu target) {
        if (abilityUsed) return getName() + " ya utilizó " + specialAbility.name() + " en este combate.";
        if (isKnockedOut()) return getName() + " no puede utilizar su habilidad estando KO.";
        String result = specialAbility.activate(this, target);
        abilityUsed = true;
        notifyObservers(getName() + " utilizó " + specialAbility.name());
        return result;
    }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public String getStateName() { return state.name(); }
    public void increaseAttack(int amount) { attack += Math.max(0, amount); }
    public void increaseDefense(int amount) { defense += Math.max(0, amount); }

    public void resetBattleState() {
        hp = maxHp;
        attack = baseAttack;
        defense = baseDefense;
        abilityUsed = false;
        state = new HealthyState();
        notifyObservers(name + " está lista para una nueva batalla.");
    }

    @Override public void addObserver(Observer observer) { observers.add(observer); }
    @Override public void removeObserver(Observer observer) { observers.remove(observer); }
    @Override public void notifyObservers(String event) {
        for (Observer observer : List.copyOf(observers)) observer.update(event);
    }

    @Override
    public String toString() {
        return "%s [%s] - %s | ATK %d DEF %d HP %d/%d | %s"
                .formatted(name, anime, element, attack, defense, hp, maxHp, state.name());
    }
}
