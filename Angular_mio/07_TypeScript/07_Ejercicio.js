var notas_asignatura = [6, 3, 4, 5, 6];
console.log("--------------Apartado 1--------------\n");
console.log("(55%) nota de las 3 calificaciones de parciales: " + notas_asignatura[0] + ", " + notas_asignatura[1] + ", " +
    notas_asignatura[2]);
console.log("(30%) nota del examen final: " + notas_asignatura[3]);
console.log("(15%) nota del trabajo final: " + notas_asignatura[4]);
function nota_final(notas) {
    let resultado;
    resultado = ((notas[0] + notas[1] + notas[2]) / 3) * 0.55;
    resultado += notas[3] * 0.3;
    resultado += notas[4] * 0.15;
    return resultado;
}
console.log("Nota final: " + nota_final(notas_asignatura) + " \nNos vemos en Septiembre ");
console.log("\n--------------Apartado 2--------------\n");
var videojuegos = ["La comunidad del anillo", "mario kart", "El retorno del rey", "Las dos torres", "LOL", "Super mario bros"];
console.log("Videojuegos con mario: " + videojuegos);
function eliminar_mario(games) {
    let videojuegosSinMario = [];
    for (let juego of games) {
        if (juego.indexOf('mario') == -1) {
            videojuegosSinMario.push(juego);
        }
    }
    return videojuegosSinMario;
}
console.log("Videojuegos sin mario: " + eliminar_mario(videojuegos));
console.log("\n--------------Apartado 3--------------\n");
function operacion_factorial(numeroFactorial) {
    let resultado = 1;
    for (let i = 1; i <= numeroFactorial; i++) {
        resultado *= i;
    }
    return resultado;
}
console.log("El factorial de 4! es: " + operacion_factorial(4));
console.log("El factorial de 6! es: " + operacion_factorial(6));
console.log("El factorial de 10! es: " + operacion_factorial(10));
