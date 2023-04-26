package core.serialization;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class Account implements Serializable {
    private String username;
    private transient String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("username: %s, password: %s", username, password);
    }

    private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
        System.out.println("Custom deserialization");
        stream.defaultReadObject();
        String encryptedPassword = (String) stream.readObject();
        password = encryptedPassword.substring(3);
    }

    private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
        System.out.println("Custom serialization");
        stream.defaultWriteObject();
        String encryptedPassword = "enc".concat(password);
        stream.writeObject(encryptedPassword);
    }

    private void readObjectNoData() throws ObjectStreamException {
        System.out.println("custom readObjectNoData");
    }
}
