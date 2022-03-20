class Jugador {
    constructor(...args) {
        if (args.length === 0) {
            return;
        }
        if (args.length === 4) {
            this._id = args[0];
            this._nombre = args[1];
            this._edad = args[2];
            this._pais = args[3];
            return;
        }
        throw new Error('Undefined constructor.');
    }
    get id() {
        return this._id;
    }
    set id(value) {
        this._id = value;
    }
    get nombre() {
        return this._nombre;
    }
    set nombre(value) {
        this._nombre = value;
    }
    get edad() {
        return this._edad;
    }
    set edad(value) {
        this._edad = value;
    }
    get pais() {
        return this._pais;
    }
    set pais(value) {
        this._pais = value;
    }
    jugador_string() {
        return `Jugador = id: ${this._id}, nombre: ${this._nombre}, edad: ${this._edad}, pais: ${this._pais}`;
    }
}
class Historial extends Jugador {
    constructor(numero_goles, tarjetas_amarrilas, tarjetas_rojas) {
        super();
        this._numero_goles = numero_goles;
        this._tarjetas_amarrilas = tarjetas_amarrilas;
        this._tarjetas_rojas = tarjetas_rojas;
    }
    get id() {
        return this._id;
    }
    set id(value) {
        this._id = value;
    }
    get numero_goles() {
        return this._numero_goles;
    }
    set numero_goles(value) {
        this._numero_goles = value;
    }
    get tarjetas_amarrilas() {
        return this._tarjetas_amarrilas;
    }
    set tarjetas_amarrilas(value) {
        this._tarjetas_amarrilas = value;
    }
    get tarjetas_rojas() {
        return this._tarjetas_rojas;
    }
    set tarjetas_rojas(value) {
        this._tarjetas_rojas = value;
    }
    jugador_string() {
        return super.jugador_string() +
            `\nHistorial = numero goles: ${this._numero_goles}, tarjetas amarrilas: ${this._tarjetas_amarrilas}, tarjetas rojas: ${this._tarjetas_rojas}`;
    }
}
class Equipo {
    constructor(id, nombreTeam, fechaFundacion) {
        this._team = [];
        this._id = id;
        this._nombreTeam = nombreTeam;
        this._fechaFundacion = fechaFundacion;
    }
    get id() {
        return this._id;
    }
    set id(value) {
        this._id = value;
    }
    get nombreTeam() {
        return this._nombreTeam;
    }
    set nombreTeam(value) {
        this._nombreTeam = value;
    }
    get fechaFundacion() {
        return this._fechaFundacion;
    }
    set fechaFundacion(value) {
        this._fechaFundacion = value;
    }
    get team() {
        return this._team;
    }
    add_jugadores(player) {
        this._team.push(player);
    }
    equipo_string() {
        return `Equipo = nombre: ${this._nombreTeam}, fecha: ${this._fechaFundacion}, id equipo: ${this._id}`;
    }
}
let equipo_internacional = new Equipo(1500, "Fnatic", "24/06/1997");
let historial1 = new Historial(25, 9, 2);
let jugador1 = new Jugador();
jugador1 = historial1;
jugador1.id = 100;
jugador1.nombre = "Casillas";
jugador1.edad = 45;
jugador1.pais = "Spain ole ole";
let historial2 = new Historial(7, 2, 0);
let jugador2 = new Jugador();
jugador2 = historial2;
jugador2.id = 101;
jugador2.nombre = "Faker";
jugador2.edad = 25;
jugador2.pais = "Korea la buena";
let historial3 = new Historial(65, 24, 9);
let jugador3 = new Jugador();
jugador3 = historial3;
jugador3.id = 102;
jugador3.nombre = "Roberto Carlos";
jugador3.edad = 64;
jugador3.pais = "Brasil samba";
equipo_internacional.add_jugadores(jugador1);
equipo_internacional.add_jugadores(jugador2);
equipo_internacional.add_jugadores(jugador3);
console.log("\n" + equipo_internacional.equipo_string());
for (let player of equipo_internacional.team) {
    console.log("\n" + player.jugador_string());
}
