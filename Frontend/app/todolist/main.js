import { Tools } from "./Model/Tools.js";
import { Operacoes } from "./Controller/Operacoes.js";


document.addEventListener('DOMContentLoaded', function() {
  Tools.validacaoFormulario();
});

document.getElementById('form').addEventListener('submit', function(event) {
  event.preventDefault();

  Operacoes.criarTarefa();
});