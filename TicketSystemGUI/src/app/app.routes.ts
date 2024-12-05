import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import {DashboardComponent} from './dashboard/dashboard.component'
import {ControlPanelComponent} from './control-panel/control-panel.component';
import {ConfigureComponent} from './configure/configure.component'
import { UserControlComponent } from './user-control/user-control.component';
import { VendorPageComponent } from './vendor-page/vendor-page.component';
import { CustomerPageComponent } from './customer-page/customer-page.component';
import { NgModule } from '@angular/core';


export const routes: Routes = [
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
  { path: 'Configure', component: ConfigureComponent},
  { path: 'Control', component: ControlPanelComponent },
  { path: 'Dashboard', component: DashboardComponent },
  { path: 'Home', component: HomeComponent},
  { path: 'User Control', component: UserControlComponent},
  { path: 'Vendor-page',component: VendorPageComponent},
  { path: 'Customer-page', component: CustomerPageComponent},
]

