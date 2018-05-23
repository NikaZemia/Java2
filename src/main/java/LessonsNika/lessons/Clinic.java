package LessonsNika.lessons;

import java.util.LinkedList;

public class Clinic {
        private final LinkedList<Client> clients;

        public Clinic(final int size){
                this.clients = new LinkedList<Client>();
        }

        /**
         * add client
         */
        public void addClient(final Client client){
                try {
                        this.clients.add(client);
                }
                catch (Exception ex){
                        System.out.println(ex.getMessage());
                }
        }

        /**
         * поиск клиента по имени
         * @param name - имя клиента
         * @return клиент
         */
        public Client findClientsByName(final String name){
                Client findClient = new Client();
                for (Client cl:clients
                     ) {
                        if(cl.getId().equalsIgnoreCase(name)) {
                                findClient = cl;
                                break;
                        }
                }
                return findClient;
        }

        /**
         * поиск клиента по имени питомца
         * @param name - имя питомца
         * @return клиент
         */
        public Client findClientsByPetName(final String name){
                Client findClient = new Client();
                for (Client cl:clients
                        ) {
                        if(cl.getPetName().equalsIgnoreCase(name)) {
                                findClient = cl;
                                break;
                        }
                }
                return findClient;
        }

        /**
         * показывает всех клиентов поликлиники
         */
        public void Show(){
                System.out.println("-----Clients and their pets-----");
                for (Client client: clients
                     ) {
                        try {
                                System.out.println("Client: "+client.getId() + ". Pet:" + client.getPet());
                        }
                        catch (Exception ex){

                        }
                }
        }

        /**
         * удаляет клиента из списка поликлиники
         * @param client - клиент для удаления
         */
        public void RemoveClient(Client client){
                this.clients.remove(client);
        }
}
