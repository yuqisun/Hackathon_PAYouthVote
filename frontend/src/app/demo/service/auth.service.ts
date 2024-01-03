import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class AuthService {

    regitrationStatus: string = 'inprogress';
    constructor(private http: HttpClient) { }

    //{email, passowrd}
    login1(email, passowrd) {
        return this.http.get<any>('/assets/demo/data/login.json',)
            .toPromise()
    }

    login(email, passowrd) {
        return this.http.post<any>('https://p4xp3ms2cm.us-east-1.awsapprunner.com/voter/login?email='+email+'&password='+passowrd,{})
            .toPromise()
    }

    register(req) {
        return this.http.post<any>('https://p4xp3ms2cm.us-east-1.awsapprunner.com/voter/register', req)
            .toPromise()
    }
}
