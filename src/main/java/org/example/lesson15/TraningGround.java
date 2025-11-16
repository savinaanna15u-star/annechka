package org.example.lesson15;

public class TraningGround {

    public static void main(String[] args) {
        Hero warrior = new Warrior("Боромир", 15);
        Hero mage = new Mage("Гендольф", 20);
        Hero archer = new Archer("Леголас", 10);

        Enemy enemy = new Enemy("Зомби", 100);
        attackEnemy(enemy, warrior, mage, archer);
    }

    public static void attackEnemy(Enemy enemy, Hero ...  heroes){
        while (enemy.isAlive()){
            for (Hero hero : heroes){
                if (enemy.isAlive()) {
                    hero.attackEnemy(enemy);
                }
            }
        }
    }
}
