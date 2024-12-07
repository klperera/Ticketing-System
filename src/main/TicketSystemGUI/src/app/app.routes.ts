import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { LoginComponent } from './login/login.component';
import { HomePageComponent } from './home-page/home-page.component';

export const routes: Routes = [
    {path: '', redirectTo: 'welcomePage', pathMatch: 'full'},
    {path: 'welcomePage', component: WelcomePageComponent},
    {path: 'signUp', component: RegisterComponent},
    {path: 'signIn', component: LoginComponent},
    {path: 'home', component: HomePageComponent}
];
