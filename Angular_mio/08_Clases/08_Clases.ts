class Jugador {

    protected _id: number;
    protected _nombre: string;
    protected _edad: number;
    protected _pais: string;
    
    public constructor()
    public constructor(id: number, nombre: string, edad: number, pais: string)
    public constructor(...args: any[]) {
        if (args.length === 0) {
            return;
        }
        if (args.length === 4){
            
            this._id = args[0]
            this._nombre = args[1]
            this._edad = args[2]
            this._pais = args[3]
            return;
        }
        throw new Error('Undefined constructor.');
    }

    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get nombre(): string {
        return this._nombre;
    }
    public set nombre(value: string) {
        this._nombre = value;
    }
    public get edad(): number {
        return this._edad;
    }
    public set edad(value: number) {
        this._edad = value;
    }
    public get pais(): string {
        return this._pais;
    }
    public set pais(value: string) {
        this._pais = value;
    }

    public jugador_string(): string{
       return `Jugador = id: ${this._id}, nombre: ${this._nombre}, edad: ${this._edad}, pais: ${this._pais}`;
    }

}

class Historial extends Jugador{
    
    private _numero_goles: number;
    private _tarjetas_amarrilas: number;
    private _tarjetas_rojas: number;

    constructor(numero_goles: number, tarjetas_amarrilas: number, tarjetas_rojas: number){
        super()
        this._numero_goles = numero_goles;
        this._tarjetas_amarrilas = tarjetas_amarrilas;
        this._tarjetas_rojas = tarjetas_rojas;
    }

    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get numero_goles(): number {
        return this._numero_goles;
    }
    public set numero_goles(value: number) {
        this._numero_goles = value;
    }
    public get tarjetas_amarrilas(): number {
        return this._tarjetas_amarrilas;
    }
    public set tarjetas_amarrilas(value: number) {
        this._tarjetas_amarrilas = value;
    }
    public get tarjetas_rojas(): number {
        return this._tarjetas_rojas;
    }
    public set tarjetas_rojas(value: number) {
        this._tarjetas_rojas = value;
    }

    public jugador_string(): string{
        
        return super.jugador_string() +
        `\nHistorial = numero goles: ${this._numero_goles}, tarjetas amarrilas: ${this._tarjetas_amarrilas}, tarjetas rojas: ${this._tarjetas_rojas}`;
     }

}

class Equipo {

    private _id: number;
    private _nombreTeam: string;
    private _fechaFundacion: string;
    private _team : Jugador[] = []
    
    constructor(id: number, nombreTeam: string, fechaFundacion: string){
        this._id = id
        this._nombreTeam = nombreTeam
        this._fechaFundacion = fechaFundacion
    }

    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get nombreTeam(): string {
        return this._nombreTeam;
    }
    public set nombreTeam(value: string) {
        this._nombreTeam = value;
    }
    public get fechaFundacion(): string {
        return this._fechaFundacion;
    }
    public set fechaFundacion(value: string) {
        this._fechaFundacion = value;
    }
    public get team(): Jugador[] {
        return this._team;
    }

    public add_jugadores(player: Jugador){
        this._team.push(player)
    }

    public equipo_string(): string{
        return `Equipo = nombre: ${this._nombreTeam}, fecha: ${this._fechaFundacion}, id equipo: ${this._id}`;
    }
}


let equipo_internacional : Equipo = new Equipo(1500, "Fnatic", "24/06/1997")

let historial1 : Historial = new Historial(25, 9, 2)
let jugador1 : Jugador = new Jugador()
jugador1 = historial1
jugador1.id = 100
jugador1.nombre = "Casillas"
jugador1.edad = 45
jugador1.pais = "Spain ole ole"

let historial2 : Historial = new Historial(7, 2, 0)
let jugador2 : Jugador = new Jugador()
jugador2 = historial2
jugador2.id = 101
jugador2.nombre = "Faker"
jugador2.edad = 25
jugador2.pais = "Korea la buena"

let historial3 : Historial = new Historial(65, 24, 9)
let jugador3 : Jugador = new Jugador()
jugador3 = historial3
jugador3.id = 102
jugador3.nombre = "Roberto Carlos"
jugador3.edad = 64
jugador3.pais = "Brasil samba"

equipo_internacional.add_jugadores(jugador1)
equipo_internacional.add_jugadores(jugador2)
equipo_internacional.add_jugadores(jugador3)

console.log("\n" + equipo_internacional.equipo_string())
for(let player of equipo_internacional.team){
    console.log("\n" + player.jugador_string())
}