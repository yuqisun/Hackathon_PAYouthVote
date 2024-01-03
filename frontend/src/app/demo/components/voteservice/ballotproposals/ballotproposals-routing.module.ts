import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BallotproposalsComponent } from './ballotproposals.component';

@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: BallotproposalsComponent }
	])],
	exports: [RouterModule]
})
export class BallotproposalsRoutingModule { }
