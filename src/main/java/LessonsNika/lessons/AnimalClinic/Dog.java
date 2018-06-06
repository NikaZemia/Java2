package LessonsNika.lessons.AnimalClinic;

public class Dog implements Pet{
        private final Pet pet;

        public Dog(final Pet pet){
               this.pet = pet;
        }

        public void MakeSound() {
                System.out.println(
                        String.format("%s say: %s", this.getName(), "Gav")
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
