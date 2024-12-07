import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';

export const routes: Routes = [
    {path: '', redirectTo: 'welcomepage', pathMatch: 'full'},
    // {path: 'vendornav', component: vendorComponent}
    {path: 'welcomepage', component: WelcomePageComponent},
    {path: 'register', component: RegisterComponent}
];
