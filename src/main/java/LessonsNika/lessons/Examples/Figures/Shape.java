package LessonsNika.lessons.Examples.Figures;

import LessonsNika.lessons.Examples.Figures.Color;

public class Shape {
        private final Color color;

        public Shape(Color color){
                this.color = color;
        }

        public Color getColor(){return color;}

        public double getArea(){return Double.NaN;}
}
