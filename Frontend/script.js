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
    listarTabelaTarefas();
}

function listarTabelaTarefas() {
    limparTabelaTarefas();
    const bd_tarefas = getLocalStorage();
    let index = 0;
    for (tarefa of bd_tarefas) {
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
            <button type="button" class="btn btn-warning" id="${index}" onclick="editar(${index})">Editar</button>						
        </td>
        <td>
            <button type="button" class="btn btn-danger" id="${index}" onclick="excluir(${index})">Excluir</button>						
        </td>
    `;
        document.querySelector("#tabela>tbody").appendChild(novaLinha);
        index++;
    }
}

function limparTabelaTarefas() {
    let elemento = document.querySelector("#tabela>tbody");
    while (elemento.firstChild) {
        elemento.removeChild(elemento.firstChild);
    }
}

function getLocalStorage() {
    let listaDeTarefas = localStorage.getItem("bd_tarefas");
    let parsedLista = JSON.parse(listaDeTarefas);

    if (listaDeTarefas !== null) {
        return parsedLista
    } else {
        return [];
    }
}

function setLocalStorage(bd_tarefas) {
    localStorage.setItem("bd_tarefas", JSON.stringify(bd_tarefas));
}

listarTabelaTarefas();