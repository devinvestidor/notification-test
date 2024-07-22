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
        super("log");
    }

    listAll() : Observable<ResponseApp<Log>> {
        return this.http.get<ResponseApp<Log>>(`${this.url}`);
    }

}
