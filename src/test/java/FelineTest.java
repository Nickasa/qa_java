import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

//В тесте исопльзуется параметризация для проверки метода getKittens c перегрузкой
@RunWith(Parameterized.class)
public class FelineTest {
    private final int kittensAmount;
    private final int expected;

    public FelineTest(int kittensAmount, int expected){
        this.kittensAmount = kittensAmount;
        this.expected = expected;
    }

    //Параметры теста для getKittens(int kittensCount)
    @Parameterized.Parameters
    public static Object[][] getKittensAmount() {
        return new Object[][]{
                {0, 0},
                {7, 7},
                {100, 100},
        };
    }

    //Тест на соответствие рациона семейству кошачьих
    @Test
    public void eatMeatReturnsCorrectRation() throws Exception {
        Feline feline = new Feline();

        List<String> expectedResult = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualResult = feline.eatMeat();

        assertEquals("Рацион семейства кошачьих не соответствует результату", expectedResult, actualResult);

    }

    //Тест на проверку возвращаемого значения метода getFamily()
    @Test
    public void getFamilyReturnsCorrectValue() {
        Feline feline = new Feline();

        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();

        assertEquals("Неправильное семейство", expectedResult, actualResult);

    }

    //Параметризованный тест метода getKittens(int kittenCount)
    @Test
    public void getKittensWithArgumentReturnsCorrectValue() {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensAmount);

        assertEquals(actual, expected);
    }

    //Тест возвращаемого значения метода getKittens()
    @Test
    public void getKittensReturnsCorrectValue() {
        Feline feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens();

        assertEquals("Количество котят не равно 1", expected, actual);

    }

}
