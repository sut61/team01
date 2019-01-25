import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { CoffeeDeliveryComponent } from './coffee-delivery/coffee-delivery.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatSidenavModule } from '@angular/material/sidenav';
import { LayoutModule } from '@angular/cdk/layout';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatBadgeModule } from '@angular/material/badge';
import { MatDialogModule } from '@angular/material/dialog';
import { DialogMapComponent } from './dialog-map/dialog-map.component';
import { AgmCoreModule } from '@agm/core';
import { DialogShoppingCarComponent } from './dialog-shopping-car/dialog-shopping-car.component';
import { MatTableModule } from '@angular/material/table';
import {MatSelectModule} from '@angular/material/select';



const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full' },
  {path: 'login', component: LoginComponent},
  {path: 'loginmem', component: LoginmemComponent},
  {path: 'homestaff', component: HomestaffComponent},
  {path: 'homemem', component: HomememComponent},
  {path: 'manu', component: ManuComponent},
  {path: 'member', component: MemberComponent},
  {path: 'showmanu', component: ShowmanuComponent},
  {path: 'payment', component: PaymentComponent},
  {path: 'showpay', component: ShowpayComponent},
  { path: 'about', component: AboutComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'coffeeorders', component: CoffeeorderComponent},
  { path: 'home', component: HomeComponent },
  { path: 'viewcoffeeorders', component: ViewcoffeeorderComponent },

];




@NgModule({
  declarations: [
    AppComponent,
    CoffeeDeliveryComponent,
    DialogMapComponent,
    DialogShoppingCarComponent,
    ManuComponent,
    HomestaffComponent,
    MemberComponent,
    ShowmanuComponent,
    LoginComponent,
    HomememComponent,
    LoginmemComponent,
    PaymentComponent,
    ShowpayComponent,
    ViewcoffeeorderComponent,
    NavComponent,
    HomeComponent,
    ContactComponent,
    CoffeeorderComponent,
    AboutComponent,



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatMenuModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    MatGridListModule,
    MatCardModule,
    MatSidenavModule,
    LayoutModule,
    FlexLayoutModule,
    MatBadgeModule,
    MatDialogModule,
    AgmCoreModule.forRoot({apiKey: 'AIzaSyBS-fusP8ANNGCD1KGL7Bop1bqD1XcXTYk'}),
    MatTableModule,
    HttpClientModule,
    MatSelectModule,


  ],
  entryComponents: [
    DialogMapComponent,
    DialogShoppingCarComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
