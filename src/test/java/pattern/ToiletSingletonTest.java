package pattern;

import org.example.patterns.Toilet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ToiletSingletonTest {
    @Test
    public void testSingleton(){
        Toilet toilet1 = Toilet.getInstance(); //getInstance() всегда возвращает один и тот же объект
        Toilet toilet2 = Toilet.getInstance();
        Toilet toilet3 = Toilet.getInstance();
        assertSame(toilet1, toilet2);
        assertSame(toilet2, toilet3);
        assertSame(toilet1, toilet3);
    }
    @Test
    public void testSingleton2(){
        Toilet toilet = Toilet.getInstance();
        toilet.use("папаня");
        assertTrue(toilet.isOccupied(), "должен быть занят");
        assertEquals("папаня", toilet.getLastUser(), "последний чел");

        toilet.flush();
        assertFalse(toilet.isOccupied(),"должен быть свободен");

        toilet.use("мама");
        assertTrue(toilet.isOccupied(), "снова занято");
        assertEquals("мама", toilet.getLastUser());
    }
}
