package controller;

import model.Planta;
import repository.PlantaRepository;

/**
 * Aplica GRASP:
 * - Controller: gerencia o fluxo do sistema (plantar, listar, remover, etc.)
 * - Creator: delega a criação da planta ao repositório (que tem as informações necessárias)
 */
public class PlantaController {

    private PlantaRepository repositorio;

    public PlantaController(PlantaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void plantar(String nome, String especie) {
        // Agora não recebemos ID — o repositório gera automaticamente
        repositorio.adicionar(nome, especie);
    }

    public void listar() {
        System.out.println("\n🌿 Jardim Atual 🌿");
        if (repositorio.listar().isEmpty()) {
            System.out.println("Nenhuma planta cadastrada!");
        } else {
            for (Planta p : repositorio.listar()) {
                System.out.println(p);
            }
        }
    }

    public void atualizar(int id, String novoNome, String novaEspecie) {
        Planta p = repositorio.buscarPorId(id);
        if (p != null) {
            p.setNome(novoNome);
            p.setEspecie(novaEspecie);
            System.out.println("🔄 Planta atualizada!");
        } else {
            System.out.println("❌ Planta não encontrada!");
        }
    }

    public void remover(int id) {
        boolean removido = repositorio.remover(id);
        if (removido) {
            System.out.println("🪓 Planta removida com sucesso!");
        } else {
            System.out.println("❌ Planta não encontrada!");
        }
    }
}
