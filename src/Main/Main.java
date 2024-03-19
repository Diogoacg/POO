package Main;

import Modules.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        while (true) {
            menu.exibirMenuPrincipal();
            int opcao = menu.obterOpcao();
            menu.processarOpcao(opcao);
        }
    }
}
