---

# ProjetoVida 🌿

Este é um projeto Java simples focado em demonstrar a aplicação prática dos princípios de design **GRASP** (General Responsibility Assignment Software Patterns).

A aplicação funciona como um sistema básico de "CRUD" (Criar, Ler, Atualizar, Remover) para gerenciar um jardim, permitindo ao usuário adicionar, listar, atualizar e remover plantas através de um menu no console.

## 🎯 Objetivo Acadêmico

O objetivo principal deste código é aplicar e justificar o uso de padrões GRASP em uma arquitetura de software simples, separando as responsabilidades em camadas lógicas (Modelo, Repositório, Controlador).

### Padrões GRASP Aplicados

1.  **Controller (Controlador)**
    * **Onde:** `PlantaController`.
    * **Justificativa:** A classe atua como um intermediário entre a camada de apresentação (`Main`) e as camadas de lógica/dados (`PlantaRepository`). Ela recebe os eventos da interface e coordena as ações do sistema (plantar, listar, etc.), como prescrito pelo padrão.

2.  **Creator (Criador)**
    * **Onde:** `PlantaRepository`.
    * **Justificativa:** O `PlantaRepository` é o responsável por criar as instâncias de `Planta`. Ele se enquadra no padrão Creator pois:
        * Ele "contém" ou agrega os objetos `Planta` (na `List<Planta>`).
        * Ele possui a informação necessária para a criação (a lógica do `proximoId`).

3.  **High Cohesion (Alta Coesão)**
    * **Onde:** `PlantaRepository`.
    * **Justificativa:** A classe tem uma responsabilidade única e focada: gerenciar o ciclo de vida e o armazenamento das plantas (adicionar, listar, buscar, remover).

4.  **Low Coupling (Baixo Acoplamento)**
    * **Onde:** `PlantaRepository`.
    * **Justificativa:** O `PlantaController` não sabe *como* as plantas são criadas ou armazenadas (ele não sabe sobre o `proximoId` ou a `ArrayList`). Ele apenas delega ao repositório, o que mantém as classes independentes e fáceis de manter.

## 🚀 Funcionalidades

O menu principal permite:

* **1. Plantar:** Adiciona uma nova planta (nome e espécie).
* **2. Listar:** Exibe todas as plantas cadastradas.
* **3. Atualizar:** Modifica o nome e a espécie de uma planta existente, buscando-a pelo ID.
* **4. Remover:** Remove uma planta do sistema pelo ID.
* **5. Sair:** Encerra a aplicação.

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Maven**

## 🏁 Como Executar

1.  Clone o repositório.
2.  Abra o projeto em sua IDE de preferência (ex: VSCode, IntelliJ).
3.  Aguarde o Maven baixar as dependências (nenhuma é necessária além do build básico).
4.  Execute a classe `Main`.
