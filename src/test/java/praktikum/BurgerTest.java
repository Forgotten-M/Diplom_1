package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private static final float DELTA = 0.00F;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;

    private Burger burger;

    @Before
    public void before() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(50F);
        burger.addIngredient(ingredient1);
        when(ingredient1.getPrice()).thenReturn(100F);
        burger.addIngredient(ingredient2);
        when(ingredient2.getPrice()).thenReturn(150F);
        assertEquals(350, burger.getPrice(), DELTA);
    }

    @Test
    public void getReceiptTest() {

        burger.setBuns(bun);
        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(50F);

        burger.addIngredient(ingredient1);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("chili sauce");

        burger.addIngredient(ingredient2);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("dinosaur");

        String expectedReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}