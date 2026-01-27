package org.example.patterns;

import java.util.Objects;// BUILDER паттерн

// Паттерн для пошагового создания сложных объектов.
// Особенно полезен, когда объект имеет много полей, часть из которых необязательны. Builder — это "черновик", Computer — "чистовик"
public class Computer {
    private final String processor;
    private final int ram;
    private final int ssd;
    private final String graphicsCard;
    private final String monitor;

    public String getProcessor() {
        return processor;
    }

    public int getRam() {
        return ram;
    }

    public int getSsd() {
        return ssd;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public String getMonitor() {
        return monitor;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", ram=" + ram +
                ", ssd=" + ssd +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", monitor='" + monitor + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return ram == computer.ram &&
                ssd == computer.ssd &&
                Objects.equals(processor, computer.processor) &&
                Objects.equals(graphicsCard, computer.graphicsCard) &&
                Objects.equals(monitor, computer.monitor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processor, ram, ssd, graphicsCard, monitor);
    }
    public Computer(Builder builder) {
        this.processor = builder.processor;
        this.ram = builder.ram;
        this.ssd = builder.ssd;
        this.graphicsCard = builder.graphicsCard;
        this.monitor = builder.monitor;
    }

    public static class Builder { // Внутренний класс для пошагового создания Computer
        private final String processor;
        private final int ram;
        private int ssd = 0;
        private String graphicsCard = "нет";
        private String monitor = "нет";

        public Builder(String processor, int ram) {
            this.processor = processor;
            this.ram = ram;
        }

        public Builder withSSD(int ssd) {
            this.ssd = ssd;
            return this;
        }

        public Builder withGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder withMonitor(String monitor) {
            this.monitor = monitor;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }


    }

    public static void main(String[] args) {
        Computer PlayingComp = new Computer.Builder("AMD Ryzen 7", 32)
                .withSSD(1000)
                .withGraphicsCard("NVIDIA RTX 4070")
                .withMonitor("27\" 4K 144Hz")
                .build();
        System.out.println(PlayingComp);
        Computer OfficeComp = new Computer.Builder("Intel i5", 16)
                .withSSD(256)
                .withMonitor("22\" HD")
                .build();
        System.out.println(OfficeComp);
        Computer BudgetComp = new Computer.Builder("Intel core", 8)
                .build();
        System.out.println(BudgetComp);
    }
}

