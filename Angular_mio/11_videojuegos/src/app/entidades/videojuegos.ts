
export class Videojuegos{

    private _id : number = 0;
    private static contadorId : number = 1;

    constructor(public titulo : string, public empresa : string, public media : number){
        this._id = Videojuegos.contadorId++;
        this.titulo = titulo
        this.empresa = empresa
        this.media = media
    }

    public get id() : number{
        return this._id;
    }

    public toString() : string {
        return `ID: ${this._id}, titulo: ${this.titulo}, empresa: ${this.empresa}, media: ${this.media} `
    }

}