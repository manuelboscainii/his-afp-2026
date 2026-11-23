import { Component, signal } from '@angular/core';
import { Header } from './ui/header/header';
import { MainLayout } from './layout/main-layout/main-layout';
import { RouterOutlet } from '@angular/router';

@Component({
  imports: [RouterOutlet],
  selector: 'sio-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('frontend');
}
