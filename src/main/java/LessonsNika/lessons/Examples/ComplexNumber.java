package LessonsNika.lessons.Examples;

public class ComplexNumber {
        private final double re;
        private final double im;

        public ComplexNumber(double re, double im) {
                this.re = re;
                this.im = im;
        }

        public double getRe() {
                return re;
        }

        public double getIm() {
                return im;
        }

        @Override
        public boolean equals(Object obj) {
                //return super.equals(obj);
                if(this==obj){
                        return true;
                }
                if(obj==null){
                        return false;
                }
                if(getClass()!=obj.getClass()){
                        return false;
                }
                ComplexNumber other = (ComplexNumber) obj;
                if(getIm()==other.getIm() && getRe()==other.getRe()){
                        return true;
                }
                else
                        return false;
        }

        @Override
        public int hashCode() {
                //return super.hashCode();
                final double prime = 31;
                double result = 1;
                result = prime * result + getIm();
                result = prime * result + getRe();
                return (int) result;
        }
}
