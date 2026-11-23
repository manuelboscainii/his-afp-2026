import { Component, inject } from '@angular/core';
import { Resources } from '../../core/resources/resources';

@Component({
  imports: [],
  selector: 'sio-lista-pz',
  styleUrl: './lista-pz.css',
  templateUrl: './lista-pz.html',
})
export class ListaPz {
  protected readonly resources = inject(Resources);

  constructor() {
    this.resources.fetchPatologie();
  }
}
