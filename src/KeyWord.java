import test.Label;


public class KeyWord {

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {

        Label label = Label.OK;

        for (int i=0;i<analyzers.length;i++ ){
            label = analyzers[i].processText(text);
            if (Label.OK != label) {
                break;
            }
        }

        return label;
    }

    abstract class KeywordAnalyzer implements TextAnalyzer {

        protected abstract String[] getKeywords();

        protected abstract Label getLabel();

        @Override
        public Label processText(String text) {

            for (String key : getKeywords()) {
                if (text.contains(key)) {
                    return getLabel();
                }
            }
            return Label.OK;
        }
    }


    public class SpamAnalyzer extends KeywordAnalyzer {

        private String[] keywords;

        public SpamAnalyzer(String[] key) {
            this.keywords = key;
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }
    }

    public class NegativeTextAnalyzer extends KeywordAnalyzer {

        private String[] keywords;

        public NegativeTextAnalyzer() {
            this.keywords = new String[]{":(", "=(", ":|"};
        }


        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }


    public class TooLongTextAnalyzer implements TextAnalyzer {

        private int maxLength;

        public TooLongTextAnalyzer(int size) {
            this.maxLength= size;
        }

        @Override
        public Label processText(String text) {
            Label label = Label.OK;

            if (text.length()<= maxLength) {

            } else {
                label = Label.TOO_LONG;
            }
            return label;
        }
    }
}
