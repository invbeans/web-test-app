import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable()
export class AppService{
  authenticated = false;
  mapping = "http://localhost:8080/api";
  constructor(private http: HttpClient){}

  login(user: any){
     const httpOptions = {
      headers: new HttpHeaders({
      'Content-Type':  'application/json'
      })
    };
    const body = {username: user.username, password: user.password};
    return this.http.post(this.mapping + "/login", body, httpOptions);
  }

  registration(user: any){
    const httpOptions = {
      headers: new HttpHeaders({
      'Content-Type':  'application/json'
      })
    };
    const body = {username: user.username, email: user.email, password: user.password};
    return this.http.post(this.mapping + '/registration', body, httpOptions);
  }

  saveTest(testJson: any){
    const httpOptions = {
      headers: new HttpHeaders({
      'Content-Type':  'application/json'
      })
    };
    const body = testJson;
    return this.http.post(this.mapping + '/admin/save_test', body, httpOptions);
  }

  getTestsInfo(){
    return this.http.get(this.mapping + '/feed/tests_info');
  }

}
