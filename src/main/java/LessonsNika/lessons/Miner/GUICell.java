package LessonsNika.lessons.Miner;

import java.awt.*;

public class GUICell implements Cell<Graphics> {

        public boolean isBomb() {
                return false;
        }

        public boolean isSuggestBomb() {
                return false;
        }

        public boolean isSuggestEmpty() {
                return false;
        }

        public void suggectEmpty() {

        }

        public void suggestBomb() {

        }


        /**
         * прорисовывет ячейку с определенным значением(бомба или пусто)
         * @param paint
         * @param real
         */
        public void draw(Graphics paint, boolean real) {

        }
}
