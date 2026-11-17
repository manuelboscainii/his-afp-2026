import { Component, signal } from '@angular/core';
import { Divider } from '@openng/optimus-ui/divider';
import { Tag } from '@openng/optimus-ui/tag';
import { ToggleTheme } from '../toggle-theme/toggle-theme';

type TAmbiente = 'S' | 'T' | 'P';
enum Ambiente2 {
  Sviluppo = 'S',
  Test = 'T',
  Produzione = 'P',
}

@Component({
  imports: [Divider, Tag, ToggleTheme],
  selector: 'sio-header',
  styleUrl: './header.css',
  templateUrl: './header.html',
})
export class Header {
  readonly reparto = signal('Pronto Soccorso');
  readonly struttura = signal('Presidio Ospedaliero di Verona');

  readonly versione = signal('v0.0.1');
  readonly ambiente = signal<TAmbiente>('S');
}
