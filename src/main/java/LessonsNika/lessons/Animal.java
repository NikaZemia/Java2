package LessonsNika.lessons;

public class Animal implements Pet{
        private String name;
        private int age;


        public Animal(final String name, final int age){
                this.name = name;
                this.age = age;
        }

        public void MakeSound() {
                System.out.println(
                        String.format("%s say: %s", this.name, "beep")
                );
        }

        public String getName() {
                return this.name;
        }

        public int getAge() {
                return this.age;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setAge(int age) {
                this.age = age;
        }
}
