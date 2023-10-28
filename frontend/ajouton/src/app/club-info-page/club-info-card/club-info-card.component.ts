import { Component, Input } from '@angular/core';

export class ClubInfo {
	public isWish: boolean = false;
	public name: string = 'Unknown';
	public category: string[] = ['Unknown', 'Unknown', 'Unknown'];
	public description: string = 'This is description of club placeholder.';
	public image: string = 'Unknown';
}

@Component({
	selector: 'app-club-info-card',
	templateUrl: './club-info-card.component.html',
	styleUrls: ['./club-info-card.component.scss'],
})
export class ClubInfoCardComponent {
	@Input() public clubInfo: ClubInfo = new ClubInfo();

	public wishIcon: string = 'favorite_border';

	constructor() { }

	public ngOnInit(): void {
		this.wishIcon = this.clubInfo.isWish ? 'favorite' : 'favorite_border';
	}

	public onClickWishButton(): void {
		this.clubInfo.isWish = !this.clubInfo.isWish;
		this.wishIcon = (this.wishIcon === 'favorite_border') ? 'favorite' : 'favorite_border';
	}

}
