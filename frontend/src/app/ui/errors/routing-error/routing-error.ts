import { Component, inject, input } from '@angular/core';
import { Button } from '@openng/optimus-ui/button';
import { Router, RouterLink } from '@angular/router';

@Component({
  imports: [Button, RouterLink],
  selector: 'sio-routing-error',
  styleUrl: './routing-error.css',
  templateUrl: './routing-error.html',
})
export class RoutingError {
  readonly error = input<Error>();

  readonly #router = inject(Router);

  protected redirectToListaPz(){
    this.#router.navigate(['/lista-pz'])
  }
}
