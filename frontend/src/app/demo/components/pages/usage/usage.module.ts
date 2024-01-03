import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsageRoutingModule } from './usage-routing.module';
import { UsageComponent } from './usage.component';
import { TimelineModule } from 'primeng/timeline';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';

@NgModule({
    imports: [
        CommonModule,
        TimelineModule,
        ButtonModule,
        CardModule,
        UsageRoutingModule
    ],
    declarations: [UsageComponent]
})
export class UsageModule { }
