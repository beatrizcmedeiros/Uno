// Simulando a escolha aleatória de carta
function sortearCarta() {
    var cartas = ["Carta 1", "Carta 2", "Carta 3", "Carta 4", "Carta 5"];
    var cartaSorteada = cartas[Math.floor(Math.random() * cartas.length)];

    exibirCartaSelecionada(cartaSorteada);
    adicionarListaCartas(cartaSorteada);
}

// Exibir carta sorteada na div
function exibirCartaSelecionada(carta) {
    var divCartaSelecionada = document.getElementById("cartaSelecionada");
    divCartaSelecionada.innerHTML = "<p>Carta Selecionada: " + carta + "</p>";
}

// Adicionar carta à lista
function adicionarListaCartas(carta) {
    var listaCartas = document.getElementById("listaCartas");
    var li = document.createElement("li");
    li.appendChild(document.createTextNode(carta));
    listaCartas.appendChild(li);
}
