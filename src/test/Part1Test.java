import org.junit.*;

public class Part1Test {
    Part1 part1;
    String dna;
    String stopCodon;
    String startCodon;
    int startIndex;

    @Before
    public void setup() {
        part1 = new Part1();
        startCodon = "ATG";

    }

    @Test
    public void testFindStopCodonFirstOccurrenceIsValidReturns10() {
        dna = "AATGGTCCCATAAATT";
        stopCodon = "TAA";
        startIndex = dna.indexOf(startCodon);
        int expected = 10;
        Assert.assertEquals(expected, part1.findStopCodon(dna, startIndex, stopCodon));
    }

    @Test
    public void testFindStopCodonSecondOccurrenceIsValidReturns16(){
        dna = "AATGGTSGTSGTAATCTAAGTC";
        stopCodon = "TAA";
        startIndex = dna.indexOf(startCodon);
        int expected = 16;
        Assert.assertEquals(expected, part1.findStopCodon(dna, startIndex, stopCodon));
    }

    @Test
    public void testFindStopCodonNoOccurrencesReturnsDnaLength(){
        dna = "AATGTGTGTGATGATGATGGT";
        stopCodon = "TAA";
        startIndex = dna.indexOf(startCodon);
        int expected = dna.length();
        Assert.assertEquals(expected, part1.findStopCodon(dna, startIndex, stopCodon));
    }

    @Test
    public void testFindGeneNoValidStartIndexReturnsEmptyString(){
        dna = "AACGTGTAATCTCTAG";
        String expected = "";
        Assert.assertEquals(expected, part1.findGene(dna));
    }
    @Test
    public void testFindGeneOneValidStopCodonReturnsGene(){
        dna = "AATGTGTAATGTCTAG";
        String expected = "ATGTGTAATGTCTAG";
        Assert.assertEquals(expected, part1.findGene(dna));
    }
    @Test
    public void testFindGeneThreeValidStopCodonsReturnsGene(){
        dna = "AATGTAATGATAGATCATC";
        String expected = "ATGTAA";
        Assert.assertEquals(expected, part1.findGene(dna));
    }

//    @Test
//    public void testPrintAllGenesNoGenesReturnsEmptyString(){
//        dna = "AATGTATGCATGGATCATC";
//        String expected = "";
//        Assert.assertEquals(expected, part1.printAllGenes(dna));
//    }


}
