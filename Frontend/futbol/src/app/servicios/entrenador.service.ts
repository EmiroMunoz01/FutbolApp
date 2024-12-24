import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class EntrenadorService {
  //aqui inyectaremos el cliente http
  private http = inject(HttpClient);

  //crearemos las funciones
  listar() {
    return this.http.get('http://localhost:8080/app-futbol/entrenador');
  }

  obtener(id: number) {
    return this.http.get(`http://localhost:8080/app-futbol/entrenador/${id}`);
  }

  crear(entrenador: any) {
    return this.http.post(
      'http://localhost:8080/app-futbol/entrenador',
      entrenador
    );
  }

  actualizar(id: number) {
    return this.http.delete(
      `http://localhost:8080/app-futbol/entrenador/${id}`
    );
  }
}
