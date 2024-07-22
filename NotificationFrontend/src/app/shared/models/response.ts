import HttpStatusCode from "./http-status-code";
import { MessageType } from "./message-type";

export interface ResponseApp<T> {
    status: HttpStatusCode;
    message: string;
    messageType: MessageType;
    body: T;    
}