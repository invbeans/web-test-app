import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { AppService } from "../service/app.service";

@Component({
  selector: 'reg-comp',
  templateUrl: './registration.component.html'
})
export class RegistrationComponent{
  user = {
    id: 0,
    username: '',
    email: '',
    password: '',
    passwordConfirm: ''
  }

  //проверка пароля уходит на фронт
  constructor(private router: Router, private service: AppService){}

  registration(){
    this.service.registration(this.user)
    .subscribe((data: any) => {
      this.user = data;
      if(this.user !== null || this.user !== undefined){
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
    })
  }
}
