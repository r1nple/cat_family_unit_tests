import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        //Экземпляр класса Feline
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        //Метод для получения списка еды
        List<String> food = feline.eatMeat();
        //Проверка, что список совпадает с ОР
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void getFamilyTest() {
        //Проверка, что метод возвращает название семейства
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensDefaultTest() {
        //Проверка, что метод возвращает 1 по умолчанию
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithArgumentTest() {
        //Проверка, что метод возвращает ожидаемое количество
        assertEquals(3, feline.getKittens(3));
    }
}
