import { Component } from '@angular/core';
import { Table } from 'primeng/table';
import { MessageService } from 'primeng/api';
import { Candidate } from 'src/app/demo/api/candidate';
import { CandidateService } from 'src/app/demo/service/candidate.service';

@Component({
    templateUrl: './vote.component.html',
    providers: [MessageService, CandidateService]
})
export class VoteComponent{ 

    candidates!: Candidate[];
    constructor(private candidateService: CandidateService, private messageService: MessageService) { }

    ngOnInit() {

        this.candidateService.getCandidates().then(data => this.candidates = data);
        
    }

    onGlobalFilter(table: Table, event: Event) {
        table.filterGlobal((event.target as HTMLInputElement).value, 'contains');
    }
}
