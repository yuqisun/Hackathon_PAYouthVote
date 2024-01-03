import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { PointComponent } from './point.component';

@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: PointComponent }
	])],
	exports: [RouterModule]
})
export class PointRoutingModule { }
