import com.example.Alex;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlexTest {

    private Feline feline;
    private Alex alex;

    @Before
    public void setUp() throws Exception {
        //Мок объекта feline
        feline = Mockito.mock(Feline.class);
        //Экземпляр класса Alex c мок-объектом feline
        alex = new Alex(feline);
    }

    @Test
    public void getFriendsTest() {
        //Проверка метода getFriends()
        List<String> friends = alex.getFriends();
        assertEquals(List.of("Марти", "Глория", "Мелман"), friends);
    }

    @Test
    public void getPlaceOfLivingTest() {
        //Проверка метода getPlaceOfLiving()
        String placeOfLiving = alex.getPlaceOfLiving();
        assertEquals("Нью-Йоркский зоопарк", placeOfLiving);
    }

    @Test
    public void doesHaveManeTest() {
        //Проверка, что у Алекса есть грива
        assertTrue(alex.doesHaveMane());
    }

    @Test
    public void getKittensTest() {
        //Проверка метода getKittens()
        assertEquals(0, alex.getKittens());
    }
}
