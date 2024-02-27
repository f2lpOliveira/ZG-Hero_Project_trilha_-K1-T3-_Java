export class BDTodoList {

  static getLocalStorage() {
    let listaDeTarefasString = localStorage.getItem("bd_tarefas");

    if (listaDeTarefasString !== null) {
      return JSON.parse(listaDeTarefasString);
    } else {
      return [];
    }
  }

  static setLocalStorage(bdTarefas) {
    localStorage.setItem("bd_tarefas", JSON.stringify(bdTarefas));
  }
}