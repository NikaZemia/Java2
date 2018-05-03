package LessonsNika.lessons;

public class Cat implements Pet {

        private final Pet pet;

        public Cat(final Pet pet){
                //super(name);
                this.pet = pet;
        }

        public void MakeSound() {
                System.out.println(
                        String.format("%s say: %s", this.getName(), "May")
                );
        }

       public String getName() {
                return this.pet.getName();
        }

        public int getAge() {
                return this.pet.getAge();
        }

        public void setName(String name) {
                this.pet.setName(name);
        }

        public void setAge(int age) {
                this.pet.setAge(age);
        }
}
