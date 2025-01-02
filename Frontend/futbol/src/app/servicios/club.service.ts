import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Club } from '../modelo/club.interface';

@Injectable({
  providedIn: 'root'
})
export class ClubService {

  private http = inject(HttpClient);



listar() {
    return this.http.get<Club[]>(
      'http://localhost:8080/app-futbol/club'
    );
  }

  obtener(id: number) {
      return this.http.get<Club>(
        `http://localhost:8080/app-futbol/club/${id}`
      );
    }

    crear(entrenador: Club) {
      return this.http.post<Club>(
        'http://localhost:8080/app-futbol/club',
        entrenador
      );
    }

    actualizar(id: number, entrenador: Club) {
      return this.http.put<Club>(
        `http://localhost:8080/app-futbol/club/${id}`,
        entrenador
      );
    }

    eliminar(id: number) {
      return this.http.delete<void>(
        `http://localhost:8080/app-futbol/club/${id}`
      );
    }

}
