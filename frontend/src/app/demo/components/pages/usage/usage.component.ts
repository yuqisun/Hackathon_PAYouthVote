import { Component, OnInit } from '@angular/core';
import { PrimeIcons } from 'primeng/api';

@Component({
    templateUrl: './usage.component.html',
    styleUrls: ['./usage.scss']
})
export class UsageComponent implements OnInit {

    events1: any[] = [];

    events2: any[] = [];

    ngOnInit() {
        this.events1 = [
            { status: 'Register Your Account', date: '', icon: PrimeIcons.SHOPPING_CART, color: '#9C27B0' },
            { status: 'Select Candidate to Vote', date: '', icon: PrimeIcons.COG, color: '#673AB7' },
            { status: 'Get Award and Point', date: '', icon: PrimeIcons.ENVELOPE, color: '#FF9800' },
            { status: 'Redeem your point', date: '', icon: PrimeIcons.CHECK, color: '#607D8B' , image: 'game-controller.jpg'}
        ];

        this.events2 = [
            "2020", "2021", "2022", "2023"
        ];
    }

}
