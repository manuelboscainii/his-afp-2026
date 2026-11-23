import { Component, inject, signal } from '@angular/core';
import { Divider } from '@openng/optimus-ui/divider';
import { ToggleTheme } from '../toggle-theme/toggle-theme';
import { NgOptimizedImage } from '@angular/common';
import { Resources } from '../../core/resources/resources';
import { PathologiesDropdown } from '../resources/pathologies-dropdown/pathologies-dropdown';

@Component({
  imports: [Divider, ToggleTheme, NgOptimizedImage, PathologiesDropdown],
  selector: 'sio-header',
  styleUrl: './header.css',
  templateUrl: './header.html',
})
export class Header {
  readonly reparto = signal('Pronto Soccorso');
  readonly struttura = signal('Presidio Ospedaliero di Arco');

  res = inject(Resources);
  readonly patho = signal<string>('');

  constructor() {
    this.res.fetchPatologie();
  }

}
