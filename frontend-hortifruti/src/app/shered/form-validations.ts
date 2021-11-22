import { AbstractControl, Validators } from "@angular/forms";

export class FormValidations {
    constructor() { }

    
    static isValidCpf() {
        console.log("chamando funcao");
        return (control: AbstractControl): Validators =>{
            const cpf = control.value;
            if(cpf){
                let numbers, digits, i, result, equalDigits = 1;
                if(cpf.length < 11){
                    return '';
                }
                for (i = 0; i < cpf.length - 1; i++) {
                    if (cpf.charAt(i) !== cpf.charAt(i + 1)) {
                      equalDigits = 0;
                      break;
                    }
                  }
            }
            return '';
        }
        
    }    
}
