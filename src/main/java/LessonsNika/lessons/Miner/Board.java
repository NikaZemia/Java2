package LessonsNika.lessons.Miner;

public interface Board {

        /**
         * рисует доску исходя из входящего количества ячеек
         *
         * @param cells - массив ячеек
         */
        void DrawBoard(Cell[][] cells);

        /**
         * рисует ячейку
         * @param x - позиция по горизонтали
         * @param y - позиция по вертикали
         */
        void DrawCell(int x, int y);

        /**
         * рисует взрыв всех бомб
         */
        void DrawBang();

        /**
         * рисует поздравление, когда игрок выигрывает
         */
        void DrawCongratulate();
}
