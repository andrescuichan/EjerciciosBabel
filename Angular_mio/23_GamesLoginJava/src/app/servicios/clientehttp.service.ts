import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientehttpService {

  readonly endPoint = 'http://localhost:8080/22_WebMenu'

  constructor(private _httpClient : HttpClient) { 
    
  }

  public validacion(nombre : String, password : String): Observable<any> {
 
    let url: String = `${this.endPoint}/usuarios/login?nombre=${nombre}&password=${password}`
    return this._httpClient.get(`${this.endPoint}/usuarios/login?nombre=${nombre}&password=${password}`)
             .pipe(catchError(this.manejarError))
  }  
 
  private manejarError(e: HttpErrorResponse){
    let mensajeError = ''
    if (e.error instanceof ErrorEvent) {
      mensajeError = 'A ocurrido un error:' + e.error
    } else {
      mensajeError = `El servicio Rest retorno: Status: ${e.status}, ` +
            `Body: ${e.error}`
    }
    console.error(mensajeError)
    return throwError(() => new Error(mensajeError));
  }

}
