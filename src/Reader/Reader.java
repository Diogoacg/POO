package Reader;

import Controller.Controller;
import Modules.Gestores.Gestor;
import Modules.Utilizador.Utilizador;
import Modules.Utilizador.UtilizadorAmador;
import Modules.Utilizador.UtilizadorPraticanteOcasional;
import Modules.Utilizador.UtilizadorProfissional;

import java.util.Scanner;
import java.util.UUID;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Reader {

    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";
    private static final String OBJC = "object.obj";

    private Controller Controller;

    public Reader(Controller Controller) {
        this.Controller = Controller;
    }

    public void load(String path) {
        if (path != null) {
            if (path.contains(".txt")) {
                try {
                    Scanner text_input = new Scanner(new File(path));
                    while (text_input.hasNextLine()) {
                        this.Controller.collectDadosLine(text_input.nextLine().split(";", 0));
                    }
                    text_input.close();
                    System.out.println(Reader.YELLOW + "Ficheiro lido com sucesso" + Reader.RESET);
                } catch (Exception e) {
                    System.out.println(Reader.RED + "Não foi possivel abrir o ficheiro: " + path + Reader.RESET);
                }
            } else {
                try {
                    FileInputStream file_input = new FileInputStream(path);
                    ObjectInputStream object_input = new ObjectInputStream(file_input);
                    this.Controller.setGestor((Gestor) object_input.readObject());
                    file_input.close();
                    object_input.close();
                    System.out.println(Reader.YELLOW + "Ficheiro lido com sucesso" + Reader.RESET);
                } catch (Exception e) {
                    System.out.println(Reader.RED + "Não foi possivel ler o ficheiro" + Reader.RESET);
                }
            }
        }
    }

    // public void run() {
    // Scanner input = new Scanner(System.in);
    // while (input.hasNextLine()) {
    // System.out.printf("%s", Reader.RESET);
    // this.Controller.collectDadosLine(input.nextLine().split(";", 0));
    // System.out.printf("%s", Reader.GREEN);
    // }
    // input.close();
    // System.out.println("Bye!");
    // }

    public void save() {
        try {
            FileOutputStream file_output = new FileOutputStream(Reader.OBJC);
            ObjectOutputStream object_output = new ObjectOutputStream(file_output);
            object_output.writeObject(this.Controller.getGestor());
            file_output.close();
            object_output.close();
            System.out.println(Reader.YELLOW + "Ficheiro guardado com sucesso" + Reader.RESET);
        } catch (Exception e) {
            System.out.println(Reader.RED + "O ficheiro não foi guardado" + Reader.RESET);
        }
    }

}