import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./pagina-inicial/pagina-inicial.component')

  },
];
