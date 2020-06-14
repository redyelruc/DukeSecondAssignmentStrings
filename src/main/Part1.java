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
}