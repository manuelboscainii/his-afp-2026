import { Component, signal } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { Tooltip } from '@openng/optimus-ui/tooltip';
import { Tag } from '@openng/optimus-ui/tag';

interface INavItem{
  label: string;
  icon: string;
  route: string;
}
type TAmbiente = 'S' | 'T' | 'P';

@Component({
  imports: [RouterLink, RouterLinkActive, Tooltip],
  selector: 'sio-sidebar',
  styleUrl: './sidebar.css',
  templateUrl: './sidebar.html',
})
export class Sidebar {
  readonly navItems = signal<INavItem[]>([
    {
      label: 'Lista pazienti',
      icon: 'pi pi-user',
      route: '/lista-pz',
    },
    {
      label: 'Accettazione',
      icon: 'pi pi-user-plus',
      route: '/accettazione',
    },
    {
      label: 'Stato SIO',
      icon: 'pi pi-server',
      route: '/stato-servizi-sio',
    },
  ]);
  readonly versione = signal('v0.0.1');
  readonly ambiente = signal<TAmbiente>('T');
}










