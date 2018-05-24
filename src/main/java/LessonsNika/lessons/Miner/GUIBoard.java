package LessonsNika.lessons.Miner;

import javax.swing.*;
import java.awt.*;

public class GUIBoard extends JPanel implements Board {

        public static final int Padding = 50;
        public Cell<Graphics>[][] cells;

        @Override
        protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if(this.cells != null){
                        for (int x = 0; x!=cells.length; x++){
                                for (int y = 0; y != cells.length; y++){
                                        g.setColor(Color.BLACK);
                                        cells[x][y].draw(g, false);
                                        g.drawRect(x*Padding, y*Padding, Padding, Padding);
                                }
                        }
                }
        }

        public void DrawBoard(Cell[][] cells){
                this.cells = cells;
                this.repaint();
        }

        public void DrawCell(int x, int y){
                this.repaint();
        }

        public void DrawBang() {
                this.repaint();
        }

        public void DrawCongratulate() {

        }
}
