import {Operacoes} from "../Controller/Operacoes.js";

export class Tools {
  static limparTabelaTarefas() {
    let elemento = document.querySelector("#tabela>tbody");
    while (elemento.firstChild) {
      elemento.removeChild(elemento.firstChild);
    }
  }

  static validacaoFormulario() {
    let forms = document.querySelectorAll(".needs-validation");

    Array.prototype.slice.call(forms).forEach(function (form) {
      form.addEventListener("submit", function (event) {
        if (!form.checkValidity()) {
          form.classList.add("was-validated");
        } else {
          Operacoes.criarTarefa();
          form.classList.remove("was-validated");
          form.reset();
        }
        event.preventDefault();
        event.stopPropagation();
      }, false);
    });
  }
}