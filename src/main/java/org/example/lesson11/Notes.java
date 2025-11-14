package org.example.lesson11;

public class Notes {
}
//   Порядок выполнения блоков инициализации и конструкторов в Java
//Блоки инициализации экземпляра (IIB):
//Инициализируют переменные экземпляра, выполняются перед конструктором при каждом создании объекта,
// используются для общей части всех конструкторов класса.
//
//Блоки статической инициализации:
//Запускаются один раз при первой загрузке класса JVM (Java Virtual Machine), порядок — как указано в исходном коде.
//
//Конструкторы:
//Выполняются после всех блоков инициализации экземпляра, содержат основную логику создания объекта.
//
//Порядок выполнения:
//— Сначала статические блоки и поля (Блоки статической инициализации)
//— Затем нестатические блоки и поля (Блоки инициализации)
//— После них — конструктор
//— В наследовании: сначала родитель, потом дочерний класс.

//Блоки статической инициализации и блоки инициализации экземпляра выполняются в том порядке, в котором объявлены в коде.

// Java program to demonstrate the order of
// execution of constructors, static blocks,
// and instance initialization blocks
// пример 1
class Geeks {
    // Конструкторы - Выполняются после всех блоков инициализации экземпляра, запускается только выбранный конструктор
    Geeks(int x) {
        System.out.println("ONE argument constructor");
    }

    Geeks() {
        System.out.println("No argument constructor");
    }

    // Блок статической инициализации - выполняются один раз при первой загрузке класса. строго в порядке объявления
    static {
        System.out.println("1st static init");
    }

    // Блок инициализации экземпляра - запускается при каждом создании объекта, перед вызовом любого конструктора. в порядке появления в коде.
    {
        System.out.println("1st instance init");
    }
    // Блок инициализации экземпляра
    {
        System.out.println("2nd instance init");
    }

    // Блок статической инициализации
    static {
        System.out.println("2nd static init");
    }

    public static void main(String[] args) {
        new Geeks();
        new Geeks(8);
    }
}

// ПРИМЕР 2

//class MyTest {
//    static {  Статический блок инициализации
//        initialize();
//    }
//
//    private static int sum; Статическое поле
//
//    public static int getSum() { Статический метод
//        initialize();
//        return sum;
//    }
//
//    private static boolean initialized = false; Статическое поле
//
//    private static void initialize() { Статический метод
//        if (!initialized) {
//            for (int i = 0; i < 100; i++) {
//                sum += i;
//            }
//            initialized = true;
//        }
//    }
//}
//
//public class Geeks {
//    public static void main(String[] args) {
//        System.out.println(MyTest.getSum());
//    }
//}