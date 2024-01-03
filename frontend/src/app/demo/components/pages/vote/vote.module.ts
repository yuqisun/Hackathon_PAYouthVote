import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableModule } from 'primeng/table';
import { VoteRoutingModule } from './vote-routing.module';
import { VoteComponent} from './vote.component';

@NgModule({
    imports: [
        CommonModule,
        TableModule,
        VoteRoutingModule
    ],
    declarations: [VoteComponent]
})
export class VoteModule { }
