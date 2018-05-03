package LessonsNika.lessons;

public class Clinic {
        private final Client[] clients;

        public Clinic(final int size){
                this.clients = new Client[size];
        }

        /**
         * add client
         */
        public void addClient(final int position, final Client client){
                this.clients[position] = client;
        }

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

        public void Show(){
                for (int i = 0; i<=clients.length; i++){
                        try {
                                System.out.println(i+". Client: "+clients[i].getId() + ". Pet:" + clients[i].getPet());
                        }
                        catch (Exception ex){

                        }
                }
        }
}
