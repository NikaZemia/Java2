package LessonsNika.lessons.AnimalClinic;

public class Client {
        private String id;
        private Pet pet;

        public void setId(String id) {
                this.id = id;
        }

        public void setPetName(String name) {
                this.pet.setName(name);
        }

        public void setPetAge(int age) {
                this.pet.setAge(age);
        }

        public Client(){

               this.id = "";
               this.pet = new Pet() {
                       public void MakeSound() {}

                       public String getName() {return "";}

                       public int getAge() {return 0;}

                       public void setName(String name) {}

                       public void setAge(int age) {}
               };
       }

        public Client(String id, Pet pet){
                this.id = id;
                this.pet = pet;
        }

        public String getId() {
                return id;
        }

        public String getPet() {
                return String.format(pet.getName()+", age: " + pet.getAge());
        }

        public String getPetName(){
                return pet.getName();
        }

        public int getPetAge(){
                return pet.getAge();
        }
}
