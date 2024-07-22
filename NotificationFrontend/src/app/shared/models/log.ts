import moment from 'moment';

export class Log {
    dateSent: Date;
    dateSentString: String;
    descCategory: string;
    descChannel: string;
    nameUser: string;
    descStatus: string;


    constructor(log: Log) {
        this.dateSent = log.dateSent;
        this.dateSentString = moment(log.dateSent).format('DD/MM/YYYY HH:mm'); ;
        this.descCategory = log.descCategory;
        this.descChannel = log.descChannel;
        this.nameUser = log.nameUser;
        this.descStatus = log.descStatus;
    }
}