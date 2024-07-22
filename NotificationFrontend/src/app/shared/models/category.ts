export class Category {
    id: number;
    description: string;

    constructor(category: Category) {
        this.id = category.id;
        this.description = category.description;
    }
}