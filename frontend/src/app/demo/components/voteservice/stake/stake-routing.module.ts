import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { StakeComponent } from './stake.component';

@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: StakeComponent }
	])],
	exports: [RouterModule]
})
export class StakeRoutingModule { }
