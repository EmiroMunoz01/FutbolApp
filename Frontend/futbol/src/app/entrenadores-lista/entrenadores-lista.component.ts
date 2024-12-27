import { Component, inject, OnInit } from '@angular/core';
import { EntrenadorService } from '../servicios/entrenador.service';
import { DatePipe } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Entrenador } from '../modelo/entrenador.interface';

@Component({
  selector: 'app-entrenadores-lista',
  imports: [DatePipe, RouterModule],
  templateUrl: './entrenadores-lista.component.html',
  styleUrl: './entrenadores-lista.component.css',
})
export default class EntrenadoresListaComponent implements OnInit {
  private entrenadorService = inject(EntrenadorService);

  entrenadoresArray: Entrenador[] = [];

  ngOnInit(): void {
    this.entrenadorService.listar()
    .subscribe(entrenadores => {
      this.entrenadoresArray = entrenadores;
    });
  }
}
