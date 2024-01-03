import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { RepresentComponent } from './represent.component';

@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: RepresentComponent }
	])],
	exports: [RouterModule]
})
export class RepresentRoutingModule { }
