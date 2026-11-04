import { Component, inject, Inject, signal } from '@angular/core';
import { CategoriaService } from '../services/categoria-service';
import { Categoria } from '../models/categoria';

@Component({
  imports: [],
  selector: 'app-categoria-list',
  styleUrl: './categoria-list.scss',
  templateUrl: './categoria-list.html',
})
export class CategoriaList  {
  // arquivo que controla o html
  categorias =  signal<Categoria[]>([])  ; 

  constructor( private servico : CategoriaService ){
    this.carregarCategorias();
  }
  
  carregarCategorias(){
    this.servico.listarCategorias().subscribe( (lista)=>{
      this.categorias.set(lista);
    } ) ;
  }
}
