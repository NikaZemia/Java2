package LessonsNika.lessons.Examples;

public class Counter {
        private int amount;

        public synchronized int increase(){
                amount++;
                return amount;
        }


}
