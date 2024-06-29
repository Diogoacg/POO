package Main;

import Controller.Controller;
import Modules.Menu;
import Modules.Gestores.*;
import Reader.Reader;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        Gestor gestor = new Gestor();
        Controller Controller = new Controller(gestor);
        Reader leitor = new Reader(Controller);
        Menu menu = new Menu(Controller);

        File objFile = new File("object.obj");

        if (!objFile.exists()) {

            leitor.load("src/ficheiros/dados.txt");
        } else {
            leitor.load(null);
        }

        menu.Run();
        leitor.save();

    }
}