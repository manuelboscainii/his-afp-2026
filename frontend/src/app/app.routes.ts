import { Routes } from '@angular/router';
import { MainLayout } from './layout/main-layout/main-layout';
import { RisLayout } from './layout/ris-layout/ris-layout';
import { StatoServiziSio } from './features/stato-sio/stato-servizi-sio/stato-servizi-sio';
import { RoutingError } from './ui/errors/routing-error/routing-error';

// /ris
export const routes: Routes = [
  {
    path: '',
    component: MainLayout,
    children: [
      {
        path: '',
        redirectTo: 'lista-pz',
        pathMatch: 'full',
      },
      {
        path: 'lista-pz',
        loadComponent: () =>
          import('./features/lista-pz/lista-pz').then((m) => m.ListaPz),
      },
      {
        path: 'accettazione',
        loadComponent: () =>
          import('./features/accettazione/accettazione').then((m) => m.Accettazione),
      },
      {
        path: 'stato-servizi-sio',
        providers: [StatoServiziSio],
        loadComponent: () =>
          import('./features/stato-sio/stato-sio').then((m) => m.StatoSio),
        errorComponent: RoutingError
      },
    ],
  },
  {
    path: 'ris',
    component: RisLayout,
  },
  {
    path: '**',
    redirectTo: 'lista-pz',
    pathMatch: 'full'
  }
];
