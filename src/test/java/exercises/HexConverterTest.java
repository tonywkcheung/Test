package exercises;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HexConverterTest {
    HexConverter hexConverter;

    @Before
    public void setUp() {
        hexConverter = new HexConverter();
    }

    @Test
    public void numberZero() {
        assertEquals("0", hexConverter.convert(0));
    }

    @Test
    public void numbersLessThan16() {
        assertEquals("1", hexConverter.convert(1));
        assertEquals("8", hexConverter.convert(8));
        assertEquals("f", hexConverter.convert(15));
    }

    @Test
    public void numbersMoreThan16() {
        assertEquals("10", hexConverter.convert(16));
        assertEquals(Integer.toHexString(32), hexConverter.convert(32));
        assertEquals(Integer.toHexString(1233), hexConverter.convert(1233));
        assertEquals(Integer.toHexString(64), hexConverter.convert(64));
        assertEquals(Integer.toHexString(214), hexConverter.convert(214));
    }
}