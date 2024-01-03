import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { UsageComponent } from './usage.component';

@NgModule({
    imports: [RouterModule.forChild([
        { path: '', component: UsageComponent }
    ])],
    exports: [RouterModule]
})
export class UsageRoutingModule { }
