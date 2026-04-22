import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {

    private Feline feline;
    private Cat cat;

    @Before
    public void setUp() {
        //Мок объект
        feline = Mockito.mock(Feline.class);
        //Объект cat с мок объектом Feline
        cat = new Cat(feline);
    }

    @Test
    public void getSoundTest() {
        //Проверка, что метод возвращает звук Cat
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodTest() throws Exception {
        //Метод получения еды Cat
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(food);
        //Проверка, что список совпадает с ОР
        assertEquals("getFood() должен возвращать еду хищника", food, cat.getFood());
    }
}
