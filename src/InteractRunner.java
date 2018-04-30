import java.util.Scanner;

public class InteractRunner {
        public static void main(String[] args) {
                Scanner reader = new Scanner(System.in);
                try{
                        Calculator calc = new Calculator();
                        String exit = "n";
                        while(!exit.equals("y")){
                                System.out.println("Enter first arg: ");
                                String first = reader.next();
                                System.out.println("Enter second arg: ");
                                String second = reader.next();
                                System.out.println("Select action: sumary(+:1), minus(-:2), multiplay(*:3), divide(/:4)");
                                String act = reader.next();
                                switch (act){
                                        case "+":
                                        case "1":
                                                calc.add(Integer.valueOf(first), Integer.valueOf(second));
                                                break;
                                        case "-":
                                        case "2":
                                                calc.minus(Integer.valueOf(first), Integer.valueOf(second));
                                                break;
                                        case "*":
                                        case "3":
                                                calc.multiplay(Integer.valueOf(first), Integer.valueOf(second));
                                                break;
                                        case "/":
                                        case "4":
                                                calc.divide(Integer.valueOf(first), Integer.valueOf(second));
                                                break;
                                                default:
                                                        System.out.println("Do not action selected");
                                }

                                System.out.println("result: " + calc.getResult());
                                calc.cleanResults();
                                System.out.println("Exit: yes(y)/no(n)");
                                exit = reader.next();
                        }
                }
                finally{
                        reader.close();
                }
        }
}
