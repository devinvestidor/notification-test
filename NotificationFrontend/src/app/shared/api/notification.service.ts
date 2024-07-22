import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

import { DefaultService } from "./default.service";
import { ResponseApp } from "../models/response";


@Injectable({
    providedIn: "root"
})
export class NotificationService extends DefaultService {
    constructor(private http: HttpClient) {
        super("notification");
    }

    send(notification: any) : Observable<ResponseApp<any>> {
        return this.http.post<ResponseApp<any>>(`${this.url}`, notification);
    }
}
