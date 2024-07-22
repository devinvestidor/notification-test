import { environment } from "@env/environment";

export abstract class DefaultService {
    protected url: string;
    protected resource = '';    

    constructor(resource: string) {
        this.url = `${environment.url}${resource}`;
    }
}
