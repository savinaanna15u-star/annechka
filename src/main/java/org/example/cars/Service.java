package org.example.cars;

public class Service {

    private final String name;

    public Service(String name) {
        this.name = name;
    }

    public void apply(Car car){

        StringBuilder stringBuilder = new StringBuilder("Сервис ");
        stringBuilder.append(this.name);
        stringBuilder.append(" рассчитал стоимость ТО машины " + car.getClass().getSimpleName() + " модели: ");
        stringBuilder.append(car.getModel());
        stringBuilder.append(" версии: ");
        stringBuilder.append(car.getVersion());
        stringBuilder.append(" с двигателем: ");
        stringBuilder.append(car.getEngine().getName());
        stringBuilder.append(" ");
        stringBuilder.append(car.getEngine().getPower());
        stringBuilder.append(" лошадинных сил ");
        if(car.getEngine().getPower() == 1000){
            stringBuilder.append("стоимость 10.000 руб");
        } else if(car.getEngine().getPower() == 500){
            stringBuilder.append("стоимость 5.000 руб");
        }
        System.out.println(stringBuilder);
    }
}
