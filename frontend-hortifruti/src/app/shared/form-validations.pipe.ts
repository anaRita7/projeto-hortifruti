import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'formValidations'
})
export class FormValidationsPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
