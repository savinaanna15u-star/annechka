package pattern;

import org.example.patterns.Computer;
import org.example.patterns.ComputerFluent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerBuilderTest {
    @Test
    public void testComputerBuilder() {
        Computer expected = new Computer.Builder("AMD Ryzen 7", 32)
                .withSSD(512)
                .withGraphicsCard("NVIDIA RTX 4070")
                .withMonitor("27\" 4K 144Hz")
                .build();

        Computer actual = new Computer.Builder("AMD Ryzen 7", 32)
                .withSSD(512)
                .withGraphicsCard("NVIDIA RTX 4070")
                .withMonitor("27\" 4K 144Hz")
                .build();
        assertEquals(expected, actual);
        Computer expectedDefault = new Computer.Builder("Intel i7", 16).build();
        Computer actualDefault = new Computer.Builder("Intel i7", 16).build();
        assertEquals(expectedDefault, actualDefault);
    }

    @Test
    public void testComputerFluentBuilder() {
        ComputerFluent expected = ComputerFluent.create("Intel i5", 8)
                .setSsd(12)
                .setGraphicsCard("NVIDIA RTX 4070")
                .setMonitor("27\" HD");

        ComputerFluent actual = ComputerFluent.create("Intel i5", 8)
                .setSsd(12)
                .setGraphicsCard("NVIDIA RTX 4070")
                .setMonitor("27\" HD");
        assertEquals(expected, actual);

        ComputerFluent expectedDefault = ComputerFluent.create("Intel core", 4);
        ComputerFluent actualDefault = ComputerFluent.create("Intel core", 4);
        assertEquals(expectedDefault, actualDefault);
    }
}