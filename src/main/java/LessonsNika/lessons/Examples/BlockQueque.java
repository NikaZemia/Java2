package LessonsNika.lessons.Examples;

import java.util.*;

public class BlockQueque<T> {

        public final LinkedList<T> queque = new LinkedList<T>();

        public void push(final T t){
                synchronized (this.queque){
                        this.queque.add(t);
                        this.queque.notifyAll();
                }
        }

        public T poll(){
                synchronized (this.queque){
                        while (this.queque.isEmpty()){
                                try {
                                        this.queque.wait();
                                }
                                catch (InterruptedException e){
                                        e.printStackTrace();
                                }
                        }
                        return this.queque.remove();
                }
        }
}
