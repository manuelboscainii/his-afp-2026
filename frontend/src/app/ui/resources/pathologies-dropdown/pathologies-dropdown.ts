import { Component, inject, model, output, WritableSignal } from '@angular/core';
import { Resources } from '../../../core/resources/resources';
import { Select } from '@openng/optimus-ui/select';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [Select, FormsModule],
  selector: 'sio-pathologies-dropdown',
  styleUrl: './pathologies-dropdown.css',
  templateUrl: './pathologies-dropdown.html',
})
export class PathologiesDropdown {
  readonly resources = inject(Resources);
  selectedPathology = model.required<WritableSignal<string>>();
}
