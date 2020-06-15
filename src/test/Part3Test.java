import org.junit.*;

public class Part3Test {
    Part3 part3;
    String dna;
    String startCodon;
    String stopCodon;
    int startIndex;

    @Before
    public void setup() {
        part3 = new Part3();
        startCodon = "ATG";

    }

    @Test
    public void testFindStopCodonFirstOccurrenceIsValidReturns10() {
        dna = "AATGGTCCCATAAATT";
        stopCodon = "TAA";
        startIndex = dna.indexOf(startCodon);
        int expected = 10;
        Assert.assertEquals(expected, part3.findStopCodon(dna, startIndex, stopCodon));
    }

    @Test
    public void testFindStopCodonSecondOccurrenceIsValidReturns16() {
        dna = "AATGGTSGTSGTAATCTAAGTC";
        stopCodon = "TAA";
        startIndex = dna.indexOf(startCodon);
        int expected = 16;
        Assert.assertEquals(expected, part3.findStopCodon(dna, startIndex, stopCodon));
    }

    @Test
    public void testFindStopCodonNoOccurrencesReturnsDnaLength() {
        dna = "AATGTGTGTGATGATGATGGT";
        stopCodon = "TAA";
        startIndex = dna.indexOf(startCodon);
        int expected = dna.length();
        Assert.assertEquals(expected, part3.findStopCodon(dna, startIndex, stopCodon));
    }

    @Test
    public void testFindGeneNoValidStartIndexReturnsEmptyString() {
        dna = "AACGTGTAATCTCTAG";
        String expected = "";
        Assert.assertEquals(expected, part3.findGene(dna));
    }

    @Test
    public void testFindGeneOneValidStopCodonReturnsGene() {
        dna = "AATGTGTAATGTCTAG";
        String expected = "ATGTGTAATGTCTAG";
        Assert.assertEquals(expected, part3.findGene(dna));
    }

    @Test
    public void testFindGeneThreeStopCodonsReturnsGene() {
        dna = "AATGTAATGATAGATCATC";
        String expected = "ATGTAA";
        Assert.assertEquals(expected, part3.findGene(dna));
    }

    @Test
    public void testCountAllGenesNoGeneReturns0() {
        dna = "AATGTATGCATGGATCATC";
        int expected = 0;
        Assert.assertEquals(expected, part3.countAllGenes(dna));
    }


    @Test
    public void testCountAllGenesEmptyDnaStringReturns0() {
        dna = "";
        int expected = 0;
        Assert.assertEquals(expected, part3.countAllGenes(dna));
    }

    @Test
    public void testCountAllGenesVariousStopCodonsReturns3() {
        dna = "AATGTAATGAATGTAGATATGCATTGAC";
        int expected = 3;
        Assert.assertEquals(expected, part3.countAllGenes(dna));
    }

}
