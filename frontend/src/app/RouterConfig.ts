import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './Component/shared/login/login.component';
import { RegisterComponent } from './Component/shared/register/register.component';
import { AuthGaurdService } from './Services/auth-gaurd-service.service';
import { CustomerhomeComponent } from './Component/home/customerhome/customerhome.component';
import { AdminhomeComponent } from './Component/home/adminhome/adminhome.component';


const routes: Routes = [
  { path:'', component: LoginComponent },
  { path:'register', component: RegisterComponent },
  { path:'home', component:CustomerhomeComponent ,canActivate:[AuthGaurdService] },
  { path:'admin', component:AdminhomeComponent ,canActivate:[AuthGaurdService]},
  { path:'requestloan', component:AdminhomeComponent ,canActivate:[AuthGaurdService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
