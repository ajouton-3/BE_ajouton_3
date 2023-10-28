import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from 'src/material/material.module';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

/* 헤더 */
import { HeaderComponent } from './header/header.component';
import { SearchBarComponent } from './header/search-bar/search-bar.component';
import { CategorySheetComponent } from './header/search-bar/category-sheet/category-sheet.component';

import { MainPageComponent } from './main-page/main-page.component';
import { SearchResultPageComponent } from './search-result-page/search-result-page.component';
import { ClubInfoPageComponent } from './club-info-page/club-info-page.component';
import { AnnouncementPageComponent } from './announcement-page/announcement-page.component';
import { ActivityPageComponent } from './activity-page/activity-page.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { CalenderComponent } from './calender/calender.component';
import { CalenderScheduleComponent } from './calender/calender-schedule/calender-schedule.component';
import { ClubInfoCardComponent } from './club-info-page/club-info-card/club-info-card.component';
import { FilterSheetComponent } from './filter-sheet/filter-sheet.component';

import { ProfileService } from 'src/service/profile-service/profile-service';

@NgModule({
	declarations: [
		AppComponent,

		/* 헤더 */
		HeaderComponent,
		/* 검색 창 */
		SearchBarComponent,
		CategorySheetComponent,
		SearchResultPageComponent,
		MainPageComponent,
		ClubInfoPageComponent,
		AnnouncementPageComponent,
		ActivityPageComponent,
		ProfilePageComponent,
		CalenderComponent,
		CalenderScheduleComponent,
		ClubInfoCardComponent,
		FilterSheetComponent,
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		BrowserAnimationsModule,
		FormsModule,
		MaterialModule,
	],
	providers: [
		ProfileService,
	],
	bootstrap: [AppComponent]
})
export class AppModule { }
