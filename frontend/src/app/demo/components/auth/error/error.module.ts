import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; 
import { ErrorRoutingModule } from './error-routing.module';
import { ErrorComponent } from './error.component';
import { ButtonModule } from 'primeng/button';
import { CalendarModule } from 'primeng/calendar';
import { RadioButtonModule } from 'primeng/radiobutton';
import { DropdownModule } from 'primeng/dropdown';
import { StepsModule } from 'primeng/steps';
import { PanelModule } from 'primeng/panel';
import { FieldsetModule } from 'primeng/fieldset';
import { PasswordModule } from 'primeng/password';
import { ConfirmDialogModule } from 'primeng/confirmdialog';


@NgModule({
    imports: [
        CommonModule,
        ErrorRoutingModule,
        ButtonModule,
        CalendarModule,
        RadioButtonModule,
        FormsModule,
        DropdownModule,
        StepsModule,
        PanelModule,
        FieldsetModule,
        PasswordModule,
        ConfirmDialogModule
    ],
    declarations: [ErrorComponent]
})
export class ErrorModule {
    


}
