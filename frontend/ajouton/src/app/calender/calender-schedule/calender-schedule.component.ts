import { Component } from '@angular/core';

@Component({
	selector: 'app-calender-schedule',
	templateUrl: './calender-schedule.component.html',
	styleUrls: ['./calender-schedule.component.scss'],
})
export class CalenderScheduleComponent {
	public schedules: string[] = ['', '', '', '', '', '', '', ''];
	public isShowInformation: boolean[] = [false, false, false, false, false, false, false, false];

	public onHoverSchedule(index: number, isEnter: boolean): void {
		this.isShowInformation[index] = isEnter;
	}
}
