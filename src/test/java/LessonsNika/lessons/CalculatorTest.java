package LessonsNika.lessons;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

        @Test
        public void add() throws UserException{
                System.out.println("add");
                Calculator calculator = new Calculator();
                calculator.add(1,2);
                assertEquals(3, calculator.getResult());
        }

        @Test
        public void minus() throws UserException{
                System.out.println("minus");
                Calculator calculator = new Calculator();
                calculator.minus(5,2);
                assertEquals(3, calculator.getResult());
        }

        @Test
        public void multiplay() throws UserException{
                System.out.println("multiplay");
                Calculator calculator = new Calculator();
                calculator.multiplay(3,2);
                assertEquals(6, calculator.getResult());
        }

        @Test
        public void divide() throws UserException{
                System.out.println("divide");
                Calculator calculator = new Calculator();
                calculator.divide(6,2);
                assertEquals(3, calculator.getResult());
        }

}