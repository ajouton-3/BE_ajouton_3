import { Component, Inject } from '@angular/core';
import { MAT_BOTTOM_SHEET_DATA } from '@angular/material/bottom-sheet';

import { SearchBarChipType } from '../header/search-bar/category-sheet/category-sheet.component';

export enum OrderType {
	Dictionary,
	Wish,
}

@Component({
	selector: 'app-filter-sheet',
	templateUrl: './filter-sheet.component.html',
	styleUrls: ['./filter-sheet.component.scss'],
})
export class FilterSheetComponent {
	public readonly chips: string[] = Object.values(SearchBarChipType).filter((key) => isNaN(Number(key)));
	public readonly orderType = OrderType;

	constructor(
		@Inject(MAT_BOTTOM_SHEET_DATA) public readonly data: {
			parent: any,
			isEnableChips: boolean[],
			orderType: OrderType,
		}) {

	}

	public onChangeOrderType(): void {
		this.data.parent.onChangeOrderType(this.data.orderType);
	}

	public onChangeChips(index: number): void {
		this.data.isEnableChips[index] = !this.data.isEnableChips[index];
		this.data.parent.onChangeIsEnableChips(this.data.isEnableChips);
	}

	public onClickResetButton(): void {
		this.data.isEnableChips = this.data.isEnableChips.map(() => false);
		this.data.parent.onChangeIsEnableChips(this.data.isEnableChips);
		this.data.orderType = OrderType.Dictionary;
		this.data.parent.onChangeOrderType(this.data.orderType);
	}

}
