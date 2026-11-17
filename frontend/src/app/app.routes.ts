import { Routes } from '@angular/router';
import { ListaPz } from './features/lista-pz/lista-pz';
import { Accettazione } from './features/accettazione/accettazione';
import { StatoSio } from './features/stato-sio/stato-sio';

export const routes: Routes = [
  {
    path: '', // route di default, se l'utente non specifica un percorso, viene reindirizzato a 'lista-pz'
    redirectTo: 'lista-pz',
    pathMatch: 'full',
  },
  {
    path: 'lista-pz',
    loadComponent: () => import('./features/lista-pz/lista-pz').then((m) => m.ListaPz),
  },
  {
    path: 'accettazione',
    loadComponent: () => import('./features/accettazione/accettazione').then((m) => m.Accettazione),
    children: [
      {
        path: 'accettazione/:cf',
        loadComponent: () => import('./features/accettazione/accettazione').then((m) => m.Accettazione),
      }
    ]
  },
  {
    path: 'stato-sio',
    loadComponent: () => import('./features/stato-sio/stato-sio').then((m) => m.StatoSio),
  },
  {
    path: '**', // route wildcard, cattura tutte le rotte non definite e reindirizza a 'lista-pz'
    redirectTo: 'lista-pz',
    pathMatch: 'full',
  },
];
