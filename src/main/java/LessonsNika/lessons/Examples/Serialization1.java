package LessonsNika.lessons.Examples;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.*;
import java.io.Serializable;
import java.io.Externalizable;

public class Serialization1 {

        static final String PACKAGE = DataObject.class.getPackage().getName();

        public static void main(String[] args) {
                DataObject obj = new DataObject();
                obj.setMyData("123456789zxcvbnmasdfghj123456789zxcvbnmasdfghj123456789zxcvbnmasdfghj");
                File file = new File("store2.bin");

/*                try {
                        //write to file
                        FileOutputStream fo = new FileOutputStream(file);
                        ObjectOutputStream so = new ObjectOutputStream(fo);
                        so.writeObject(obj);
                        so.flush();
                        so.close();

                        //read from file
                        FileInputStream fi = new FileInputStream(file);
                        ObjectInputStream si = new ObjectInputStream(fi);
                        DataObject objNew = (DataObject) si.readObject();
                        si.close();
                        System.out.println(objNew.getMyData());

                }
                catch (FileNotFoundException ex){
                        ex.printStackTrace();
                }
                catch (ClassNotFoundException exc){
                        exc.printStackTrace();
                }
                catch (IOException exx){
                        exx.printStackTrace();
                }*/

                /*
                JAXB контекст
                 */
                /*try {
                        JAXBContext jc = JAXBContext.newInstance(PACKAGE);
                        Marshaller m = jc.createMarshaller();//записывает
                        Unmarshaller um = jc.createUnmarshaller();//считывает

                        m.marshal(obj, file);
                        DataObject objj = (DataObject) um.unmarshal(file);
                        System.out.println(objj.getMyData());
                }
                catch (JAXBException ex){
                        ex.printStackTrace();
                }*/

                /*
                JSON контекст
                 */
                Gson gson = new Gson();
                String json = gson.toJson(obj);
                System.out.println(json);
                Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
                String jsonPretty = gsonPretty.toJson(obj);
                System.out.println(jsonPretty);
                DataObject obg = gson.fromJson(json, DataObject.class);
                System.out.println(obg.getMyData());
        }
}

/* описание @XmlAccessorType()
NONE - сохраняет только элементы, отмеченные аннотацией
FIELD - сохраняет все нестатические и не-transient поля
PROPERTY - сохраняет все геттер/сеттер пары и поля, отмеченные аннотацией
PUBLIC - сохраняет все публичные геттер/сеттер пары и поля, а так же те, что отмеченые аннотацией
 */
@XmlRootElement //под этим тегом все будет находиться
@XmlAccessorType(XmlAccessType.NONE) //тип доступа. не учитывает никакие геттеры и сеттеры
@XmlType //тип, который будет сериализироваться в XML
class DataObject extends NonSerializable implements Serializable{
        //@XmlElement //можно над полем/геттером/сеттером, помечает те элементы,
        //которые хотим сохранить. тег будет такой как название элемента
        private int i = 5;
        @XmlElement(required = true, name="s")
        private String s = "aaa";
        @XmlAttribute //в атрибут попадет само значение элемента
        private int id = 10;
        private transient String[] def = {"111", "222", "333"};
        @XmlElement
        private CustomObject sd;

        private void writeObject(ObjectOutputStream out) throws IOException{
                out.defaultWriteObject();//записывает сериализацию по стандарту

                //в данном примере мы сериализуем данные класса-родителя,
                //который не является сериализуемым в отличии от наследника
                out.writeObject(getMyData());
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
                in.defaultReadObject();//считывает сериализацию по стандарту

                //считываем сериализованные данные от класса-родителя,
                //который не наследовался от сериалайзебл в отличии от наследника
                String st = (String)in.readObject();
                setMyData(st);
        }
}

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
class CustomObject {
        private transient boolean b;

        public CustomObject(boolean b){
                this.b = b;
        }

        /*public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException{
                in.readBoolean();
        }

        public void writeExternal(ObjectOutput out) throws IOException{
                out.writeBoolean(b);
        }*/
}

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
class NonSerializable{
        private String myData = "";

        public String getMyData() {
                return myData;
        }

        public void setMyData(String myData) {
                this.myData = myData;
        }
}

@XmlRegistry
class ObjectFactory{
        private final static QName Q_NAME = new QName(
                XMLConstants.NULL_NS_URI, "data");

        @XmlElementDecl(name="dataObj")
        public JAXBElement<DataObject> createData(DataObject value){
                return new JAXBElement<DataObject>(
                        Q_NAME, DataObject.class, null, value);
        }
}
