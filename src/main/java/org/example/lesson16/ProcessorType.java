package org.example.lesson16;

public enum ProcessorType implements Describable { // enum похож на особый абстрактный класс, что может содержать поля, методы и даже абстрактные методы
    BIT_32("bit-32"),
//            {
//        @Override // переопределили метод getDescription
//        public String getDescription() {
//            return "bit 32 description";
//        }

    BIT_64("bit-64");
//    {
//        @Override
//        public String getDescription() {
//            return "bit 64 description";
//        }
    private String name;

    ProcessorType(String name) {
        this.name = name;
    }
    @Override
    public String getDescription() {
        return name + " description";
    }
//    public abstract String getDescription(); // надо переопределить

    public String getName() {
        return name;
    }
}
// ограничение это нельзя наследоваться от ProcessorType и  он не может наследовать какой то другой класс
// может реализовывать интерфейсы => в нем могут быть абстрактные методы

//Константы enum — это полноценные объекты с собственными полями, конструкторами и методами.
//
//У каждого enum есть стандартные методы: .name(), .ordinal(), .values(), .valueOf() и переопределяемый toString().
//
//Enum нельзя создать с помощью new — экземпляры создаются только через объявление внутри самого перечисления.
//Можно определить поля и методы как у обычного класса (в том числе конструкторы — они всегда private).
//В каждом элементе enum можно переопределять методы интерфейсов (через override).
//Каждый элемент создается единожды и может храниться в коллекциях как объект.