import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { VotemailComponent } from './votemail.component';

@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: VotemailComponent }
	])],
	exports: [RouterModule]
})
export class VotemailRoutingModule { }
