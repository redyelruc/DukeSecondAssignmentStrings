public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            if ((currIndex - startIndex) % 3 != 0) {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            } else {
                break;
            }
        }
        if (currIndex == -1) {
            currIndex = dna.length();
        }
        return currIndex;
    }

    public String findGene(String dna){
        String gene = "";
        int startIndex = dna.indexOf("ATG");
        if (startIndex != -1){
            int stopIndexTAA = findStopCodon(dna, startIndex, "TAA") + 3;
            int stopIndexTAG = findStopCodon(dna,startIndex, "TAG") + 3;
            int stopIndexTGA = findStopCodon(dna,startIndex, "TGA") + 3;
            int stopIndex = Math.min(Math.min(stopIndexTAA, stopIndexTAG), stopIndexTGA);
            if (stopIndex <= dna.length()){
                gene = dna.substring(startIndex, stopIndex);
            }
        }
        return gene;
    }

    public void printAllGenes(String dna){
        String gene = findGene(dna);
        System.out.println(gene);

        while (!gene.equals("")){
            int newStart = dna.indexOf(gene) + gene.length();
            String newDna = dna.substring(newStart);
            gene = findGene(newDna);
            System.out.println(gene);
        }
    }

//    public static void main (String[] args){
//        Part1 p1 = new Part1();
//        String dna = "AATGTATGCATGGATCATC";
//        p1.printAllGenes(dna);
//    }
}
