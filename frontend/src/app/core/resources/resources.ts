import { inject, Service, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IApiResponse, IPathology, Page, TApiResponsePathology } from './resources.models';
import { GestioneRisorseSIOService } from '../api';
import { toSignal } from '@angular/core/rxjs-interop';

@Service()
export class Resources {
  readonly #http = inject(HttpClient);
  readonly #gestioneRisorse = inject(GestioneRisorseSIOService);

  readonly #listaPatologie = signal<IPathology[]>([]);
  readonly listaPatologie = this.#listaPatologie.asReadonly();

  public fetchPatologie(){
    this.#http.get<TApiResponsePathology>('http://localhost:8080/resources/pathologies')
      .subscribe({
        next: (res) => {
          this.#listaPatologie.set(res.data.content);
        },
        error: (error) => {
          console.error(error);
        }
      })
  }

  public fetchPathoFromAPi(){
    toSignal(this.#gestioneRisorse.getAllPathologies({}));
  }
}
