import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { LoginComponent } from './login/login.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ChangePasswordComponent } from './change-password/change-password.component';

export const routes: Routes = [
    {path: '', redirectTo: 'welcomePage', pathMatch: 'full'},
    {path: 'welcomePage', component: WelcomePageComponent},
    {path: ':usertype/signUp', component: RegisterComponent },
    {path: ':usertype/signIn', component: LoginComponent},
    {path: ':usertype/home', component: HomePageComponent},
    {path: ':usertype/changePassword', component: ChangePasswordComponent},
    // create component
    {path: ':usertype/deleteAccount', component: HomePageComponent},
    {path: ':usertype/SignOut', component: HomePageComponent},
    {path: ':usertype/createEvent', component: HomePageComponent},
    {path: ':usertype/checkEventDetails', component: HomePageComponent},
    {path: ':usertype/allEvents', component: HomePageComponent},
    {path: ':usertype/purchaseTickets', component: HomePageComponent},
    {path: ':usertype/addToTicketPool', component: HomePageComponent},
    {path: ':usertype/buyTickets', component: HomePageComponent}
];
