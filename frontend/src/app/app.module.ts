import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Component/shared/login/login.component';
import { RegisterComponent } from './Component/shared/register/register.component';
import { GetloanComponent } from './Component/home/getloan/getloan.component';
import { CustomerhomeComponent } from './Component/home/customerhome/customerhome.component';
import { AdminhomeComponent } from './Component/home/adminhome/adminhome.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './Component/shared/header/header.component';
import { FooterComponent } from './Component/shared/footer/footer.component'; 

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    GetloanComponent,
    CustomerhomeComponent,
    AdminhomeComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
