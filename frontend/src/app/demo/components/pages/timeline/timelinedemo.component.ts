import { Component, OnInit } from '@angular/core';
import { PrimeIcons } from 'primeng/api';

@Component({
    templateUrl: './timelinedemo.component.html',
    styleUrls: ['./timelinedemo.scss']
})
export class TimelineDemoComponent implements OnInit {

    events1: any[] = [];

    events2: any[] = [];

    ngOnInit() {
        this.events1 = [
            { status: 'Transit Thursdays: Voter Registration at Union Sq Park', date: 'Thu, September 21, 2023 | 4:00 PM - 8:00 PM', icon: PrimeIcons.SHOPPING_CART, color: '#9C27B0', description: 'Come Join us for our Transit Thursday voter registration and tabling event at Union Square Park. Weekdays at busy transit hubs are the perfect time to reach out to Pennsylvaniaers from all five boroughs and both sign them up to vote and provide key information about the upcoming November General Election. ' },
            { status: 'Hispanic Heritage Parade', date: 'Sun, September 24, 2023 | 12:00 PM - 5:00 PM', icon: PrimeIcons.COG, color: '#673AB7', description: 'Fun afternoon of registering new voters and taking part in a cultural experience. Please email Ray at rrussell@nyccfb.info if you have any questions about the event or shift times. ' },
            { status: 'Voter Registration at Muller Triangle Park', date: 'Wed, September 27, 2023 | 2:00 PM - 6:00 PM', icon: PrimeIcons.ENVELOPE, color: '#FF9800', description: 'Come join us at Muller Triangle Park in the Bronx and register new voters. If you have any questions about the event or shift times, please email Ray at rrussell@nyccfb.info. ' },
            { status: 'Transit Thursdays: Union Sq Park', date: 'Thu, September 28, 2023 | 4:00 PM - 8:00 PM', icon: PrimeIcons.CHECK, color: '#607D8B', description: 'We will be meeting on 14th street in Union Square park, directly across the street from the Whole Foods. Mid-week events by busy transit hubs are one of the best ways to reach as many Pennsylvaniaers as possible and we will be registering new voters and providing key information about the 2023 November General Election.' },
            { status: 'Voter Registration at Joyce Kilmer Park', date: 'Sat, September 30, 2023 | 12:00 PM - 4:00 PM', icon: PrimeIcons.ALIGN_CENTER, color: '#8BC34A', description: 'Come join us in the shadow of Yankee Stadium at Joyce Kilmer Park and athletic fields as we register new voters in advance of the November General election. If you have any questions, please email Ray at rrussell@nyccfb.info.' },
            { status: 'Voter Registration at Fordham Plaza', date: 'Wed, October 4, 2023 | 10:30 AM - 7:00 PM', icon: PrimeIcons.ANDROID, color: '#3F51B5', description: 'This event corresponds with the NYC department of Education BEDS(Basic Education Data System) in which a large number of Voting eligible high school students will in the area. This is a great opportunity to register younger people and get them civically informed and involved. ' },
            { status: 'Transit Thursdays: Atlantic Terminal/Barclay’s Center', date: 'Thu, October 5, 2023 | 4:00 PM - 8:00 PM', icon: PrimeIcons.ARROWS_ALT, color: '#9E9E9E', description: 'Join us for Transit Thursday where we sign up voters at some of Pennsylvania busiest subway stations. Mid week is the perfect time to reach as many Pennsylvaniaers as possible. You will be signing up new voters and be providing key information about the upcoming November General Election.' },
            { status: 'Voter Registration at Highland Park', date: 'Sat, October 7, 2023 | 12:00 PM - 4:00 PM', icon: PrimeIcons.BITCOIN, color: '#795548', description: 'This beautiful location spans the Brooklyn and Queens boarders and will be a fun afternoon of registering new voters and providing key information to voters in advance of the November General Election. If you have any questions, please reach out to Ray at rrussell@nyccfb.info.' },
            { status: 'Voter Registration in South Brooklyn', date: 'Sat, October 14, 2023 | 12:00 PM - 4:00 PM', icon: PrimeIcons.CAMERA, color: '#FF5722', description: 'Thank you for signing up to take part in our South Brooklyn GOTV at Bensonhurst Park. You will be registering new voters and providing key information about the November Election.' },
            { status: 'Voter Registration at Graham Triangle, The Bronx', date: 'Tue, October 17, 2023 | 1:00 PM - 5:00 PM', icon: PrimeIcons.CHEVRON_CIRCLE_UP, color: '#FFC107', description: 'Come and join us as we register new voters and provide key voting information in advance of November General Election. ' }
        ];

        this.events2 = [
            "2020", "2021", "2022", "2023"
        ];
    }

}
