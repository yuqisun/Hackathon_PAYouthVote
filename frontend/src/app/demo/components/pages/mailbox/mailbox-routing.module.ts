import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MailboxComponent } from './mailbox.component';

@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: MailboxComponent }
	])],
	exports: [RouterModule]
})
export class MailboxRoutingModule { }
