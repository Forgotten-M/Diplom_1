package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.constants.Constants.*;

public class BunTest {
    private static final float DELTA = 0.00F;
    Bun bun = new Bun(BUN_NAME, BUN_PRICE);

    @Test
    public void getNameTest() {
        assertEquals(BUN_NAME, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(BUN_PRICE, bun.getPrice(), DELTA);
    }
}
