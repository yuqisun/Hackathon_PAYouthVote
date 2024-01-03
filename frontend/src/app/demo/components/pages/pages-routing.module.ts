import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
    imports: [RouterModule.forChild([
        { path: 'crud', loadChildren: () => import('./crud/crud.module').then(m => m.CrudModule) },
        { path: 'vote', loadChildren: () => import('./vote/vote.module').then(m => m.VoteModule) },
        { path: 'empty', loadChildren: () => import('./empty/emptydemo.module').then(m => m.EmptyDemoModule) },
        { path: 'timeline', loadChildren: () => import('./timeline/timelinedemo.module').then(m => m.TimelineDemoModule) },
        { path: 'point', loadChildren: () => import('./point/point.module').then(m => m.PointModule) },
        { path: 'award', loadChildren: () => import('./award/award.module').then(m => m.AwardModule) },
        { path: 'usage', loadChildren: () => import('./usage/usage.module').then(m => m.UsageModule) },
        { path: 'contactus', loadChildren: () => import('./contactus/contactus.module').then(m => m.ContactusModule) },
        { path: 'mailbox', loadChildren: () => import('./mailbox/mailbox.module').then(m => m.MailboxModule) },
        { path: '**', redirectTo: '/notfound' }
    ])],
    exports: [RouterModule]
})
export class PagesRoutingModule { }
