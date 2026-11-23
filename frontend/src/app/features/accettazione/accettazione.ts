import { Component, signal } from '@angular/core';
import { SearchInput } from '../../ui/search-input/search-input';
import { Card } from '@openng/optimus-ui/card';
import { Button } from '@openng/optimus-ui/button';

@Component({
  imports: [SearchInput, Card, Button],
  selector: 'sio-accettazione',
  styleUrl: './accettazione.css',
  templateUrl: './accettazione.html',
})
export class Accettazione {
  readonly placeholder = signal<string>('Ricerca codice fiscale...');

  protected readonly searchText = signal<string>('');
  protected readonly lastSearch = signal<string>('');

  protected eseguiRicerca(query: string) {
    this.lastSearch.set(query);
  }

  protected reset() {
    this.searchText.set('');
    this.lastSearch.set('');
  }

  protected setExampleValue(){
    this.searchText.set('RCCPTR01A19H612K');
  }
}
