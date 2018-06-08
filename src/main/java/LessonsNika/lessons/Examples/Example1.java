package LessonsNika.lessons.Examples;

import java.util.*;

public class Example1 {
        public static void main(String[] args) {
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

                System.out.println("-----------------");
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

                System.out.println("-----------------");
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

                Test x = new Test(5);
                x.Show();
                x = new Test(6);
                x.Show();

                System.out.println("-----Robot-----");
                Robot robot = new Robot(5,2, Robot.Direction.UP);
                moveRobot(robot, 5, 4);
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
}
