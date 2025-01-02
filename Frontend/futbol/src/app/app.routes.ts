import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () => import('./pagina-inicial/pagina-inicial.component'),
  },
  {
    path: 'entrenadores',
    loadComponent: () =>
      import('./entrenadores-lista/entrenadores-lista.component'),
  },
  {
    path: 'entrenadores/nuevo',
    loadComponent: () =>
      import('./entrenador-formulario/entrenador-formulario.component'),
  },
  {
    path: 'entrenadores/:id/actualizar',
    loadComponent: () =>
      import('./entrenador-formulario/entrenador-formulario.component'),
  },

  {
    path: 'clubes',
    loadComponent: () => import('./club-lista/club-lista.component'),
  },
  {
    path: 'clubes/nuevo',
    loadComponent: () => import('./club-formulario/club-formulario.component'),
  },
  {
    path: 'clubes/:id/actualizar',
    loadComponent: () => import('./club-formulario/club-formulario.component'),
  },

  {
    path: 'jugadores',
    loadComponent: () => import('./jugadores-lista/jugadores-lista.component'),
  },
  {
    path: 'jugadores/nuevo',
    loadComponent: () =>
      import('./jugador-formulario/jugador-formulario.component'),
  },
  {
    path: 'jugadores/:id/actualizar',
    loadComponent: () =>
      import('./jugador-formulario/jugador-formulario.component'),
  },
];
