package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static praktikum.constants.Constants.*;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private static final float DELTA = 0.00F;
    public final IngredientType type;
    public final String name;
    public final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {SAUCE, SAUCE_NAME, SAUCE_PRICE},
                {SAUCE, "Соус Spicy-X", 0.2F},
                {SAUCE, null, 2.5f},
                {SAUCE, "Соус фирменный Space Sauce", 0},
                {null, "Соус традиционный галактический", 3.5F},
                {FILLING, FILLING_NAME, FILLING_PRICE},
                {FILLING, "Мясо бессмертных моллюсков Protostomia", 0.4F},
                {FILLING, null, 10.5F},
                {FILLING, "Говяжий метеорит (отбивная)", 0},
                {null, "Биокотлета из марсианской Магнолии", 5.5F}
        };
    }

    @Test
    public void ingredientNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Некорректное название ингредиента", name, ingredient.getName());
    }

    @Test
    public void ingredientPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Некорректная стоимость ингредиента", price, ingredient.getPrice(), DELTA);
    }
    @Test
    public void ingredientTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Некорректный тип ингредиента", type, ingredient.getType());
    }
}