package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static praktikum.IngredientType.*;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    protected Ingredient ingredient;

    private IngredientType type;
    private String expectedName;
    private float expectedPrice;

    public IngredientTypeTest (IngredientType type, String expectedName, float expectedPrice) {
        this.type = type;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[] getIngredient() {
        return new Object[][] {
                {SAUCE, "Соус Spicy-X", 10.12F},
                {FILLING, "Мясо бессмертных моллюсков Protostomia", 20.15F}
        };
    }

    @Test
    public void getTypeTest() {
        ingredient = new Ingredient(type, expectedName, expectedPrice);
        IngredientType actualType = ingredient.getType();

        assertEquals(type, actualType);
    }
}