import { Component, inject, OnInit } from '@angular/core';
import { EntrenadorService } from '../servicios/entrenador.service';

@Component({
  selector: 'app-entrenadores-lista',
  imports: [],
  templateUrl: './entrenadores-lista.component.html',
  styleUrl: './entrenadores-lista.component.css',
})
export default class EntrenadoresListaComponent implements OnInit {
  private entrenadorService = inject(EntrenadorService);

  ngOnInit(): void {
    this.entrenadorService.listar().subscribe((entrenadores) => {
      console.log(entrenadores);
    });
  }
}
