import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class ProfileService {
	public userName: string = 'Unknown';
	public studentId: string = '000000000';
	public department: string = 'Software';
	public phoneNumber: string = '010-0000-0000';

	constructor() {

	}
}
