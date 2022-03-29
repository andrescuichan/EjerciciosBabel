export class UserRegister{

    constructor(public usuario : string, public password : string){
        this.usuario = usuario
        this.password = password
    }

    public toString() : string {
        return `usuario: ${this.usuario}, password: ${this.password}`
    }
}