import { Component } from '@angular/core';
import { state, style, trigger } from '@angular/animations';
import { Router } from '@angular/router';
import { ProfileService } from 'src/service/profile-service/profile-service';

enum PageType {
	ClubInfo,
	Announcement,
	Activity,
	Profile,
}

@Component({
	selector: 'app-header',
	templateUrl: './header.component.html',
	styleUrls: ['./header.component.scss'],
	animations: [
		trigger('colorChangeAnim', [
			state('true', style({ color: '#1A8CFF' })),
			state('false', style({ color: 'inherit' })),
		]),
	],
})
export class HeaderComponent {
	public readonly isSelectPage: boolean[] = Object.keys(PageType).filter((key) => isNaN(Number(key))).map(() => false);
	public readonly pageType = PageType;

	constructor(
		private readonly _router: Router,
		public readonly profile: ProfileService) {

	}

	public onClickLogo(): void {
		this.isSelectPage.fill(false);
		this._router.navigate(['']);
	}

	public onClickPage(pageType: PageType): void {
		this.isSelectPage.fill(false);
		this.isSelectPage[pageType] = true;

		const pageUrl = ['club-info', 'announcement', 'activity', 'profile'];
		this._router.navigate([pageUrl[pageType]]);
	}

	public onSearch(): void {
		this.isSelectPage.fill(false);
	}
}
