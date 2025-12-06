package org.example.lesson28.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({
        ElementType.TYPE,
        ElementType.FIELD,
})
@Retention(RetentionPolicy.RUNTIME)
public @interface MinAge {

    int age(); //default 18;

}
// аннотации - это метаданные, которые можно читать и использовать во время выполнения
// программы через механизмы рефлексии.

//аннотации — это подсказки для программы, которые можно прочитать во время выполнения через рефлексию
// они позволяют, глядя на класс или поле, понять, как с ними работать: проверять данные (например, @MinAge),
//  связывать поля с бд (@Entity, @Column), автоматически находить нужные методы

//чтобы аннотация была доступна через рефлексию, у неё должен быть @Retention(RetentionPolicy.RUNTIME);
// в противном случае код на Reflection просто её не увидит.