package LessonsNika.lessons.Miner;

public interface UserAction {
        /**
         *инициализация игры
         */
        void initGame();

        /**
         * сохраняет действие пользователя с конкретной ячейкой
         * @param x
         * @param y
         * @param bomb
         */
        void select(int x, int y, boolean bomb);
}
