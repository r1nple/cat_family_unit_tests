import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    //Поля
    private final String sex;
    private final boolean expectedHasMane;

    private Feline feline;

    //Конструктор
    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    //Данные для тестов параметризованных
    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] getLionData() {
        return new Object[][] {
                {"Самец", true}, //Есть грива
                {"Самка", false}, //Нет гривы
        };
    }

    @Before
    public void setUp() {
        //Мок для feline
        feline = Mockito.mock(Feline.class);
    }

    @Test
    public void DoesHaveMane() throws Exception {
        //Экземпляр класса Lion c полом
        Lion lion = new Lion(sex, feline);
        //Проверка ФР с ОР
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}