import { inject, Service, signal } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { IStatoServiziSio, STATO_SIO_MOCK } from './stato-servizi-sio.models';

@Service({autoProvided: false})
export class StatoServiziSio {
  readonly #http = inject(HttpClient);

  readonly #statoSio = signal<IStatoServiziSio>(STATO_SIO_MOCK);
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
    this.#http.get<IStatoServiziSio>('http://localhost:8080/actuator/health').subscribe({
      next: (res) => {
        console.log(res);
        this.#statoSio.set(res);
        this.#lastChecked.set(new Date());
        this.#loading.set(false);
      },
      error: (err: HttpErrorResponse) => {
        console.error(err.error);
        if (err.status === 503) {
          console.log(err.error);
          this.#statoSio.set(err.error);
        }else{
          this.#statoSio.set(STATO_SIO_MOCK);
        }
        this.#loading.set(false);
        this.#lastChecked.set(new Date());
      },
    });
  }
}
