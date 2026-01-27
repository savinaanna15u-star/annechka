package org.example.patterns;

import java.util.Objects;

public class ComputerFluent {
    private String processor;
    private int ram;
    private int ssd = 0;
    private String graphicsCard = "нет";
    private String monitor = "нет";

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

    public ComputerFluent setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public ComputerFluent setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public ComputerFluent setSsd(int ssd) {
        this.ssd = ssd;
        return this;
    }

    public ComputerFluent setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    public ComputerFluent setMonitor(String monitor) {
        this.monitor = monitor;
        return this;
    }

    @Override
    public String toString() {
        return "ComputerFluent{" +
                "processor='" + processor + '\'' +
                ", ram=" + ram +
                ", ssd=" + ssd +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", monitor='" + monitor + '\'' +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerFluent computerFluent = (ComputerFluent) o;
        return ram == computerFluent.ram &&
                ssd == computerFluent.ssd &&
                Objects.equals(processor, computerFluent.processor) &&
                Objects.equals(graphicsCard, computerFluent.graphicsCard) &&
                Objects.equals(monitor, computerFluent.monitor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processor, ram, ssd, graphicsCard, monitor);
    }

    public static ComputerFluent create(String processor, int ram) {
        ComputerFluent computerFluentf = new ComputerFluent();
        computerFluentf.processor = processor;
        computerFluentf.ram = ram;
        return computerFluentf;
    }

    public static void main(String[] args) {
        ComputerFluent computerFluent = ComputerFluent.create("Intel i9", 1024)
                .setSsd(2048)
                .setGraphicsCard("RTX 4090")
                .setMonitor("32\" 8K");
        System.out.println(computerFluent);
    }
}
