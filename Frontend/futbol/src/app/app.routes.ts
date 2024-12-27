import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./pagina-inicial/pagina-inicial.component')

  },{
    path: 'entrenadores',
    loadComponent: () =>
      import('./entrenadores-lista/entrenadores-lista.component')

  },{
    path: 'entrenadores/nuevo',
    loadComponent: () =>
      import('./entrenador-formulario/entrenador-formulario.component')

  },{
    path: 'entrenadores/:id/actualizar',
    loadComponent: () =>
      import('./entrenador-formulario/entrenador-formulario.component')

  },
];
