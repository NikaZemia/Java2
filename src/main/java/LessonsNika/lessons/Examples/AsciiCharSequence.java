package LessonsNika.lessons.Examples;

public class AsciiCharSequence implements CharSequence {

        private final byte[] mas;

        public AsciiCharSequence(byte[] mas){
                this.mas = mas;
        }
        public int length() {
                int i = 0;
                for (byte mass:mas){
                        i++;
                }
                return i;
        }

        public char charAt(int index) {
                return (char) mas[index];
        }

        public CharSequence subSequence(int start, int end) {
                byte[] ms = new byte[end-start];
                int j = 0;
                for (int i = start; i< end; i++){
                        ms[j] = mas[i];
                        j++;
                }
                AsciiCharSequence chars = new AsciiCharSequence(ms);
                return chars;
        }

        public String toString() {
                char[] symbol = new char[mas.length];
                for (int i = 0; i < mas.length; i++){
                        symbol[i]=(char)mas[i];
                }
                return String.valueOf(symbol);
        }
}
