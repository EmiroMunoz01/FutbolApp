import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./entrenadores-lista/entrenadores-lista.component').then(
        (m) => m.EntrenadoresListaComponent
      ),
  },
];
