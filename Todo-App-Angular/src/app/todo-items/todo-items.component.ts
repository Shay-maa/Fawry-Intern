import { CommonEngine } from '@angular/ssr';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { v4 as uuidV4 } from 'uuid';

@Component({
  selector: 'app-todo-items',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './todo-items.component.html',
  styleUrl: './todo-items.component.css',
})
export class TodoItemsComponent {
  header: string = 'ToDo List';
  tasks: Array<{ id: string; title: string; completed: boolean }> = [];
  title: string = '';
  newTitle: string = '';
  _id: string = '';

  constructor() {}

  loadTasks() {
    const tasksString = localStorage.getItem('tasks');
    if (tasksString) {
      this.tasks = JSON.parse(tasksString);
    }
  }

  addTask(title: string) {
    this.loadTasks();
    if (title) {
      this.tasks.push({
        id: uuidV4(),
        title: title,
        completed: false,
      });
    }
    this.title = '';
    localStorage.setItem('tasks', JSON.stringify(this.tasks));
  }

  setId(Id: string) {
    this._id = Id;
  }

  editTask(newTitle: string) {
    if (newTitle) {
      this.loadTasks();
      for (let task of this.tasks) {
        if (task.id === this._id) {
          task.title = newTitle;
          this.newTitle = '';
        }
      }
      localStorage.setItem('tasks', JSON.stringify(this.tasks));
    }
  }
  deleteTask(id: string) {
    this.loadTasks();

    for (let task of this.tasks) {
      if (task.id === id) {
        this.tasks.splice(this.tasks.indexOf(task), 1);
      }
    }
    localStorage.setItem('tasks', JSON.stringify(this.tasks));
  }
  completeTask(id: string) {
    this.loadTasks();
    for (let task of this.tasks) {
      if (task.id === id) {
        if (task.completed) {
          task.completed = false;
        } else {
          task.completed = true;
        }
      }
    }
    localStorage.setItem('tasks', JSON.stringify(this.tasks));
  }
}
