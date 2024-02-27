import {BDTodoList} from "../Model/BDTodoList.js";
import {Tools} from "../Model/Tools.js";

export class Operacoes {
  static criarTarefa() {
    const tarefa = {
      nome: document.getElementById("nome").value,
      descricao: document.getElementById("descricao").value,
      dataTermino: document.getElementById("dataTermino").value,
      prioridade: document.getElementById("prioridade").value,
      categoria: document.getElementById("categoria").value,
      status: document.getElementById("status").value,
    };

    const bdTarefas = BDTodoList.getLocalStorage();
    bdTarefas.push(tarefa);
    BDTodoList.setLocalStorage(bdTarefas);
    this.listarTabelaTarefas();
  }

  static listarTabelaTarefas() {
    Tools.limparTabelaTarefas();
    const bd_tarefas = BDTodoList.getLocalStorage();
    let index =  0;
    for (const tarefa of bd_tarefas) {
      const novaLinha = document.createElement("tr");
      novaLinha.innerHTML = `
      <th scope="row">${index}</th>
      <td>${tarefa.nome}</td>
      <td>${tarefa.descricao}</td>
      <td>${tarefa.dataTermino}</td>
      <td>${tarefa.prioridade}</td>
      <td>${tarefa.categoria}</td>
      <td>${tarefa.status}</td>
      <td>
        <button type="button" class="btn btn-warning editar-tarefa" data-index="${index}">Editar</button>						
      </td>
      <td>
        <button type="button" class="btn btn-danger excluir-tarefa" data-index="${index}">Excluir</button>						
      </td>
    `;
      document.querySelector("#tabela>tbody").appendChild(novaLinha);
      index++;
    }

    document.querySelectorAll('.editar-tarefa').forEach(button => {
      button.addEventListener('click', function() {
        const index = this.getAttribute('data-index');
        Operacoes.editarTarefa(index);
      });
    });

    document.querySelectorAll('.excluir-tarefa').forEach(button => {
      button.addEventListener('click', function() {
        const index = this.getAttribute('data-index');
        Operacoes.excluirTarefa(index);
      });
    });
  }

  static editarTarefa(index) {
    const bd_tarefas = BDTodoList.getLocalStorage();
    const tarefa = bd_tarefas[index];
    document.getElementById("nome").value = tarefa.nome;
    document.getElementById("descricao").value = tarefa.descricao;
    document.getElementById("dataTermino").value = tarefa.dataTermino;
    document.getElementById("prioridade").value = tarefa.prioridade;
    document.getElementById("categoria").value = tarefa.categoria;
    document.getElementById("status").value = tarefa.status;

    bd_tarefas.splice(index, 1);
    BDTodoList.setLocalStorage(bd_tarefas);
    this.listarTabelaTarefas()
  }

  static excluirTarefa(index) {
    const bd_tarefas = BDTodoList.getLocalStorage();
    bd_tarefas.splice(index, 1);
    BDTodoList.setLocalStorage(bd_tarefas);
    this.listarTabelaTarefas()
  }
}