import { Component, EventEmitter, Output, HostListener } from '@angular/core';
import { Router } from '@angular/router';
import { MatBottomSheet } from '@angular/material/bottom-sheet';

import { CategorySheetComponent } from './category-sheet/category-sheet.component';
import { SearchBarChipType } from './category-sheet/category-sheet.component';

@Component({
	selector: 'app-search-bar',
	templateUrl: './search-bar.component.html',
	styleUrls: ['./search-bar.component.scss'],
})
export class SearchBarComponent {
	@Output() private readonly _searchEventEmitter = new EventEmitter<void>();

	public readonly chips: string[] = Object.values(SearchBarChipType).filter((key) => isNaN(Number(key)));
	public isEnableChips: boolean[] = this.chips.map(() => false);
	public firstEnabledChip: string | undefined = undefined;
	public enabledChipCount: string = '';
	public isFocus: boolean = false;

	constructor(
		private readonly _router: Router,
		private readonly _matBottomSheet: MatBottomSheet) {

	}

	public onClickCategoryButton(): void {
		this._matBottomSheet.open(CategorySheetComponent, {
			data: {
				parent: this,
				isEnableChips: this.isEnableChips,
			}
		});
	}

	public onClickSearchButton(): void {
		this._searchEventEmitter.emit();
		this._router.navigate(['search']);
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

	@HostListener('window:keydown.enter')
	public onKeydownEnter(): void {
		if (this.isFocus) { this.onClickSearchButton(); }
	}

}
