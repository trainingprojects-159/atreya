import { Appointment } from "./appointment";
import { Doctor } from "./doctor";

export class Patient {
    pid:string;
    pwd:string;
    pname:string;
    phnum:number;
    age:string;
    gender:string;
    report:string;
    appointment:Appointment;
    doctor:Doctor;
}
