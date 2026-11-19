import { Component, signal } from '@angular/core';
import { Header } from './ui/header/header';
import { Sidebar } from './ui/sidebar/sidebar';
import { MainLayout } from './layout/main-layout/main-layout';
import { RouterOutlet } from '@angular/router';

@Component({
  imports: [MainLayout, RouterOutlet],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('frontend');
}
