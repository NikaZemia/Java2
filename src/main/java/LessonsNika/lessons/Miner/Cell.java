package LessonsNika.lessons.Miner;

public interface Cell<T> {

        /**
         * является ли это бомбой
         * @return
         */
        boolean isBomb();

        /**
         * предположение пользователя, что это бомба
         * @return
         */
        boolean isSuggestBomb();

        /**
         * предположение пользователя, что это пустая клетка
         * @return
         */
        boolean isSuggestEmpty();

        /**
         * устанавливает значение в клетку пустое значение
         */
        void suggectEmpty();

        /**
         * устанавливает значение в клетку равное бомбой
         */
        void suggestBomb();

        /**
         * рисование клетки
         * @param paint
         * @param real
         */
        void draw(T paint, boolean real);
}
