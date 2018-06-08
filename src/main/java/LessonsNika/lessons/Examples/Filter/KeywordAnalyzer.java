package LessonsNika.lessons.Examples.Filter;

/**
 *
 */
public abstract class KeywordAnalyzer implements TextAnalyzer{
        /**
         * будет возвращать набор ключевых слов
         */
        protected abstract String[] getKeywords();

        /**
         * метку, которой необходимо пометить положительные срабатывания
         * @return
         */
        protected abstract Label getLabel();

        public Label processText(String text) {
                return null;
        }
}
