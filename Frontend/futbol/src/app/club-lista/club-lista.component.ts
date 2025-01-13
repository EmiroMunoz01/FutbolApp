import { Component, inject, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ClubService } from '../servicios/club.service';
import { Club } from '../modelo/club.interface';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-club-lista',
  imports: [RouterModule, DatePipe],
  templateUrl: './club-lista.component.html',
  styleUrl: './club-lista.component.css',
})
export default class ClubListaComponent implements OnInit {
  private clubService = inject(ClubService);

  clubesArray: Club[] = [];

  ngOnInit(): void {
    this.cargarTodo();
  }

  cargarTodo() {
    this.clubService.listar().subscribe((clubes) => {
      this.clubesArray = clubes;
    });
  }

  eliminarClub(club: Club) {
    this.clubService.eliminar(club.id).subscribe(() => {
      this.cargarTodo();
    });
  }


}
