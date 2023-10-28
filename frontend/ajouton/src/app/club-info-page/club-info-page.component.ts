import { Component } from '@angular/core';

import { ClubInfo } from './club-info-card/club-info-card.component';
import { MatBottomSheet } from '@angular/material/bottom-sheet';
import { FilterSheetComponent, OrderType } from '../filter-sheet/filter-sheet.component';
import { SearchBarChipType } from '../header/search-bar/category-sheet/category-sheet.component';

@Component({
	selector: 'app-club-info-page',
	templateUrl: './club-info-page.component.html',
	styleUrls: ['./club-info-page.component.scss']
})
export class ClubInfoPageComponent {
	public readonly chips: string[] = Object.values(SearchBarChipType).filter((key) => isNaN(Number(key)));
	public clubs: ClubInfo[] = Array.from({ length: 10 }, () => new ClubInfo());
	public isEnableChips: boolean[] = this.chips.map(() => false);
	public firstEnabledChip: string | undefined = undefined;
	public enabledChipCount: string = '';
	public orderType: OrderType = OrderType.Dictionary;

	constructor(private readonly _matBottomSheet: MatBottomSheet) {
		this.clubs[0].name = '동아리1';
		this.clubs[1].name = '동아리3';
		this.clubs[6].name = '동아리2';
		this.clubs[3].isWish = true;
		this.clubs[6].isWish = true;
		console.log(this.clubs);

		this.updateClubs();
	}

	public onClickFilterButton(): void {
		this._matBottomSheet.open(FilterSheetComponent, {
			data: {
				parent: this,
				isEnableChips: this.isEnableChips,
				orderType: this.orderType,
			}
		})
	}

	public updateClubs(): void {
		const clubs = [...this.clubs];

		switch (this.orderType) {
			case OrderType.Dictionary: {
				this.clubs = clubs.sort((a, b) => a.name.localeCompare(b.name));
			} break;
			case OrderType.Wish: {
				this.clubs = clubs.sort((a, b) => b.isWish ? 1 : -1);
			} break;
		}
	}

	public onChangeOrderType(type: OrderType): void {
		this.orderType = type;
		this.updateClubs();
	}

	public onChangeIsEnableChips(isEnableChips: boolean[]): void {
		this.isEnableChips = [...isEnableChips];

		this.firstEnabledChip = this.chips.find((chip) => this.isEnableChips[this.chips.indexOf(chip)]);
		const enabledChipCount: number = this.isEnableChips.filter((isEnableChip) => isEnableChip).length;

		if (enabledChipCount <= 1) {
			this.enabledChipCount = '';
		} else {
			this.enabledChipCount = ` 외 ${this.isEnableChips.filter((isEnableChip) => isEnableChip).length}개 선택됨`
		}
	}
}
