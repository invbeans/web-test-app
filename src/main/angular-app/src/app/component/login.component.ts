import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { AppService } from "../service/app.service";

@Component({
  selector: 'log-comp',
  templateUrl: './login.component.html'
})
export class LoginComponent{
  constructor(private router: Router, private service: AppService){}

  user = {
    id: 0,
    username: '',
    email: '',
    password: '',
    role: ''
  }

  login(){
    this.service.login(this.user)
    .subscribe((data: any) => {
      this.user = data;
      if( (this.user.username !== "none" && this.user.password !== "none") || this.user !== null || this.user !== undefined){
        if(this.user.role === "ROLE_ADMIN"){
          this.router.navigate(
            ['/admin']
          )
        }
        else{
          this.router.navigate(
          ['/feed'],
          {
            queryParams:{
              'id': this.user.id,
              'username': this.user.username
            }
          }
        )
        }

      }
    })
  }
}
