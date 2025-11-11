package repository;

import java.util.ArrayList;
import java.util.List;

import model.Planta;

/**
 * Repositório responsável pelo armazenamento e gerenciamento das Plantas.
 *
 * Aplica os seguintes padrões GRASP:
 *
 * 1. **Creator (Criador):** Esta classe é a criadora de objetos 'Planta',
 * pois ela agrega (contém) a lista de plantas e possui a informação
 * necessária para inicializá-las (a lógica de auto-incremento do 'proximoId').
 *
 * 2. **High Cohesion (Alta Coesão):** A classe tem uma responsabilidade única
 * e focada: gerenciar o ciclo de vida e o armazenamento das plantas (adicionar,
 * listar, buscar, remover).
 *
 * 3. **Low Coupling (Baixo Acoplamento):** O Controller (PlantaController)
 * depende desta classe, mas não conhece os detalhes da implementação
 * de armazenamento (como a 'ArrayList' ou a forma como o ID é gerado).
 */
public class PlantaRepository {
    private List<Planta> jardim = new ArrayList<>();
    private int proximoId = 1; // contador automático de IDs

    public void adicionar(String nome, String especie) {
        Planta nova = new Planta(proximoId++, nome, especie);
        jardim.add(nova);
        System.out.println("Planta adicionada: " + nova);
    }

    public List<Planta> listar() {
        return jardim;
    }

    public Planta buscarPorId(int id) {
        for (Planta p : jardim) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean remover(int id) {
        Planta p = buscarPorId(id);
        if (p != null) {
            jardim.remove(p);
            return true;
        }
        return false;
    }
}
