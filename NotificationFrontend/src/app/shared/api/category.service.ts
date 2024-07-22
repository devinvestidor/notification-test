import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

import { DefaultService } from "./default.service";
import { Observable } from "rxjs";
import { Category } from "../models/category";
import { ResponseApp } from "../models/response";


@Injectable({
    providedIn: "root",    
})
export class CategoryService extends DefaultService {
    constructor(private http: HttpClient) {
        super("category");
    }

    listAll() : Observable<ResponseApp<Category[]>> {
        return this.http.get<ResponseApp<Category[]>>(`${this.url}`);
    }
}
