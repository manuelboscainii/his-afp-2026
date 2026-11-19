import { Component, input, model, output } from '@angular/core';

@Component({
  imports: [],
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
   * OUTPUT:
   *  - search
   *
   * TWO-WAY:
   *  - value
   */

  protected readonly inputId = `sio-search-${nextId}`;

  readonly label = input.required<string>();
  readonly placeholder = input<string>('Cerca FC...');

  readonly value = model<string>('');

  readonly search = output<string>();

  protected onInput(event: Event) {
    const text = (event.target) as HTMLInputElement;

    this.value.set(text);
  }

  protected onSearch(){
    const trimmed = this.value().trim();
    if (trimmed) {
      this.search.emit(trimmed);
    }
  }

}
