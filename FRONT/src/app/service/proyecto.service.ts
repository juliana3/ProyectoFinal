import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Proyecto } from '../model/proyecto';

@Injectable({
  providedIn: 'root'
})
export class ProyectoService {
  URL = 'https://back-ja.herokuapp.com/proyectos/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Proyecto[]>{
    return this.httpClient.get<Proyecto[]>(this.URL + 'lista');
  }

  public detail(id: number): Observable<Proyecto>{
    return this.httpClient.get<Proyecto>(this.URL + `detail/${id}`);
  }

  public save(proye: Proyecto): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'create', proye);
  }

  public update(id: number, proye: Proyecto): Observable<any>{
    return this.httpClient.put<any>(this.URL + `update/${id}`, proye);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + `delete/${id}`);
  }
}
