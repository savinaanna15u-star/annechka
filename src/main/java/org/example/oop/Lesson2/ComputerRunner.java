package org.example.oop.Lesson2;

public class ComputerRunner {
    public static void main(String[] args) {
        int x = 5;
        // конструктор без параметров / дефолтный конструктор
        Computer computer = new Computer(); // new создание нового объекта/ экземляр класса комп
        // comp comp = это присваивание

        computer.load();
        computer.printState();

      //  Computer computer3 = new Computer(12, 7);
        Computer computer2 = new Computer(1050);
        computer2.printState();
        Computer computer3 = new Computer(1050, 700);
        computer3.printState();
    }
}
/* Правило перегрузки метода - изменение сигнатуры метода.
Сигнатура метода: количесвто аргументов метода, тип аргументов и порядок аргументов.

Тип возвращаемого значения метода не является частью сигнатуры метода, следовательно изменение только типа возвращаемого значения метода не является перегрузкой метода.
 */
