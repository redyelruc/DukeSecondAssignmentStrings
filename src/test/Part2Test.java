import org.junit.*;

public class Part2Test {
    Part2 part2;
    String stringA;
    String stringB;

    @Before
    public void setup() {
        part2 = new Part2();
    }

    @Test
    public void testHowManyANinBANANAReturns2(){
        stringA = "AN";
        stringB = "BANANA";
        int expected = 2;
        Assert.assertEquals(expected, part2.howMany(stringA, stringB));
    }

    @Test
    public void testHowManyATinBANANAReturns0(){
        stringA = "AT";
        stringB = "BANANA";
        int expected = 0;
        Assert.assertEquals(expected, part2.howMany(stringA, stringB));
    }

    @Test
    public void testHowManyAAinBAAAAAExcludesOverlapsReturns2(){
        stringA = "AA";
        stringB = "BAAAAA";
        int expected = 2;
        Assert.assertEquals(expected, part2.howMany(stringA, stringB));
    }

    @Test
    public void testHowManyEmptyStringsinBAAAAAReturns0(){
        stringA = "";
        stringB = "BAAAAA";
        int expected = 0;
        Assert.assertEquals(expected, part2.howMany(stringA, stringB));
    }

    @Test
    public void testHowManyAinEmptyStringReturns0(){
        stringA = "A";
        stringB = "";
        int expected = 0;
        Assert.assertEquals(expected, part2.howMany(stringA, stringB));
    }
}
