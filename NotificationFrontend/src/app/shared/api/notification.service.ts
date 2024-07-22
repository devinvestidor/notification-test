import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

import { DefaultService } from "./default.service";
import { Observable } from "rxjs";
import { Log } from "../models/Log";
import { ResponseApp } from "../models/Response";

@Injectable({
    providedIn: "root"
})
export class PatientPortalService extends DefaultService {
    constructor(private http: HttpClient) {
        super("notification");
    }



    send(filter: Notification) : Observable<ResponseApp<any>> {
        return this.http.post<ResponseApp<any>>(`${this.url}`, filter);
    }

}
