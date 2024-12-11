import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { LoginComponent } from './login/login.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { DeleteAccountComponent } from './delete-account/delete-account.component';
import { CreateEventComponent } from './create-event/create-event.component';
import { CheckEventDetailsComponent } from './check-event-details/check-event-details.component';
import { AllEventsComponent } from './all-events-vendor/all-events-vendor.component';
import { PurchaseTicketsComponent } from './purchase-tickets/purchase-tickets.component';
import { AddToTicketPoolComponent } from './add-to-ticket-pool/add-to-ticket-pool.component';

export const routes: Routes = [
    {path: '', redirectTo: 'welcomePage', pathMatch: 'full'},
    {path: 'welcomePage', component: WelcomePageComponent},
    {path: ':usertype/signUp', component: RegisterComponent },
    {path: ':usertype/signIn', component: LoginComponent},
    {path: ':usertype/home', component: HomePageComponent},
    {path: ':usertype/changePassword', component: ChangePasswordComponent},
    {path: ':usertype/deleteAccount', component: DeleteAccountComponent},
    {path: ':usertype/signOut', component: WelcomePageComponent},
    {path: ':usertype/createEvent', component: CreateEventComponent},
    {path: ':usertype/checkEventDetails', component: CheckEventDetailsComponent},
    {path: ':usertype/allEvents', component: AllEventsComponent},
    {path: ':usertype/purchaseTickets', component: PurchaseTicketsComponent},
    //
    {path: ':usertype/addToTicketPool', component: AddToTicketPoolComponent},
    {path: ':usertype/buyTickets', component: HomePageComponent}
];