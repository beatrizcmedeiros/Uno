function sortearCarta() {
    var descricaoCarta = Android.getDescricaoCartaAleatoria();
    // Faça algo com a descrição da carta sorteada
    alert(descricaoCarta);
}

 function abrirLista() {
    // Chame a função da interface JavaScript para abrir a lista
    Android.abrirLista();
}

function exibirCartasSorteadas() {
    // Chame a função da interface JavaScript para obter as cartas sorteadas
    var cartasSorteadas = JSON.parse(Android.obterCartasSorteadas());
    // Agora você pode usar as informações das cartas no JavaScript
    // por exemplo, para exibir as cartas em uma lista
}
