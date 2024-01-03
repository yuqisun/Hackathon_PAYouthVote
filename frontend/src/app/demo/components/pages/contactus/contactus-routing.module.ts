import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ContactusComponent } from './contactus.component';

@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: ContactusComponent }
	])],
	exports: [RouterModule]
})
export class ContactusRoutingModule { }
