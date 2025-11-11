import java.util.Scanner;

import controller.PlantaController;
import repository.PlantaRepository;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlantaRepository repositorio = new PlantaRepository();
        PlantaController controller = new PlantaController(repositorio);

        int opcao;
        do {
            System.out.println("\nMenu ProjetoVida");
            System.out.println("1. Plantar");
            System.out.println("2. Listar");
            System.out.println("3. Atualizar");
            System.out.println("4. Remover");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Espécie: ");
                    String especie = sc.nextLine();
                    controller.plantar(nome, especie);
                }
                case 2 -> controller.listar();
                case 3 -> {
                    System.out.print("ID da planta: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Novo nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Nova espécie: ");
                    String especie = sc.nextLine();
                    controller.atualizar(id, nome, especie);
                }
                case 4 -> {
                    System.out.print("ID da planta: ");
                    int id = sc.nextInt();
                    controller.remover(id);
                }
                case 5 -> System.out.println("Saindo... ");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        sc.close();
    }
}
