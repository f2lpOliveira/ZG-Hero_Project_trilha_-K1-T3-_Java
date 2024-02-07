(function () {
    "use strict";

    let forms = document.querySelectorAll(".needs-validation");

    Array.prototype.slice.call(forms).forEach(function (form) {
        form.addEventListener("submit", function (event) {
            if (!form.checkValidity()) {
                form.classList.add("was-validated");
            } else {
                criarTarefa();
                form.classList.remove("was-validated");
                form.reset();
            }
            event.preventDefault();
            event.stopPropagation();
        }, false);
    });
})();

function criarTarefa() {
    const tarefa = {
        nome: document.getElementById("nome").value,
        descricao: document.getElementById("descricao").value,
        dataTermino: document.getElementById("dataTermino").value,
        prioridade: document.getElementById("prioridade").value,
        categoria: document.getElementById("categoria").value,
        status: document.getElementById("status").value,
    };
    const bd_tarefas = getLocalStorage();
    bd_tarefas.push(tarefa);
    setLocalStorage(bd_tarefas);
}

function getLocalStorage() {
    let listaDeTarefas = localStorage.getTarefa("bd_tarefas");
    let parsedLista = JSON.parse(listaDeTarefas);

    if (listaDeTarefas !== null) {
        return parsedLista
    } else {
        return [];
    }
}

function setLocalStorage(bd_tarefas) {
    localStorage.setTarefa("bd_tarefas", JSON.stringify(bd_tarefas));
}