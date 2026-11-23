import { Component, input, model, output } from '@angular/core';
import { InputText } from '@openng/optimus-ui/inputtext';
import { Button } from '@openng/optimus-ui/button';

let nextId = 0;

@Component({
  imports: [InputText, Button],
  selector: 'sio-search-input',
  styleUrl: './search-input.css',
  templateUrl: './search-input.html',
})
export class SearchInput {
  /**
   * INPUT:
   *  - label
   *  - placeholder
   *
   * OUTPUR:
   *  - search
   *
   * TWO-WAY
   *  - value
   */

  protected readonly inputId = `sio-search-${nextId}`;

  readonly label = input.required<string>();
  readonly placeholder = input<string>('Cerca FC...');

  readonly value = model<string>('');

  readonly search = output<string>();

  protected onInput(event: Event) {
    const text = (event.target as HTMLInputElement).value;

    this.value.set(text);
  }

  protected onSearch() {
    const trimmed = this.value().trim();
    if (trimmed) {
      this.search.emit(trimmed);
    }
  }
}
