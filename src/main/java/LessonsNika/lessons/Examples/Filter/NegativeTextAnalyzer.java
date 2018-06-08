package LessonsNika.lessons.Examples.Filter;

/**
 * NegativeTextAnalyzer должен конструироваться конструктором по-умолчанию.
 */
public class NegativeTextAnalyzer extends KeywordAnalyzer{

        private final String[] negativeText;

        public NegativeTextAnalyzer(){
                this.negativeText = new String[]{":(", "=(", ":|"};
        }

        @Override
        public Label getLabel() {
                return Label.NEGATIVE_TEXT;
        }

        @Override
        public String[] getKeywords() {
                return negativeText;
        }

        public Label processText(String text) {
                String[] keyWords = getKeywords();
                boolean found = false;
                for (String st:keyWords
                        ) {
                        if(text.indexOf(st)!=-1){
                                found = true;
                                break;
                        }
                }
                if(found){
                        return getLabel();
                }
                else
                        return Label.OK;
        }
}
