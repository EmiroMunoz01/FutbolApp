import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Club } from '../modelo/club.interface';
import { Entrenador } from '../modelo/entrenador.interface';

@Injectable({
  providedIn: 'root',
})
export class ClubService {
  private http = inject(HttpClient);

  listar() {
    return this.http.get<Club[]>('http://localhost:8080/app-futbol/club');
  }


  obtener(id: number) {
    return this.http.get<Club>(`http://localhost:8080/app-futbol/club/${id}`);
  }

  crear(club: Club) {
    return this.http.post<Club>(
      'http://localhost:8080/app-futbol/club',
      club
    );
  }

  actualizar(id: number, club: Club) {
    return this.http.put<Club>(
      `http://localhost:8080/app-futbol/club/${id}`,
      club
    );
  }

  eliminar(id: number) {
    return this.http.delete<void>(
      `http://localhost:8080/app-futbol/club/${id}`
    );
  }
}
