import { User } from "../User/user";

export class Event {

    eventName: string = "";
    eventLocation: string = "";
    eventPrice: string = "";
    organizer: User = new User();
    configuration: any = {};

}
