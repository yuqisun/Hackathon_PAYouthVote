import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Candidate } from 'src/app/demo/api/candidate';

@Injectable()
export class CandidateService {

    constructor(private http: HttpClient) { }

    getCandidates() {
        return this.http.get<any>('assets/demo/data/candidate.json')
            .toPromise()
            .then(res => res.data as Candidate[])
            .then(data => data);
    }

}
