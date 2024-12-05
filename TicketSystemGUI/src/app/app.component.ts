import { Component, HostListener, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {LeftSidebarComponent} from './left-sidebar/left-sidebar.component';
import {ConfigureComponent} from './configure/configure.component';
import {ControlPanelComponent} from './control-panel/control-panel.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {HomeComponent} from './home/home.component';
import {MainComponent} from './main/main.component';
import{UserControlComponent} from './user-control/user-control.component';
import { NgZone } from '@angular/core';
import { VendorPageComponent } from './vendor-page/vendor-page.component';
import { CustomerPageComponent } from './customer-page/customer-page.component';



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,LeftSidebarComponent,ConfigureComponent,ControlPanelComponent,DashboardComponent,HomeComponent,MainComponent,UserControlComponent,VendorPageComponent,CustomerPageComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Real_Time_Event_Ticketing_System';
  isLeftSidebarCollapsed = signal<boolean>(false);
  screenWidth = signal<number>(window.innerWidth);

  @HostListener('window:resize') // Detect screen resize events
  onResize(){
    this.screenWidth.set(window.innerWidth);
    if (this.screenWidth() < 768){
      this.isLeftSidebarCollapsed.set(true);
    } else{
      this.isLeftSidebarCollapsed.set(false);
    }

  }
  ngOnInit(): void {
    this.isLeftSidebarCollapsed.set(this.screenWidth() < 768);
    
  }


  changeIsLeftSidebarCollapsed(isLeftSidebarCollapsed: boolean): void{
    this.isLeftSidebarCollapsed.set(isLeftSidebarCollapsed);
  }

}
