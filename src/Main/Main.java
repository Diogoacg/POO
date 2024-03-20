package Main;

import Controller.Controller;
import Modules.Menu;
import Modules.Gestores.*;
import Reader.Reader;

public class Main {

    public static void main(String[] args) throws Exception {

        Gestor gestor = new Gestor();
        Controller Controller = new Controller(gestor);
        Reader leitor = new Reader(Controller);
        Menu menu = new Menu(Controller);

        // if (args.length == 0)
        // leitor.load(null);

        // else
        // leitor.load(args[0]);

        menu.Run();
        leitor.save();
    }
}
