package LessonsNika.lessons.Examples;

import sun.nio.cs.StandardCharsets;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.logging.*;
import java.util.logging.Formatter;
import java.io.Serializable.*;

public class Example1 {
        public static void main(String[] args) {
                /*System.out.println("-----Test1-----");
                TestOne();

                System.out.println("-----Test2-----");
                TestTwo();

                System.out.println("-----Test3-----");
                TestThree();

                System.out.println("--------------------");
                String[] roles = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич", "Nbx"};
                String[] textLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                        "Аммос Федорович: Как ревизор?",
                        "Артемий Филиппович: Как ревизор?",
                        "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                        "Аммос Федорович: Вот те на!",
                        "Артемий Филиппович: Вот не было заботы, так подай!",
                        "Лука Лукич: Господи боже! еще и с секретным предписаньем!",
                        "Лука: Господи боже!"};
                String all = printTextPerRole(roles, textLines);
                System.out.println(all);

                System.out.println("-----Test4-----");
                TestFour();

                System.out.println("-----Robot-----");
                Robot robot = new Robot(5,2, Robot.Direction.UP);
                moveRobot(robot, 5, 4);

                System.out.println("-----SQR-----");
                double x1 = 9.0;
                System.out.println(sqrt(x1));

                System.out.println("-----LOGGER-----");
                LoggerTest();*/

 /*               System.out.println("-----File-----");
                try {
                        File file = new File("D:\\JavaProjects\\Java2");
                        System.out.println(file.getCanonicalPath());
                }
                catch (IOException e){
                        e.printStackTrace();
                }

                System.out.println("-----TestFive-----");
                try {
                        InputStream ar = new ByteArrayInputStream(new byte[]{0x33, 0x45, 0x01});
                        System.out.println(checkSumOfStream(ar));
                }
                catch (IOException ex){
                        ex.printStackTrace();
                }

                System.out.println("----------");
                *//*dfgdfgdfg**//*
                *//**dfgdfgdgdgd*//*
                System.out.println(4|3);
                System.out.println(Charset.defaultCharset());
                System.out.println("----------------");
                Reader reader = new StringReader("Ы");
                Scanner scanner = new Scanner(reader);
                System.out.print(scanner);

                System.out.println("-----");
                int a2 = 012;
                int a3 = 20;
                System.out.println(a2*a3);*/

/*                System.out.println("-----Serializable Animal-----");
                try {
                        Animal[] animalM1 = {new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                                new Animal("Tentecles"), new Animal("Worm")};
                        ByteArrayOutputStream bai = new ByteArrayOutputStream();
                        ObjectOutputStream oos = new ObjectOutputStream(bai);
                        oos.writeInt(animalM1.length);
                        for (int i = 0; i < animalM1.length; i++) {
                                oos.writeObject(animalM1[i]);
                        }
                        oos.flush();
                        oos.close();
                        Animal[] animalM2 = deserializeAnimalArray(bai.toByteArray());
                        for (int i = 0; i < animalM2.length; i++) {
                                System.out.printf("%d. %s \n", i+1, animalM2[i].getName());
                        }
                }
                catch (IOException ex){
                        ex.printStackTrace();
                }*/

                System.out.println(5^6&3);
                Boolean ab = new Boolean("dfg");
                System.out.println(ab);

        }

        public static void TestOne(){
                int[] a = {1,2,3};
                System.out.println(Arrays.toString(a));
                int[][] b = {{1,2,3},{4,5}};
                System.out.println(Arrays.toString(b));
                System.out.println(Arrays.deepToString(b));
                Integer[] c = {1,2,3};
                Integer[] f = {1,2,3};
                Integer[] d = {2,3,4};
                System.out.println(Arrays.deepEquals(c, d));
                System.out.println(Arrays.deepEquals(c, f));

                System.out.println("A" + ('\t' + '\u0003'));
                System.out.println("A" + 12);
                System.out.println('A' + '1' + "2");
                System.out.println('A' + "12");
        }

        public static void TestTwo(){
                String text = "Madam, I'm Adam!";
                String str = text.replaceAll("[^A-Za-z0-9]+", "");
                System.out.println(str);
                StringBuilder str2 = new StringBuilder(str);
                System.out.println(str2);
                str2.reverse();
                System.out.println(str2);
                String str3 = str2.toString();
                if(str.equalsIgnoreCase(str3)){
                        System.out.println(true);
                }
                else
                        System.out.println(false);
        }

        public static void TestThree(){
                int[] a1 = {0, 5, 2};
                int[] a2 = {1, 3};
                Arrays.sort(a1);
                Arrays.sort(a2);
                int[] c1 = new int[a1.length + a2.length];
                int g = 0;
                for(int i = 0; i <= a1.length-1; i++){
                        c1[g] = a1[i];
                        g++;
                }
                for(int i = 0; i <= a2.length-1; i++){
                        c1[g] = a2[i];
                        g++;
                }
                Arrays.sort(c1);
                System.out.println(Arrays.toString(c1));
        }

        public static void TestFour(){
                Test x = new Test(5);
                x.Show();
                x = new Test(6);
                x.Show();
        }

        private static String printTextPerRole(String[] roles, String[] textLines) {
                String all = "";
                for (int i = 0; i<=roles.length-1; i++){
                        if(!all.contains(roles[i])){
                                all = all.concat(roles[i] + ":\n");
                        }
                        for (int j = 0; j<=textLines.length-1; j++){
                                //ищем пробел в ролях
                                String role;
                                if(roles[i].contains(" ")){
                                        role = roles[i].substring(0, roles[i].indexOf(" "));
                                }
                                else {
                                        role = roles[i];
                                }
                               // System.out.println(role);

                                if(textLines[j].startsWith(role)){

                                        String text = textLines[j].replace(roles[i] + ": ", "");
                                        String text2 = text.replace(role + ": ", "");
                                        all = all.concat(j+1 +") " + text2 + "\n");
                                }
                        }
                        all = all.concat("\n");
                }
                return all;
        }

        public static class Test{
                private final int x;

                Test(final int x){
                        this.x = x;
                }

                public void Show(){
                        System.out.println(x);
                }
        }

        public static class Robot {
                private Direction direction;
                private int x, y;
                Robot(int x, int y, Direction direction) {
                        this.x = x;
                        this.y = y;
                        this.direction = direction;
                }
                public Direction getDirection() {
                        return direction;
                }
                public int getX() {
                        return x;
                }
                public int getY() {
                        return y;
                }
                public void turnLeft() {
                        if (direction == Direction.UP)
                                direction = Direction.LEFT;
                        else if (direction == Direction.LEFT)
                                direction = Direction.DOWN;
                        else if (direction == Direction.DOWN)
                                direction = Direction.RIGHT;
                        else if (direction == Direction.RIGHT)
                                direction = Direction.UP;
                        System.out.println("Turned left - current direction is " + direction.toString());

                }
                public void turnRight() {
                        if (direction == Direction.UP)
                                direction = Direction.RIGHT;
                        else if (direction == Direction.RIGHT)
                                direction = Direction.DOWN;
                        else if (direction == Direction.DOWN)
                                direction = Direction.LEFT;
                        else if (direction == Direction.LEFT)
                                direction = Direction.UP;
                        System.out.println("Turned right - current direction is " + direction.toString());
                }
                public void stepForward() {
                        if (direction == Direction.UP)
                                y++;
                        if (direction == Direction.DOWN)
                                y--;
                        if (direction == Direction.LEFT)
                                x--;
                        if (direction == Direction.RIGHT)
                                x++;
                        System.out.println("Stepped forward - current position: x=" + x + "; y=" + y + ";");
                }

                public enum Direction {
                        UP,
                        DOWN,
                        LEFT,
                        RIGHT
                }


        }

        private static void moveRobot(Robot robot, int toX, int toY) {
                //идем по оси Х
                if(robot.getX() < toX) {
                        switch (robot.getDirection()) {
                                case LEFT:{
                                        robot.turnRight();
                                        robot.turnRight();
                                        while (robot.getX() < toX) {
                                                robot.stepForward();
                                        }
                                        break;
                                }
                                case RIGHT:{
                                        while (robot.getX() < toX) {
                                                robot.stepForward();
                                        }
                                        break;
                                }
                                case UP:
                                        robot.turnRight();
                                        while (robot.getX() < toX) {
                                                robot.stepForward();
                                        }
                                        break;
                                case DOWN:{
                                        robot.turnLeft();
                                        while (robot.getX() < toX) {
                                                robot.stepForward();
                                        }
                                        break;
                                }
                        }
                }
                else {
                        switch (robot.getDirection()) {
                                case LEFT:{
                                        while (robot.getX() > toX) {
                                                robot.stepForward();
                                        }
                                        break;
                                }
                                case RIGHT:{
                                        robot.turnLeft();
                                        robot.turnLeft();
                                        while (robot.getX() > toX) {
                                                robot.stepForward();
                                        }
                                        break;
                                }
                                case UP:
                                        robot.turnLeft();
                                        while (robot.getX() > toX) {
                                                robot.stepForward();
                                        }
                                        break;
                                case DOWN:{
                                        robot.turnRight();
                                        while (robot.getX() > toX) {
                                                robot.stepForward();
                                        }
                                        break;
                                }
                        }
                }

                //идем по оси У
                if(robot.getY() < toY){
                        switch (robot.getDirection()) {
                                case LEFT:{
                                        robot.turnRight();
                                        while (robot.getY() < toY) {
                                                robot.stepForward();
                                        }
                                        break;
                                }
                                case RIGHT:{
                                        robot.turnLeft();
                                        while (robot.getY() < toY) {
                                                robot.stepForward();
                                        }
                                        break;
                                }
                                case UP:
                                        while (robot.getY() < toY) {
                                                robot.stepForward();
                                        }
                                        break;
                                case DOWN:{
                                        robot.turnRight();
                                        robot.turnRight();
                                        while (robot.getY() < toY) {
                                                robot.stepForward();
                                        }
                                        break;
                                }
                        }
                }
                else {
                        switch (robot.getDirection()) {
                                case DOWN:
                                while (robot.getY() > toY) {
                                        robot.stepForward();
                                }
                                break;
                                case UP:
                                {
                                        robot.turnLeft();
                                        robot.turnLeft();
                                        while (robot.getY() > toY) {
                                                robot.stepForward();
                                        }
                                        break;
                                }
                                case LEFT:{
                                        robot.turnLeft();
                                        while (robot.getY() > toY) {
                                                robot.stepForward();
                                        }
                                        break;
                                }
                                case RIGHT:{
                                        robot.turnRight();
                                        while (robot.getY() > toY) {
                                                robot.stepForward();
                                        }
                                        break;
                                }

                        }
                }
        }

        public static double sqrt(double x) {
                double answer = Double.NaN;
                if(x < 0){
                        answer = Double.NaN;
                        throw new IllegalArgumentException("" +
                                "Expected non-negative number, got " + x);
                }
                answer = Math.sqrt(x);
                return answer;
        }

        public static void LoggerTest(){
                Logger logger = Logger.getLogger(Robot.class.getName());
                Handler handler;
                try {
                        handler = new FileHandler("D:\\JavaProjects\\Java2\\src\\main\\java\\LessonsNika\\lessons\\log.xml");
                } catch (Exception e) {
                        handler = new ConsoleHandler();
                }
                Formatter formatter = new XMLFormatter();

                handler.setFormatter(formatter);
                handler.setLevel(Level.WARNING);
                logger.addHandler(handler);

                logger.log(Level.INFO, "test info");
                logger.log(Level.WARNING, "test warning"); // Выводится в файл

        }

        public static int checkSumOfStream(InputStream inputStream) throws IOException{
                int sum = 0;
                //try {
                        int k;
                        while ((k=inputStream.read())!=-1) {
                                sum = Integer.rotateLeft(sum, 1)^k;
                                //k = inputStream.read();
                        }
                /*}
                catch (IOException ex){
                        ex.printStackTrace();
                }
                finally {
                        inputStream.close();
                }*/
                return sum;
        }

        public static Animal[] deserializeAnimalArray(byte[] data) throws IOException{
                Animal[] an = new Animal[data.length-1];
                ByteArrayInputStream bais = new ByteArrayInputStream(data);
                ObjectInputStream ois = new ObjectInputStream(bais);
                int i = 0;
                int k;
                while ((k = ois.read())!=-1){
                       int any = k;
                        System.out.println(String.format("1. %s, 2. %s", any, (char)any));
                       i++;
                }
                return an;
        }
}

class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
                this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
                if (obj instanceof Animal) {
                        return Objects.equals(name, ((Animal) obj).name);
                }
                return false;
        }

        public String getName(){return name;}
}
