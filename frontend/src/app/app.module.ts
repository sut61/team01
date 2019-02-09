import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router';
import { CommonModule} from '@angular/common';
import { AgmCoreModule } from '@agm/core';
import { AppComponent } from './app.component';
import { ManuComponent } from './manu/manu.component';
import {ManuService} from './service/manu.service';
import { HomestaffComponent } from './homestaff/homestaff.component';
import { MemberComponent } from './member/member.component';
import { ShowmanuComponent } from './showmanu/showmanu.component';
import { LoginComponent } from './login/login.component';
import { HomememComponent } from './homemem/homemem.component';
import { LoginmemComponent } from './loginmem/loginmem.component';
import { PaymentComponent } from './payment/payment.component';
import { ViewcoffeeorderComponent } from './viewcoffeeorder/viewcoffeeorder.component';
import { HomeComponent } from './home/home.component';
import { ContactComponent } from './contact/contact.component';
import { CoffeeorderComponent } from './coffeeorder/coffeeorder.component';
import { AboutComponent } from './about/about.component';
import { PointComponent } from './point/point.component';
import { PointViewComponent } from './point-view/point-view.component';
import {
  MatAutocompleteModule,
  MatBadgeModule,
  MatBottomSheetModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatDividerModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatStepperModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatTreeModule,
} from '@angular/material';
import {DialogShoppingCarComponent} from "./dialog-shopping-car/dialog-shopping-car.component";
import {DialogMapComponent} from "./dialog-map/dialog-map.component";
import {CoffeeDeliveryComponent} from "./coffee-delivery/coffee-delivery.component";
import {FlexLayoutModule} from "@angular/flex-layout";
import { RewardComponent } from './reward/reward.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { ViewfeedbackComponent } from './viewfeedback/viewfeedback.component';
import { Allservice2Service } from './service/allservice2.service';
import { StockComponent } from './stock/stock.component';
import { CreditpaymentComponent } from './creditpayment/creditpayment.component';
import { CancelMemberComponent } from './cancel-member/cancel-member.component';
import { DeleteComponent } from './delete/delete.component';


const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'login', component: LoginComponent},
  {path: 'loginmem', component: LoginmemComponent},
  {path: 'homestaff', component: HomestaffComponent},
  {path: 'homemem', component: HomememComponent},
  {path: 'manu', component: ManuComponent},
  {path: 'member', component: MemberComponent},
  {path: 'showmanu', component: ShowmanuComponent},
  {path: 'payment', component: PaymentComponent},
  { path: 'about', component: AboutComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'coffeeorders', component: CoffeeorderComponent},
  { path: 'home', component: HomeComponent },
  { path: 'viewcoffeeorders', component: ViewcoffeeorderComponent },
  {path:'point',component:PointComponent},
  {path:'point-view',component:PointViewComponent},
  {path: 'CoffeeDelivery', component: CoffeeDeliveryComponent},
  {path:'reward',component:RewardComponent},
  {path: 'feedback', component: FeedbackComponent},
  {path: 'viewfeedback', component: ViewfeedbackComponent},
  {path: 'stock', component: StockComponent},
  {path: 'creditcardpayment', component: CreditpaymentComponent},
  {path: 'cancel-member', component: CancelMemberComponent},
  {path: 'delete', component: DeleteComponent}

];

@NgModule({
  declarations: [
    AppComponent,
    ManuComponent,
    HomestaffComponent,
    MemberComponent,
    ShowmanuComponent,
    LoginComponent,
    HomememComponent,
    LoginmemComponent,
    PaymentComponent,
    ViewcoffeeorderComponent,
    HomeComponent,
    ContactComponent,
    CoffeeorderComponent,
    AboutComponent,
    PointComponent,
    PointViewComponent,
    CoffeeDeliveryComponent,
    DialogMapComponent,
    DialogShoppingCarComponent,
    RewardComponent,
    FeedbackComponent,
    ViewfeedbackComponent,
    StockComponent,
    CreditpaymentComponent,
    CancelMemberComponent,
    DeleteComponent,

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    MatAutocompleteModule,
    MatBadgeModule,
    MatBottomSheetModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatDatepickerModule,
    MatDialogModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatStepperModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    MatTreeModule,
    RouterModule.forRoot(routes),
    AgmCoreModule.forRoot({apiKey: 'AIzaSyBS-fusP8ANNGCD1KGL7Bop1bqD1XcXTYk'}),
    FlexLayoutModule

  ],
  entryComponents: [
    DialogMapComponent,
    DialogShoppingCarComponent
  ],
  providers: [ManuService, Allservice2Service],
  bootstrap: [AppComponent]
})
export class AppModule { }
