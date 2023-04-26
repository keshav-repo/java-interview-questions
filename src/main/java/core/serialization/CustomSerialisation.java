package core.serialization;

import java.io.*;

public class CustomSerialisation {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Account account = new Account("user 1", "password");

        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(account);

        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Account recovered = (Account) ois.readObject();
        System.out.println(recovered.toString());
    }
}
