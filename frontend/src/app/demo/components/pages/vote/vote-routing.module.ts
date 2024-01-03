import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { VoteComponent} from './vote.component';

@NgModule({
    imports: [RouterModule.forChild([
        { path: '', component: VoteComponent}
    ])],
    exports: [RouterModule]
})
export class VoteRoutingModule { }
