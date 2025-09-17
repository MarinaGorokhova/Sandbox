import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class DivideTest {
    //КРАТНО 3, возвращается 'T'
    //КРАТНО 5, возвращается 'M'
    //КРАТНО 3 и 5, возвращается 'TEAM'

    public String checkingDivision(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "TEAM";
        } else if (number % 3 == 0) {
            return "T";
        } else if (number % 5 == 0) {
            return "M";
        } else return "FAIL";
    }

    @Test
    public void checkDivisionIntoThree() {
        String actualResult = checkingDivision(9);
        assertEquals(actualResult, "T");
    }

    @Test
    public void checkDivisionIntoFive() {
        String actualResult = checkingDivision(25);
        assertEquals(actualResult, "M");
    }

    @Test
    public void checkDivisionIntoThreeAndFive() {
        String actualResult = checkingDivision(15);
        assertEquals(actualResult, "TEAM");
    }

    @Test
    public void checkDivision() {
        String actualResult = checkingDivision(1);
        assertEquals(actualResult, "FAIL");
    }
}

