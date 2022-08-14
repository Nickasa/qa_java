import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    //Тест проверяет соответсвие рациона типу "Хищник"
    @Test
    public void getFoodReturnsCorrect() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedResult = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualResult = lion.getFood();

        assertEquals("Рацион не соответствует хищнику", expectedResult, actualResult);
    }

    //Тест проверяет, что количество котят при исопльзовании метода равно 1
    @Test
    public void getKittensReturnCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        int actual = lion.getKittens();

        assertEquals("Количество котят должно быть равно 1", expected, actual);
    }

    //Следующие три теста написаны без параметризации из-за использования @RunWith(MockitoJUnitRunner.class), которая не позволяет использовать аннотацию @RunWith(Parameterized.class),
    //как использовать их совместно в одном тесте я не нашел, если есть советы по этому поводу - напишите в комментарии к реквесту, я предпочел все-таки использовать мок вместо параметризации
    //чтобы избавиться от зависимостей тестов от класса Feline

    //Тест проверяет, что для самцов метод doesHaveMane() возвращает значение true
    @Test
    public void doesHaveManeReturnsTrueWhenLionIsMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expectedResult = true;
        boolean actualResult = lion.doesHaveMane();

        assertEquals("У самцов есть гривы", expectedResult, actualResult);
    }

    //Тест проверяет, что для самок метод doesHaveMane() возвращает значение false
    @Test
    public void doesHaveManeReturnsFalseWhenLionIsFemale() throws Exception{
        Lion lion = new Lion("Самка", feline);
        boolean expectedResult = false;
        boolean actualResult = lion.doesHaveMane();

        assertEquals("У самок нет грив", expectedResult, actualResult);
    }

    //Тест проверятет, что если значение аргумента sex не равно "Самец" или "Самка", то выбрасывается исключение, проверку текста исключения я не нашел как сделать
    @Test(expected = Exception.class)
    public void doesHaveManeReturnsErrorWhenSexIsUndefined() throws Exception{
        Lion lion = new Lion("Пингвин", feline);
        boolean thrown = false;
        try {
            lion.doesHaveMane();
        } catch (Exception exception) {
            thrown = true;
        }
        boolean expected = true;
        boolean actual = thrown;

        assertEquals("Ожидается исключение", expected, actual);
    }
}
