import { HttpClient } from '@angular/common/http';
import { Component, Injectable } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass'],
})
@Injectable()
export class AppComponent {
  title = 'angular-client';

  constructor(private http: HttpClient) {}

  ngOnInit() {
    console.log('Loading app');
    this.http.get('http://localhost:8080/').subscribe((data) => {
      console.log(data);
    });
    this.http.get('http://localhost:8080/test').subscribe((data) => {
      console.log(data);
    });
  }
}
