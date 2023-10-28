import { Component, Inject } from '@angular/core';
import { MAT_BOTTOM_SHEET_DATA } from '@angular/material/bottom-sheet';

import { SearchBarComponent } from '../search-bar.component';

export enum SearchBarChipType {
	Sport = '운동',
	Food = '음식',
	Book = '독서',
	Study = '공부',
	Music = '음악',
	Dance = '댄스',
	Friendship = '친목',
	Service = '봉사',
	Art = '미술',
	Act = '연극',
	Theater = '영화',
	Travel = '여행',
	Development = '개발',
	Game = '게임',
}

@Component({
	selector: 'app-category-sheet',
	templateUrl: './category-sheet.component.html',
	styleUrls: ['./category-sheet.component.scss'],
})
export class CategorySheetComponent {
	public readonly chips: string[] = Object.values(SearchBarChipType).filter((key) => isNaN(Number(key)));

	constructor(
		@Inject(MAT_BOTTOM_SHEET_DATA) public readonly data: {
			parent: SearchBarComponent,
			isEnableChips: boolean[],
		}) {

	}

	public onChangeChips(index: number): void {
		this.data.isEnableChips[index] = !this.data.isEnableChips[index];
		this.data.parent.onChangeIsEnableChips(this.data.isEnableChips);
	}

	public onClickResetButton(): void {
		this.data.isEnableChips = this.data.isEnableChips.map(() => false);
		this.data.parent.onChangeIsEnableChips(this.data.isEnableChips);
	}

}
