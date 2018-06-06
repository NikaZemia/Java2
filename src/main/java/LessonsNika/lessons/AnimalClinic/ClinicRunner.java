package LessonsNika.lessons.AnimalClinic;

import LessonsNika.lessons.UserException;

import java.util.Scanner;

public class ClinicRunner {

        private static int counter;
        private static String exit;
        private static Scanner in;

        public static void main(String[] args) {
                final Clinic clinic = new Clinic(10);
                clinic.addClient(new Client("nick", new Dog(new Animal("Sparki", 15))));

                in = new Scanner(System.in);
                //переменные для пунктов меню
                int numberMenu = 0;

                while (numberMenu != 7) {
                        ShowMainMenu();
                        numberMenu = in.nextInt();
                        switch (numberMenu){
                                case 1:
                                        clinic.Show();
                                        break;
                                case 2:
                                        PunktAddClient(clinic);
                                        break;
                                case 3:
                                        PunktFindClientByName(clinic);
                                        break;
                                case 4:
                                        PunktFindClientByPetName(clinic);
                                        break;
                                case 5:
                                        PunktDivideClient(clinic);
                                        break;
                                case 6:
                                        PunktChangeClient(clinic);
                                        break;

                                        default: break;
                        }

                }


        }

        /**
         * показывает главное меню
         */
        public static void ShowMainMenu(){
                System.out.println("-----MENU (press number menu)-----");
                System.out.println("1. Show all clients\n" +
                        "2. Add client\n" +
                        "3. Find client by name\n" +
                        "4. Find client by Pet name\n" +
                        "5. Divide client\n" +
                        "6. Change information about client\n" +
                        "7. Exit");
        }

        /**
         * создает клиента перед помещением его в клиенику
         * @param nameClient имя нового клиента
         * @param namePet имя нового питомца клиента
         * @param age возвраст питомца
         * @param numberPet вид питомца (1 - кот, 2 - собака)
         * @return клиента
         */
        public static Client AddClient(final String nameClient, final String namePet, final int age, final int numberPet){
                Client cl;
                if(numberPet == 1)
                        cl = new Client(nameClient, new Cat(new Animal(namePet, age)));
                else
                        cl = new Client(nameClient, new Dog(new Animal(namePet, age)));
                //counter++;
                return cl;
        }

        /**
         * запускает пункт меню Добавить клиента и запрашивает данные о новом клиенте
         * @param clinic клиника
         */
        public static void PunktAddClient(final Clinic clinic){
                //переменные для заполнения данных о клиенте
                String newClient, newPet;
                int newAgePet, numberPet;
                exit = "n";
                while (!exit.equals("y")) {
                        try {
                                System.out.println("-----Add client-----");
                                System.out.println("Enter name of client");
                                newClient = in.next();
                                System.out.println("Enter pet: cat(1), dog(2)");
                                numberPet = in.nextInt();
                                System.out.println("Enter name of the pet");
                                newPet = in.next();
                                System.out.println("Enter age of the pet");
                                newAgePet = in.nextInt();
                                //clinic.addClient(counter, AddClient(newClient, newPet, newAgePet, numberPet));
                                clinic.addClient(AddClient(newClient, newPet, newAgePet, numberPet));
                                System.out.println("-----Exit to previous menu? yes(y), no(n)-----");
                                exit = in.next();

                        } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                        }
                }
        }

        /**
         * поиск клента по имени клиента
         * @param clinic клиника
         */
        public static void PunktFindClientByName(final Clinic clinic){
                System.out.println("Enter name of client");
                String findName = in.next();
                Client cl = clinic.findClientsByName(findName);
                if(!cl.getId().equalsIgnoreCase(""))
                        ShowClient(cl);
                else
                        System.out.println("Client is not found");
        }

        /**
         * поиск клента по имени питомца
         * @param clinic клиника
         */
        public static void PunktFindClientByPetName(final Clinic clinic){
                System.out.println("Enter name of pet");
                String findName = in.next();
                Client cl = clinic.findClientsByPetName(findName);
                if(!cl.getId().equalsIgnoreCase(""))
                        ShowClient(cl);
                else
                        System.out.println("Client is not found");
        }

        /**
         * показывает информакцию о найденном клиенте
         * @param cl клиент
         */
        public static void ShowClient(final Client cl){
                System.out.println("-----Find client-----");
                System.out.println(cl.getId() + ": " + cl.getPet());
        }

        /**
         * удаляет клиент из списка клиники
         */
        public static void PunktDivideClient(Clinic clinic){
                boolean find = false;
                while (!find) {
                        System.out.println("Enter name of client");
                        String findName = in.next();
                        Client cl = clinic.findClientsByName(findName);
                        if (!cl.getId().equalsIgnoreCase("")) {
                                find = true;
                                ShowClient(cl);
                        }
                        else {
                                System.out.println("Client is not found");
                                find = false;
                                continue;
                        }
                        System.out.println("Divide the client? yes(y)/no(n)");
                        String answer = in.next();
                        if (answer.equalsIgnoreCase("y")) {
                                clinic.RemoveClient(cl);
                                clinic.Show();
                        }
                }
        }

        /**
         * изменяет информацию о клиенте
         * @param clinic клиника
         */
        public static void PunktChangeClient(final Clinic clinic){
                boolean find = false;
                System.out.println("-----Change client information-----");
                while (!find) {
                        System.out.println("Enter name of client");
                        String findName = in.next();
                        Client cl = clinic.findClientsByName(findName);

                        if (!cl.getId().equalsIgnoreCase("")) {
                                ShowClient(cl);
                                find = true;
                        }
                        else {
                                System.out.println("Client is not found");
                                find = false;
                                continue;
                        }

                        int number = 0;
                        while (number != 44) {
                                System.out.println("Change: name client(11), name pet(22), age pet(33), exit to previous menu(44)");
                                number = in.nextInt();
                                switch (number) {
                                        case 11:
                                                System.out.println("Enter new name of client");
                                                String name = in.next();
                                                cl.setId(name);
                                                ShowClient(cl);
                                                break;
                                        case 22:
                                                System.out.println("Enter new name of pet");
                                                String namePet = in.next();
                                                cl.setPetName(namePet);
                                                ShowClient(cl);
                                                break;
                                        case 33:
                                                System.out.println("Enter age of pet");
                                                int age = in.nextInt();
                                                cl.setPetAge(age);
                                                ShowClient(cl);
                                                break;
                                }
                        }
                }
        }
}
