import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MainPageComponent } from './main-page/main-page.component';
import { SearchResultPageComponent } from './search-result-page/search-result-page.component';
import { ClubInfoPageComponent } from './club-info-page/club-info-page.component';
import { ActivityPageComponent } from './activity-page/activity-page.component';
import { AnnouncementPageComponent } from './announcement-page/announcement-page.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';

const routes: Routes = [
	{ path: '', component: MainPageComponent },
	{ path: 'search', component: SearchResultPageComponent },
	{ path: 'club-info', component: ClubInfoPageComponent },
	{ path: 'announcement', component: AnnouncementPageComponent },
	{ path: 'activity', component: ActivityPageComponent },
	{ path: 'profile', component: ProfilePageComponent },
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
