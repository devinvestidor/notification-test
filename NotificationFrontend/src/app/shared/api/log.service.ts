import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

import { DefaultService } from "./default.service";
import { Observable } from "rxjs";
import { Log } from "../models/log";
import { ResponseApp } from "../models/response";

@Injectable({
    providedIn: "root"
})
export class LogService extends DefaultService {
    constructor(private http: HttpClient) {
        super("log");
    }

    listAll() : Observable<ResponseApp<Log[]>> {
        return this.http.get<ResponseApp<Log[]>>(`${this.url}`);
    }

}
