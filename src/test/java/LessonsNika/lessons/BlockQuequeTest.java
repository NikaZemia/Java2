package LessonsNika.lessons;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

public class BlockQuequeTest {

        @Test
        public void queque() throws InterruptedException{
                final BlockQueque<User> queque = new BlockQueque<User>();
                final List<Customer> customers = Arrays.asList(
                        new Customer(queque), new Customer(queque)
                );

                for (Customer customer : customers){
                        customer.start();
                }

                Producer producer = new Producer(
                        queque, Arrays.asList(
                                new User("1", "1"),new User("2", "2"),
                                new User("3", "3"),new User("4", "4")
                        )
                );
                producer.start();
                producer.join();
                Thread.sleep(101);
                int count = 0;
                for(Customer customer : customers){
                        count += customer.size();
                }
                assertEquals(count, producer.size());
        }

        private  static final class Producer extends Thread{
                private final BlockQueque<User> queque;
                private final List<User> store;

                public Producer(final BlockQueque<User> queque, final
                                List<User> store){
                        super();
                        this.queque = queque;
                        this.store = store;
                }

                @Override
                public void run() {
                        for(User user : this.store){
                                this.queque.push(user);
                        }
                }

                public  int size(){
                        return this.store.size();
                }
        }

        public static final class Customer extends Thread{
                private final BlockQueque<User> queque;
                private final AtomicInteger counter = new AtomicInteger(0);

                public Customer(final BlockQueque<User> queque){
                        super();
                        this.queque = queque;
                }

                @Override
                public void run() {
                        while (true){
                                System.out.println(String.format(
                                        "%s : %s", Thread.currentThread().getId(), this.queque.poll()
                                ));
                                counter.incrementAndGet();
                        }
                }

                public int size(){
                        return this.counter.get();
                }
        }

        /*@Test
        public void push() {
        }

        @Test
        public void poll() {
        }*/
}