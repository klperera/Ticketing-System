import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';

export const routes: Routes = [
    {path: 'WelcomePage', component: WelcomePageComponent},
    {path: 'Register', component: RegisterComponent}
];
