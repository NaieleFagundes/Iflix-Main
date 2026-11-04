import { HttpClient } from "@angular/common/http";
import { inject, Service } from "@angular/core";
import { Observable } from "rxjs";
import { Usuario } from "../models/usuario";

@Service()
export class UsuarioService {
  http: HttpClient = inject(HttpClient);
  url = "http://localhost:8080/usuario";

  listarUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.url);
  }

  cadastrar(usuario: Usuario): Observable<Usuario> {
    // criacao
    return this.http.post<Usuario>(this.url, usuario);
  }

  atualizar(id: number, usuario: Usuario): Observable<Usuario> {
    return this.http.put<Usuario>(`${this.url}/${id}`, usuario);
  }
  buscaPorId(idUsuario: number): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.url}/${idUsuario}`);
  }

  excluir(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
