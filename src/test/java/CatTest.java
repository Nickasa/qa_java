import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    //Тест на проверку возвращаемого значения метода getSound()
    @Test
    public void getSoundReturnCorrectValue() {
        Cat cat = new Cat(feline);

        String expected = "Мяу";
        String actual = cat.getSound();

        assertEquals("Кошка издает не такой звук", expected, actual);
    }

    //Тест соответствия рациона кошки, не до конца в нем уверен, поскольку метода getFood() возвращает значение
    //метода eatMeat() переопределенного в классе Feline, сложная для восприятия конструкция, мок использовал для
    //отделения зависимости от класса Feline
    @Test
    public void getFoodReturnsCorrectValue() throws Exception {
        Cat cat = new Cat(feline);

        Mockito.when(feline.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedResult = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualResult = cat.getFood();

        assertEquals("Рацион не соответствует кошке", expectedResult, actualResult);

    }

}
