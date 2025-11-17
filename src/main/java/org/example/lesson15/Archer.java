package org.example.lesson15;

public class Archer extends Hero {

    private Wolf wolf;

    public Archer(String name, int damage){
        super(name, damage);
        this.wolf = new Wolf( "Wolf", 7);
    }

    @Override
    public void attackEnemy(Enemy enemy) {

        System.out.println(getName() + " стрельнул из лука в " + enemy.getName());
        wolf.attaсkEnemy(enemy);
    }

    public class Wolf { // private class только если внутренний класс (если static то вложенный)
        private String name;
        private int damage;

        public Wolf(String name, int damage) {
            this.name = name;
            this.damage = damage;
        }

        public void attaсkEnemy(Enemy enemy){
            System.out.println(name + " и " + Archer.this.getName() + " наносят совместный урон");
            enemy.takeDamage(damage + Archer.this.getDamage());

        }
    }

}
// во внутреннем классе можно обращаться к объекту класса Archer
