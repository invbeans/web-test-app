import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { AppService } from "../service/app.service";

@Component({
  selector: 'main-comp',
  templateUrl: './main.component.html'
})
export class MainComponent{
  constructor(private service: AppService, private http: HttpClient) {}

  authenticated(){return this.service.authenticated;}
}
