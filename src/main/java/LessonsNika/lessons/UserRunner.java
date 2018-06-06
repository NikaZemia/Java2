package LessonsNika.lessons;

import LessonsNika.lessons.AnimalClinic.User;

import java.util.*;

public class UserRunner {
        public static void main(String[] args) {
                List<User> users = new ArrayList<User>();
                users.add(new User("1", "first"));
                users.add(new User("2", "two"));
                users.add(new User("1", "first"));
                ShowCollection(users);

                Set<User> userSet = new HashSet<User>();
                userSet.add(new User("1", "first"));
                userSet.add(new User("2", "two"));
                userSet.add(new User("1", "first"));
                ShowCollection(userSet);

                Map<String, User> userMap = new HashMap<String, User>();
                userMap.put("1", new User("1", "first"));
                userMap.put("2", new User("2", "two"));
                userMap.put("1", new User("3", "first"));
                System.out.println("------");
                for (Map.Entry<String, User> user: userMap.entrySet()
                     ) {
                        System.out.println(user);
                }
        }

        public static void ShowCollection(Collection<User> Testusers){
                System.out.println("----------------");
                for (User user:Testusers
                        ) {
                        System.out.println(user);
                }
        }
}
