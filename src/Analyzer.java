
public class Analyzer {

    public static void main(String[] args) {

        TextAnalyzer a = new KeyWord().new SpamAnalyzer(new String[] {"spam","branch"});
        TextAnalyzer b = new KeyWord().new NegativeTextAnalyzer();
        TextAnalyzer c = new KeyWord().new TooLongTextAnalyzer(16);
        System.out.println(KeyWord.checkLabels(new TextAnalyzer[]{a, b, c}, "text for testing"));
    }



}
