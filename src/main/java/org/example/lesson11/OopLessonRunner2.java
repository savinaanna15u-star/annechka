package org.example.lesson11;


public class OopLessonRunner2 {

    public static void main(String[] args) {
        //Laptop -> Computer -> Object
        //Laptop <- Computer <- Object
        new Laptop();
    }
}



// при создании класса, вызывается в первую очередь конструктор базового класса
// сначала инициализируются поля базового класса
// static загружается в первую очередь, тк статич. блок иниц. - блок иниц., который относится к нашему объекту класса класс, он вызывается только 1 раз во время инициализации