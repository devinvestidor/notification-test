import { Category } from "./category";

export class Notification {
    category: Category;
    message: string;

    constructor(notification: Notification) {
        this.category = notification.category;
        this.message = notification.message;
    }
}