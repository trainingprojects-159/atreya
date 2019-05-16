import { Doctor } from "./doctor";
import { Reporter } from "./reporter";

export class Leavereport {
    lrid: number;
    status: string;
    leave_details: string;
    doctor: Doctor;
    reporter: Reporter;
}