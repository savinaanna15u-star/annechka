package org.example.lesson23;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializationDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path resourcesPath = Paths.get("src/main/resources", "student.out");
         writeObject(resourcesPath);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(resourcesPath.toFile()))){
            Object object = objectInputStream.readObject();
            System.out.println(object);
        }

    }


    private static void writeObject(Path resourcesPath) throws IOException { // сериализация
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(resourcesPath.toFile()))) {
            Person sergey = new Person(26, "Sergey");
            objectOutputStream.writeObject(sergey);
        }

    }
}
// сериализация - представление нашего объекта в виде массива байт (преобразование объекта в поток байт для хранения/передачи.)

// десериализация – восстановление объекта из потока байт (объект создаётся без вызова его конструктора)

// сериализация и десериализация нужны, чтобы сохранить состояние объекта в выходной поток
// и затем считать его из входного потока, восстановив объект в приложении

// чтобы объект можно было сериализовать стандартным механизмом, класс должен реализовывать
// интерфейс Serializable (проще) или Externalizable (полный ручной контроль)

// serialVersionUID – идентификатор версии класса; если его не объявить явно, он будет
// сгенерирован автоматически по структуре класса. При несовпадении значений при
// десериализации будет ошибка совместимости

// transient - поле не будет сериализовано (его значение не попадёт в поток)


