import { Routes } from '@angular/router';
import { ListaPz } from './features/lista-pz/lista-pz';
import { Accettazione } from './features/accettazione/accettazione';
import { StatoSio } from './features/stato-sio/stato-sio';
import { MainLayout } from './layout/main-layout/main-layout';
import { RisLayout } from './layout/ris-layout/ris-layout';

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
          import('./features/lista-pz/lista-pz')
            .then((m) => m.ListaPz),
      },
      {
        path: 'accettazione',
        providers: [StatoSio],
        loadComponent: () =>
          import('./features/accettazione/accettazione')
            .then((m) => m.Accettazione),
      },
      {
        path: 'stato-sio',
        loadComponent: () =>
          import('./features/stato-sio/stato-sio')
            .then((m) => m.StatoSio),
      }
    ]
  },
  {
    path: 'ris',
    component: RisLayout,
    children: []
  },
  {
    path: '**',
    redirectTo: 'lista-pz',
    pathMatch: 'full',
  }
];
