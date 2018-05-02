package LessonsNika.lessons;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

        @Test
        public void add() {
                Calculator calculator = new Calculator();
                calculator.add(1,2);
                assertEquals(3, calculator.getResult());
        }

        @Test
        public void minus() {
        }

        @Test
        public void multiplay() {
        }

        @Test
        public void divide() {
        }

        @Test
        public void getResult() {
        }

        @Test
        public void cleanResults() {
        }
}