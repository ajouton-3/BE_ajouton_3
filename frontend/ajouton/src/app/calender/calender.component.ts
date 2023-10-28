import { Component } from '@angular/core';

@Component({
	selector: 'app-calender',
	templateUrl: './calender.component.html',
	styleUrls: ['./calender.component.scss']
})
export class CalenderComponent {
	daysInMonth: number[] = new Array(42).map(() => 0);

	currentDay: number = new Date().getDay();
	currentDate: number = new Date().getDate();
	currentYear: number = new Date().getFullYear();
	currentMonth: number = new Date().getMonth() + 1;
	currentLastDate: number = new Date(this.currentYear, this.currentMonth, 0).getDate();

	constructor() {
		this.generateCalendar(this.currentYear, this.currentMonth);
	}

	public onClickPrevMonth(): void {
		if (this.currentMonth === 1) {
			this.currentMonth = 12;
			--this.currentYear;
		} else {
			--this.currentMonth;
		}
		this.generateCalendar(this.currentYear, this.currentMonth);
	}

	public onClickNextMonth(): void {
		if (this.currentMonth === 12) {
			this.currentMonth = 1;
			++this.currentYear;
		} else {
			++this.currentMonth;
		}
		this.generateCalendar(this.currentYear, this.currentMonth);
	}

	public generateCalendar(year: number, month: number) {
		const firstDay = new Date(year, month - 1, 1).getDay();
		this.currentLastDate = new Date(year, month, 0).getDate();

		this.daysInMonth.fill(0);
		for (let i = firstDay; i < this.currentLastDate + firstDay; ++i) {
			this.daysInMonth[i] = i - firstDay + 1;
		}
	}

	public getIsWeekend(date: number): boolean {
		if (date === 0) { return false; }
		const day = new Date(this.currentYear, this.currentMonth - 1, date).getDay();
		return (day === 0 || day === 6);
	}
}
