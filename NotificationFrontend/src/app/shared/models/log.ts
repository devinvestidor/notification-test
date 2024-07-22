export class Log {
    dateSent: Date;
    descCategory: string;
    descChannel: string;
    nameUser: string;
    descStatus: string;


    constructor(log: Log) {
        this.dateSent = log.dateSent;
        this.descCategory = log.descCategory;
        this.descChannel = log.descChannel;
        this.nameUser = log.nameUser;
        this.descStatus = log.descStatus;
    }
}