package org.example.lesson18;

import org.example.lesson15.Archer;
import org.example.lesson15.Hero;
import org.example.lesson15.Mage;
import org.example.lesson15.Warrior;
import org.example.lesson18.weapon.Bow;
import org.example.lesson18.weapon.Sword;
import org.example.lesson18.weapon.Wand;
import org.example.lesson18.weapon.Weapon;

public class WeaponRunner {

    public static void main(String[] args) {
        Archer<Bow> archer = new Archer<>("Леголас ", 15);
        archer.setWeapon(new Bow());

        Warrior<Sword> warrior = new Warrior<> ("Боромир", 10);
        warrior.setWeapon(new Sword());

        Mage<Wand> mage = new Mage<> ("Гондальф", 20);
        mage.setWeapon(new Wand());

        printWeaponDamage(archer);
    }

    public static <T extends Weapon> void printWeaponDamage(Hero<T> hero) {
        // надо передать конкретный тип, которым параметризован Hero
        // public static <T extends Weapon> void printWeaponDamage - параметризация на уровне метода
        // public static void printWeaponDamage(Hero<? extends Weapon> hero) можно передавать любой тип, который наследуется от Weapon
        // public static void printWeaponDamage(Hero<? super Sword> hero)  Sword или все что было до Sword
// extends - используется для producers
// super -  используется для consumers
//      Sword weapon = hero.getWeapon(new Sword());
        System.out.println(hero.getWeapon().getDamage());
    }
}
