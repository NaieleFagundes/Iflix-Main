import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from '../models/categoria';

@Service()
export class CategoriaService {

     http:HttpClient = inject(HttpClient);
      url = 'http://localhost:8080/categoria';

    listarCategorias() : Observable<Categoria[]> {
       return this.http.get<Categoria[]>(this.url);
    }

    gravar( cat : Categoria ) : Observable<Categoria> {
      // se atualiza
      if( cat.idCategoria && cat.idCategoria > 0 ){
          return this.http.put<Categoria>( this.url, cat );  
      }
      // criacao
      return this.http.post<Categoria>( this.url, cat );
    }
    remover(cat : Categoria){
      this.http.delete(this.url, { body: cat }  );
    }
    buscaPorId(idCategoria:number) : Observable<Categoria> {
      return this.http.
      get<Categoria>(`${this.url}/${idCategoria}`);
    }
}

