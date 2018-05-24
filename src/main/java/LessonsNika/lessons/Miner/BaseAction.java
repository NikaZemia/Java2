package LessonsNika.lessons.Miner;

public class BaseAction implements UserAction {

        private final GenerationBoard generator;
        private final Board board;
        private final SaperLogic logic;

        public BaseAction(final SaperLogic logic, final Board board, GenerationBoard generator){
                this.board = board;
                this.logic = logic;
                this.generator = generator;
        }

        public void initGame() {
                final Cell[][] cells = generator.generate();
                this.board.DrawBoard(cells);
                this.logic.loadBoard(cells);
        }

        public void select(int x, int y, boolean bomb) {
                this.logic.suggest(x, y, bomb);
                board.DrawCell(x, y);
                if(this.logic.shouldBang(x, y)){
                        this.board.DrawBang();
                }
                if(this.logic.finish()){
                        board.DrawCongratulate();
                }
        }
}
