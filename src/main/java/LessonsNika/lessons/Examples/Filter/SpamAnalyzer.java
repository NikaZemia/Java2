package LessonsNika.lessons.Examples.Filter;

/**
 * SpamAnalyzer должен конструироваться от массива строк с ключевыми словами.
 * Объект этого класса должен сохранять в своем состоянии этот массив строк в приватном поле keywords.
 */
public class SpamAnalyzer extends KeywordAnalyzer{

        private final String[] keywords;

        public SpamAnalyzer(String[] text){
                this.keywords = text;
        }

        @Override
        public Label getLabel() {
                return Label.SPAM;
        }

        public String[] getKeywords() {
                return keywords;
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
