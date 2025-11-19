package org.example.lesson15;

import org.example.lesson18.weapon.MeleeWeapon;

public class Warrior <T extends MeleeWeapon> extends Hero <T> {

    public Warrior(String name, int damage) {
        super(name, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(getName() + " взмахнул мечом над " + enemy.getName());
        enemy.takeDamage(getDamage());
    }
}
