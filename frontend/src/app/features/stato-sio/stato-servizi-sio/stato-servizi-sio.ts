import { inject, Service, signal } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { IStatoServizioSio, STATO_SIO_MOCK} from './stato-servizi-sio.models';


@Service()
export class StatoServiziSio {
  readonly #http = inject(HttpClient);

  readonly #statoSio = signal<IStatoServizioSio>(STATO_SIO_MOCK); // Stato SIO privato come segnale reattivo
  readonly #loading = signal<boolean>(false);
  readonly #lastChecked = signal<Date | null>(null);

  readonly statoSio = this.#statoSio.asReadonly();
  readonly loading = this.#loading.asReadonly();
  readonly lastChecked = this.#lastChecked.asReadonly();

  constructor() {
    this.fetchStatoSio();
  }

  public fetchStatoSio() {
    this.#loading.set(true);
    this.#http.get("http://localhost:8080/actuator/health")
      .subscribe({
        next: (res) => {
          console.log(res);
          this.#statoSio.set(res);
          this.#lastChecked.set(new Date());
          this.#loading.set(false);
        },
        error: (err: HttpErrorResponse) => {
          console.error(err);
          // this.#loading.set(false);
          if (err.status === 503) {
             console.log(err.error);
             this.#statoSio.set(err.error);
          }
          this.
        }
        }
      )
  }

}
