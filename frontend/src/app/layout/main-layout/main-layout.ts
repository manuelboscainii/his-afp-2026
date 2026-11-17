import { Component } from '@angular/core';
import { Header } from '../../ui/header/header';
import { Sidebar } from '../../ui/sidebar/sidebar';
import { RouterOutlet } from '@angular/router';

@Component({
  imports: [Header, Sidebar, RouterOutlet],
  selector: 'sio-main-layout',
  styleUrl: './main-layout.css',
  templateUrl: './main-layout.html',
})
export class MainLayout {}
