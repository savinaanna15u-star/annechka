package org.example.lesson11;

public class oopLessonRunner3 {
    public static void main(String[] args) {
        double value = 2.5;
        int intValue = (int) value;

        Computer laptop = new Laptop(new Ssd(250), new Ram(1024), 2); // Laptop является Computer
        //Этот код допустим потому, что класс Laptop является подклассом (наследником) класса Computer. Это явление
        //называется upcasting (преобразование типа подкласса в суперкласс) и является одной из ключевых концепций полиморфизма
//        laptop.load();
//
//        System.out.println();

        Computer mobile = new Mobile(new Ssd(125), new Ram(512)); // Mobile является Computer

        Laptop laptop1 = new Laptop(new Ssd(5000), new Ram(10000), 5);
//        mobile.load();
        loadComputers(laptop, mobile);
        printInformation(new Computer[] {laptop, mobile, laptop1});
    }

    public static void printInformation(Computer[] computers){
        for (Computer computer : computers) {
            computer.print();
            if (computer instanceof Laptop) { // проверяем, ссылается ли computer на объект типа Laptop (или его подкласс)
                ((Laptop) computer).open(); // приводим ссылку типа Computer к типу Laptop и вызываем метод, доступный только в Laptop.
//                Laptop laptop = (Laptop) computer;
//                laptop.open();

            }
            System.out.println();
        }
    }

    public static void loadComputers (Computer ... computers){
        for (Computer computer : computers){
            computer.load();
            System.out.println();
        }
    }

}
// Mobile (тип ссылки) mobile = new Mobile (тип объекта)
// полиморфизм - один интерфейс и множество реализаций


// Порядок вызовов методов:
// Методы в Java выполняются последовательно, сверху вниз в том порядке, в котором они указаны в коде.
// каждая инструкция выполняется только после завершения предыдущей. Метод не может быть вызван до его объявления
// в исходном коде — компилятор должен знать о существовании метода, прежде чем его вызывать

//Когда вы вызываете метод с аргументами, которые сами являются вызовами других методов, действует правило
// left-to-right-innermost-to-outermost (слева направо, от внутренних к внешним)

//Перед тем как метод может быть выполнен, все его аргументы должны быть вычислены.
// ПРИМЕР foo(bar()) + baz(boo())
// 1. bar(),  2. foo() , 3. boo(), 4. baz()

// для улучшения читаемости и поддерживаемости кода существуют рекомендации:
//
//Конструкторы должны быть в начале класса
//
//Методы группируются по модификаторам доступа (public, default, protected, private)
//
//Внутри каждой группы доступа: статические методы перед нестатическими
//
//Методы группируются по функциональности
//
//Методы сортируются алфавитически по имени
//ПРИМЕР
//int x = 10;
//System.out.println(x);  //  работает
//
//System.out.println(y);  //  ошибка - y еще не создана
//int y = 20;

//ПРИМЕР
//max(5, 7);  //  ошибка если max объявлен ниже
//
//public void max(int a, int b) {
//    // тело метода
//}
//ПРИМЕР
//name = name.trim()
//    .replace("?", "")
//    .replace(" ", "-")
//    .toLowerCase(); методы в цепочку (method chaining), если каждый метод возвращает объект, с которым можно продолжить работу


// *********** Up-casting и Down-casting в контексте полиморфизма ************
//UP-casting: восходящее преобразование (расширение типа)
//UP-casting — это автоматическое преобразование ссылки на объект подкласса к типу его суперкласса
//  (родительского класса). Это движение вверх по цепочке наследования
// пример: Computer laptop = new Laptop(...)
// ↑ UP-casting: объект Laptop приводится к типу Computer

//Иерархия при UP-casting:
//
//Object (самый верхний уровень)
//  ↑
//  ↑ UP-casting (движение вверх)
//  ↑
//Computer (суперкласс)
//  ↑
//  ↑
//Laptop (подкласс)

// Что теряется при UP-casting:
//
//Когда вы кастируете Laptop к типу Computer, вы теряете доступ к методам, которые существуют только в Laptop, но не в Computer

//DOWN-casting: нисходящее преобразование (сужение типа)
//
//DOWN-casting — это явное преобразование ссылки на суперкласс обратно к типу подкласса. Это движение вниз по цепочке наследования.

//Computer computer = new Laptop(new Ssd(250), new Ram(1024), 2);  // UP-casting
//
//// Теперь нам нужно вернуться к Laptop, чтобы использовать его методы
//if (computer instanceof Laptop) {  // Проверка типа — обязательна!
//Laptop actualLaptop = (Laptop) computer;  // DOWN-casting с явным приведением
//    actualLaptop.laptopSpecificMethod();  // Теперь можно вызвать метод Laptop
//}
// DOWN-casting не гарантирует безопасность — компилятор не проверяет, является ли объект действительно экземпляром целевого подкласса.
// Если во время выполнения объект не будет тем типом, который вы ожидаете, произойдет ошибка времени выполнения  (требуется проверка instanceof)
// пример:
//Computer computer = new Laptop(...);  // UP-casting произошел
//Laptop laptop = (Laptop) computer;    // ✓ Безопасно, компилятор не будет жаловаться
//
//// Или с проверкой:
//if (computer instanceof Laptop) {
//Laptop laptop = (Laptop) computer;  // ✓ Гарантированно безопасно
//}