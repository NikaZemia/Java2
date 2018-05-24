package LessonsNika.lessons.Miner;

public interface SaperLogic {

        /**
         * загружает поле
         * @param cells
         */
        void loadBoard(Cell[][] cells);

        /**
         * проверка, необходимо ли взорвать все поле
         * @param x
         * @param y
         * @return
         */
        boolean shouldBang(int x, int y);

        /**
         * проверяет заказнчивается игра или нет
         * @return
         */
        boolean finish();

        /**
         * события, которые отмечает пользователь
         * @param x
         * @param y
         * @param bomb
         */
        void suggest(int x, int y, boolean bomb);
}
