import Planes.Plane;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Deserialization {
    public static void main(String[] args) {
        ArrayList<Plane> planes = null;
        try (FileInputStream fileIn = new FileInputStream("planesList.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            planes = (ArrayList<Plane>) in.readObject();
            System.out.println("Deserialized ArrayList:");
            planes.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }
}
