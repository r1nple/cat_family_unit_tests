import com.example.Animal;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalTest {

    private Animal animal;

    @Before
    public void setUp() {
        //Экземпляр animal
        animal = new Animal();
    }

    @Test
    public void getFoodHerbivoreTest() throws Exception {
        //Список еды для травоядных
        List<String> food = animal.getFood("Травоядное");
        //Проверка, что список соответствует ОР
        assertEquals(List.of("Трава", "Различные растения"), food);
    }

    @Test
    public void getFoodUnknownTest() {
        //Проверка, что при запросе еды для неизвестного типа животного, возвращает исключение
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Неизвестное животное");
        });
        //Проверка сообщения, что оно соответствует ОР
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    public void getFamilyTest() {
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        //Проверка ОР с ФР
        assertEquals("Метод getFamily() возвращает неверную строку", expectedFamily, animal.getFamily());
    }
}
