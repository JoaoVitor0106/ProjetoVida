package repository;

import java.util.ArrayList;
import java.util.List;

import model.Planta;

/**
 * Repositório responsável pelo armazenamento das plantas.
 * 
 * Aplica GRASP: High Cohesion (cada classe faz apenas seu papel)
 * e Low Coupling (controller não precisa saber como IDs são gerados).
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
