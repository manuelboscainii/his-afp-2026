import { Component, signal } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { Tooltip } from '@openng/optimus-ui/tooltip';

interface INavItem {
  label: string;
  icon: string;
  route: string;
}

@Component({
  imports: [RouterLink, Tooltip, RouterLinkActive],
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
      route: '/stato-sio',
    },
  ]);
}
