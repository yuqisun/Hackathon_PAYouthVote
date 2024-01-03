import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AwardComponent } from './award.component';

@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: AwardComponent }
	])],
	exports: [RouterModule]
})
export class AwardRoutingModule { }
