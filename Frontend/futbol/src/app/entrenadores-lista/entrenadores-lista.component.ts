import { Component, inject, OnInit } from '@angular/core';
import { EntrenadorService } from '../servicios/entrenador.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-entrenadores-lista',
  imports: [DatePipe],
  templateUrl: './entrenadores-lista.component.html',
  styleUrl: './entrenadores-lista.component.css',
})
export default class EntrenadoresListaComponent implements OnInit {
  private entrenadorService = inject(EntrenadorService);

  entrenadoresArray:any = [];

  ngOnInit(): void {
    this.entrenadorService.listar().subscribe((entrenadores: any) => {
      this.entrenadoresArray = entrenadores;
    });
  }
}
