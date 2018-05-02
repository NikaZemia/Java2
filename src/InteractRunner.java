import java.util.Scanner;

public class InteractRunner {

        static Calculator calc;
        static String first, second, act, exit;

        public static void main(String[] args) {
                Scanner reader = new Scanner(System.in);
                try{
                        calc = new Calculator();
                        exit = "n";
                        while(!exit.equals("y")){
                                System.out.println("Enter first arg: ");
                                first = reader.next();
                                System.out.println("Enter second arg: ");
                                second = reader.next();
                                System.out.println("Select action: sumary(+:1), minus(-:2), multiplay(*:3), divide(/:4)");
                                act = reader.next();
                                Boolean action = VuborAction(act, first, second);
                                ShowResults(action);
                                calc.cleanResults();
                                System.out.println("Exit: yes(y)/no(n)");
                                exit = reader.next();
                        }
                }
                finally{
                        reader.close();
                }
        }

        public static boolean VuborAction(final String action, final String first, final String second){
                boolean tof = false;
                switch (action){
                        case "+":
                        case "1":
                                calc.add(Integer.valueOf(first), Integer.valueOf(second));
                                tof = true;
                                break;
                        case "-":
                        case "2":
                                calc.minus(Integer.valueOf(first), Integer.valueOf(second));
                                tof = true;
                                break;
                        case "*":
                        case "3":
                                calc.multiplay(Integer.valueOf(first), Integer.valueOf(second));
                                tof = true;
                                break;
                        case "/":
                        case "4":
                                calc.divide(Integer.valueOf(first), Integer.valueOf(second));
                                tof = true;
                                break;
                        default:
                                System.out.println("Do not action selected");
                                tof = false;
                }
                return tof;
        }

        public static void ShowResults(final boolean tof){
                if(tof){
                        System.out.println("result: " + calc.getResult());
                }
        }
}
