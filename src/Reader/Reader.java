package Reader;

import Controller.Controller;
import Modules.Gestores.Gestor;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Reader {

    private static final String RED = "\u001B[31m";
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
        // se nao for passado nenhum ficheiro, le o ficheiro object.obj
        else {
            try {
                FileInputStream file_input = new FileInputStream(Reader.OBJC);
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

    public void save() {
        try {
            System.out.println(Reader.YELLOW + "Iniciando o processo de gravação..." + Reader.RESET);

            FileOutputStream file_output = new FileOutputStream(Reader.OBJC);
            System.out.println(Reader.YELLOW + "FileOutputStream criado com sucesso." + Reader.RESET);

            ObjectOutputStream object_output = new ObjectOutputStream(file_output);
            System.out.println(Reader.YELLOW + "ObjectOutputStream criado com sucesso." + Reader.RESET);

            object_output.writeObject(this.Controller.getGestor());
            System.out.println(Reader.YELLOW + "Objeto escrito com sucesso." + Reader.RESET);

            file_output.close();
            object_output.close();
            System.out.println(Reader.YELLOW + "Streams fechados com sucesso." + Reader.RESET);

            System.out.println(Reader.YELLOW + "Ficheiro guardado com sucesso" + Reader.RESET);
        } catch (Exception e) {
            System.out.println(Reader.RED + "Ocorreu um erro: " + e.getMessage() + Reader.RESET);
            e.printStackTrace();
        }
    }

}