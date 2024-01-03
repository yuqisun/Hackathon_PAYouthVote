import { Component } from '@angular/core';
import { LayoutService } from 'src/app/layout/service/app.layout.service';
import { Router } from '@angular/router';
import { AuthService } from '../../../service/auth.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styles: [`
        :host ::ng-deep .pi-eye,
        :host ::ng-deep .pi-eye-slash {
            transform:scale(1.6);
            margin-right: 1rem;
            color: var(--primary-color) !important;
        }
    `]
})
export class LoginComponent {

    valCheck: string[] = ['remember'];
    password!: string;
    email: string = '';

    constructor(public layoutService: LayoutService,
        public authervice: AuthService,
        private router: Router) { }

    login () {
        console.log(this.email + ' ' + this.password);
        this.authervice.login(this.email, this.password).then((res:any) => {
            if (res.success) {
                this.authervice.regitrationStatus = res.data.registerStatus;
                this.router.navigate(['/dashboard']);
            } else {
                this.router.navigate(['/access']);
            }
            
        });
        
    }
    
}
