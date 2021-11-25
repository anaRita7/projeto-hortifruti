import { Component, OnInit, Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';

@Component({
  selector: 'app-tax-invoice',
  templateUrl: './tax-invoice.component.html',
  styleUrls: ['./tax-invoice.component.css']
})
export class TaxInvoiceComponent implements OnInit {

  constructor(@Inject(DOCUMENT) private document: Document) { }

  ngOnInit(): void {
    (this.document.querySelector('.modal-backdrop') as Element).classList.remove('show')
  }
}
