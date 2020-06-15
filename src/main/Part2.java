public class Part2 {


    public int howMany(String stringA, String stringB){
        int occurrences = 0;
        if (stringA != "" && stringB != ""){
            int currIndex = stringB.indexOf(stringA);
            while (currIndex != -1) {
                occurrences++;
                currIndex = stringB.indexOf(stringA, currIndex + stringA.length());
            }
        }
        return occurrences;
    }
}
