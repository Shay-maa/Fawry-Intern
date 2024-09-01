import { Component, NgModule } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TodoItemsComponent } from "./todo-items/todo-items.component";
import { FormsModule } from '@angular/forms';
import * as uuid from 'uuid';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TodoItemsComponent , FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'todo-app';
}
