package Main;

import Controller.Controller;

public class Main {
    public static void main(String[] args) {
        // Cria uma instância do controlador
        Controller controller = new Controller();

        controller.criarUtilizador("U001", "João", "Rua 1", "123@gmail.com", 70, "C"); // Cria um utilizador

        // Adicione atletas, atividades, planos de treino, etc. usando os métodos do
        // controlador

        // Execute a lógica principal do seu programa
    }
}
