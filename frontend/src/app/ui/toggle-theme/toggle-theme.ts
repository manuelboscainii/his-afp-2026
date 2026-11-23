import { Component } from '@angular/core';
import { Button } from '@openng/optimus-ui/button';

@Component({
  imports: [Button],
  selector: 'sio-toggle-theme',
  styleUrl: './toggle-theme.css',
  // templateUrl: './toggle-theme.html',
  template: `<p-button
    (onClick)="toggleDarkMode()"
    // rounded="{{round}}"
    [rounded]="true"
    [text]="true"
    icon="pi pi-sun"
    severity="secondary"
  />`,
})
export class ToggleTheme {
  toggleDarkMode() {
    const element = document.querySelector('html');
    element?.classList.toggle('my-app-dark');
    // if (element !== null){
    //   element.classList.toggle('my-app-dark');
    // }
  }
}

