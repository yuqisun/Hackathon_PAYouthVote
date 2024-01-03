import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
    imports: [RouterModule.forChild([
        { path: 'ballotproposals', loadChildren: () => import('./ballotproposals/ballotproposals.module').then(m => m.BallotproposalsModule) },
        { path: 'stake', loadChildren: () => import('./stake/stake.module').then(m => m.StakeModule) },
        { path: 'vote', loadChildren: () => import('./vote/vote.module').then(m => m.VoteModule) },
        { path: 'votemail', loadChildren: () => import('./votemail/votemail.module').then(m => m.VotemailModule) },
        { path: 'represent', loadChildren: () => import('./represent/represent.module').then(m => m.RepresentModule) },
        { path: 'location', loadChildren: () => import('./location/location.module').then(m => m.LocationModule) },
        { path: '**', redirectTo: '/notfound' }
    ])],
    exports: [RouterModule]
})
export class VoteServiceRoutingModule { }
