import { Component, inject } from '@angular/core';
import { StatoServiziSio } from './stato-servizi-sio/stato-servizi-sio';
import { DatePipe, JsonPipe } from '@angular/common';
import { Button } from '@openng/optimus-ui/button';

@Component({
  imports: [JsonPipe, DatePipe, Button],
  selector: 'sio-stato-servizi-sio',
  styleUrl: './stato-sio.css',
  templateUrl: './stato-sio.html',
})
export class StatoSio {
  readonly statoSioSrv = inject(StatoServiziSio);

}
