import { Component, computed, inject } from '@angular/core';
import { StatoServiziSio } from './stato-servizi-sio/stato-servizi-sio';
import { DatePipe, DecimalPipe, JsonPipe } from '@angular/common';
import { Button } from '@openng/optimus-ui/button';
import { Card } from '@openng/optimus-ui/card';
import { Tag } from '@openng/optimus-ui/tag';
import { IStatoSio } from './stato-servizi-sio/stato-servizi-sio.models';
import { ProgressBar } from '@openng/optimus-ui/progressbar';


@Component({
  imports: [DatePipe, Button, Card, Tag, DecimalPipe, ProgressBar],
  selector: 'sio-stato-servizi-sio',
  styleUrl: './stato-sio.css',
  templateUrl: './stato-sio.html',
})
export class StatoSio {
  readonly statoSioSrv = inject(StatoServiziSio);

  protected readonly statoGenerale = computed(() => this.statoSioSrv.statoSio().status);

  protected readonly statoDb = computed(() => this.statoSioSrv.statoSio().components.db);

  protected readonly statoDisco = computed(() => this.statoSioSrv.statoSio().components.diskSpace);

  protected getSeverity(status: IStatoSio) {
    switch (status) {
      case 'UP':
        return 'success';
      case 'DOWN':
      case 'OUT_OF_SERVICE':
        return 'danger';
      case 'UNKNOWN':
        return 'warn';
      default:
        return 'secondary';
    }
  }

  protected readonly calcDiskSpace = computed(() => {
    const dettagliDisco = this.statoDisco().details;
    if (!dettagliDisco || dettagliDisco.total <= 0) return { gbFree: 0, gbTot: 0, gbUsed: 0 };

    const gbFactor = 1024 ** 3;
    const gbTot = dettagliDisco.total / gbFactor;
    const gbFree = dettagliDisco.free / gbFactor;
    const gbUsed = Math.round(
      ((dettagliDisco.total - dettagliDisco.free) / dettagliDisco.total) * 100,
    );

    return { gbFree, gbTot, gbUsed };
  });
}
