import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private Feline feline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        //Мок объект
        feline = Mockito.mock(Feline.class);
        //Объект lion с мок объектом Feline
        lion = new Lion("Самец", feline);
    }

    @Test
    public void getKittensTest() {
        //Мок объекта с методом getKittens(), возврат 2
        Mockito.when(feline.getKittens()).thenReturn(2);
        //Проверка, метод getKittens() класса Lion возвращает 2
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        //Мок объекта с методом getFood("Хищник") возвращает список "Животные", "Птицы", "Рыба"
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        //Проверка работы метода getFood() класса Lion
        List<String> food = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void shouldThrowExceptionForInvalidSexTest() {
        Feline feline = new Feline();
        //Проверка, что при передаче некорректного значения пола будет возвращать исключение
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Другое", feline);
        });
        //Проверка, что сообщение исключения соответствует ОР
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
