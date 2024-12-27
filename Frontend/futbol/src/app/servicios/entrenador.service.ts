import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Entrenador } from '../modelo/entrenador.interface';

@Injectable({
  providedIn: 'root',
})
export class EntrenadorService {
  //aqui inyectaremos el cliente http
  private http = inject(HttpClient);

  //crearemos las funciones
  listar() {
    return this.http.get<Entrenador[]>('http://localhost:8080/app-futbol/entrenador');
  }

  obtener(id: number) {
    return this.http.get<Entrenador>(`http://localhost:8080/app-futbol/entrenador/${id}`);
  }

  crear(entrenador: any) {
    return this.http.post<Entrenador>(
      'http://localhost:8080/app-futbol/entrenador',
      entrenador
    );
  }


  actualizar(id: number,entrenador: any) {
    return this.http.put<Entrenador>(`http://localhost:8080/app-futbol/entrenador/${id}`, entrenador);
  }

  eliminar(id: number) {
    return this.http.delete<void>(
      `http://localhost:8080/app-futbol/entrenador/${id}`
    );
  }
}
