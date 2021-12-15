import java.util.HashMap;
import java.util.Arrays;
import java.util.Stack;
import java.util.Collections;

public class advent {
    HashMap<String, Character> pairInsert = new HashMap<String, Character>();

    public advent() {
        pairInsert.put("SB",'B');
        pairInsert.put("HH",'P');
        pairInsert.put("VF",'N');
        pairInsert.put("BS",'S');
        pairInsert.put("NC",'C');
        pairInsert.put("BF",'H');
        pairInsert.put("BN",'H');
        pairInsert.put("SP",'H');
        pairInsert.put("BK",'H');
        pairInsert.put("FF",'N');
        pairInsert.put("VN",'B');
        pairInsert.put("FN",'C');
        pairInsert.put("FS",'S');
        pairInsert.put("PP",'F');
        pairInsert.put("ON",'H');
        pairInsert.put("FV",'F');
        pairInsert.put("KO",'F');
        pairInsert.put("PK",'H');
        pairInsert.put("VB",'S');
        pairInsert.put("HS",'B');
        pairInsert.put("NV",'O');
        pairInsert.put("PN",'S');
        pairInsert.put("VH",'B');
        pairInsert.put("OS",'P');
        pairInsert.put("BP",'H');
        pairInsert.put("OV",'B');
        pairInsert.put("HK",'S');
        pairInsert.put("NN",'K');
        pairInsert.put("SV",'C');
        pairInsert.put("PB",'F');
        pairInsert.put("SK",'F');
        pairInsert.put("FB",'S');
        pairInsert.put("NB",'K');
        pairInsert.put("HF",'P');
        pairInsert.put("FK",'K');
        pairInsert.put("KV",'P');
        pairInsert.put("PV",'F');
        pairInsert.put("BC",'S');
        pairInsert.put("FO",'N');
        pairInsert.put("HC",'F');
        pairInsert.put("CP",'B');
        pairInsert.put("KK",'F');
        pairInsert.put("PC",'S');
        pairInsert.put("HN",'O');
        pairInsert.put("SH",'H');
        pairInsert.put("CK",'P');
        pairInsert.put("CO",'F');
        pairInsert.put("HP",'K');
        pairInsert.put("PS",'C');
        pairInsert.put("KP",'F');
        pairInsert.put("OF",'K');
        pairInsert.put("KS",'F');
        pairInsert.put("NO",'V');
        pairInsert.put("CB",'K');
        pairInsert.put("NF",'N');
        pairInsert.put("SF",'F');
        pairInsert.put("SC",'P');
        pairInsert.put("FC",'V');
        pairInsert.put("BV",'B');
        pairInsert.put("SS",'O');
        pairInsert.put("KC",'K');
        pairInsert.put("FH",'C');
        pairInsert.put("OP",'C');
        pairInsert.put("CF",'K');
        pairInsert.put("VO",'V');
        pairInsert.put("VK",'H');
        pairInsert.put("KH",'O');
        pairInsert.put("NP",'V');
        pairInsert.put("NH",'O');
        pairInsert.put("NS",'V');
        pairInsert.put("BH",'C');
        pairInsert.put("CH",'S');
        pairInsert.put("CC",'F');
        pairInsert.put("CS",'P');
        pairInsert.put("SN",'F');
        pairInsert.put("BO",'S');
        pairInsert.put("NK",'S');
        pairInsert.put("OO",'P');
        pairInsert.put("VV",'F');
        pairInsert.put("FP",'V');
        pairInsert.put("OK",'C');
        pairInsert.put("SO",'H');
        pairInsert.put("KN",'P');
        pairInsert.put("HO",'O');
        pairInsert.put("PO",'H');
        pairInsert.put("VS",'N');
        pairInsert.put("PF",'N');
        pairInsert.put("CV",'F');
        pairInsert.put("BB",'H');
        pairInsert.put("VC",'H');
        pairInsert.put("HV",'B');
        pairInsert.put("CN",'S');
        pairInsert.put("OH",'K');
        pairInsert.put("KF",'K');
        pairInsert.put("HB",'S');
        pairInsert.put("OC",'H');
        pairInsert.put("KB",'P');
        pairInsert.put("OB",'C');
        pairInsert.put("VP",'C');
        pairInsert.put("PH",'K');
        // /pairInsert.put("CH",'B');
        // pairInsert.put("HH",'N');
        // pairInsert.put("CB",'H');
        // pairInsert.put("NH",'C');
        // pairInsert.put("HB",'C');
        // pairInsert.put("HC",'B');
        // pairInsert.put("HN",'C');
        // pairInsert.put("NN",'C');
        // pairInsert.put("BH",'H');
        // pairInsert.put("NC",'B');
        // pairInsert.put("NB",'B');
        // pairInsert.put("BN",'B');
        // pairInsert.put("BB",'N');
        // pairInsert.put("BC",'B');
        // pairInsert.put("CC",'N');
        // pairInsert.put("CN",'C');
    }

    public static void main(String[] args) {
        Stack<Character> template = new Stack<Character>();
        char[] input = { 'S','C','V','H','K','H','V','S','H','P','V','C','N','B','K','B','P','V','H','V' };
        // char[] input = { 'N', 'N', 'C', 'B' };
        for ( int i = 0; i < input.length; i++ ){
            template.push(input[i]);
        }
        // System.out.println(String.valueOf(template));
        advent mapping = new advent();

        for( int j = 0; j < 20; j++ ){
            Stack<Character> nextStep = new Stack<Character>();
            while ( template.empty() == false ){
                char first = template.pop();
                if ( template.empty() ){
                    nextStep.push(first);
                }
                else {
                    char second = template.peek();
                    String check = String.valueOf(second) + String.valueOf(first);
                    char insert = mapping.pairInsert.get(check);
                    nextStep.push(first);
                    nextStep.push(insert);
                }
            }
            while (nextStep.empty() == false ){
                char redo = nextStep.pop();
                template.push(redo);
            }
            
            // System.out.println(String.valueOf(nextStep));

            // template = nextStep;
        }
        System.out.println(String.valueOf(template));
        // System.out.println(template.size());

        // String indexes = "BCFHKNOPSV";
        // int[] count = new int[indexes.length()];
        // while ( template.empty() == false ){
        //     char val = template.pop();
        //     int index = indexes.indexOf(val);
        //     count[index]++;
        // }
        // for ( int i = 0; i < count.length; i++ ){
        //     System.out.println(indexes.charAt(i) + ":" + count[i]);
        // }
    }
}