// script.js
function exibirCartaSorteada(imagemResId) {
    var imgElement = document.getElementById("carta-img");
    imgElement.src = "file:///android_res/drawable/" + imagemResId;
}

function listarCartas() {
    Android.listarCartasSorteadas();
}