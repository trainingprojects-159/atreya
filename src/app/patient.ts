import { Doctor } from "./doctor";
import { Appointment } from "./appointment";

export class Patient {
    pid: string;
    pwd: string;
    pname: string;
    phnum: number;
    age: string;
    gender: string;
    report: string;
    doctor: Doctor;
    appointment: Appointment;
}