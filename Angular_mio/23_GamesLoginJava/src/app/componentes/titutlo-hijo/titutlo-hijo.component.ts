import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-titutlo-hijo',
  templateUrl: './titutlo-hijo.component.html',
  styleUrls: ['./titutlo-hijo.component.css']
})
export class TitutloHijoComponent implements OnInit {


  @Input() usuarioHijo : string = " Sin nombre"

  constructor() { }

  ngOnInit(): void {
  }

}
