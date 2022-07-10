import { Injectable, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, HttpInterceptor, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { MainComponent } from './component/main.component';
import { FeedComponent } from './component/feed.component';
import { LoginComponent } from './component/login.component';
import { RegistrationComponent } from './component/registration.component';
import { AdminComponent } from './component/admin.component';
import { AppService } from './service/app.service';


@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    FeedComponent,
    LoginComponent,
    RegistrationComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AppService],
  bootstrap: [AppComponent]
})
export class AppModule { }
