package LessonsNika.lessons.Examples.Figures;

public class Circle extends Shape{

        private final Point centre;
        private final double radius;

        public Circle(Point center, double radius, Color color){
                super(color);
                this.centre = center;
                this.radius = radius;
        }

        public Point getCentre(){return centre;}

        public double getRadius(){return radius;}

        @Override
        public double getArea() {
                return radius * radius * Math.PI;
        }

        @Override
        public String toString() {
                return "Circle{" +
                        "center=" +centre +
                        ", radius=" + radius +
                        ", color=" + getColor()+"}";
        }
}
