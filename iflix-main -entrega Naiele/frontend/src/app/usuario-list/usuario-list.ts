import { Component, inject, Inject, signal } from "@angular/core";
import { UsuarioService } from "../services/usuario-service";
import { Usuario } from "../models/usuario";

@Component({
  imports: [],
  selector: "app-usuario-list",
  templateUrl: "./usuario-list.html",
})
export class UsuarioList {
  // arquivo que controla o html
  usuarios = signal<Usuario[]>([]);
  erro = signal<string | null>(null);

  constructor(private servicoUsu: UsuarioService) {
    this.carregarUsuarios();
  }

  carregarUsuarios() {
    this.servicoUsu.listarUsuarios().subscribe((lista) => {
      this.usuarios.set(lista);
    });
  }

  //serviços
  excluir(id: number | undefined): void {
    if (id === undefined) {
      this.erro.set("Não foi possível identificar o usuário.");
      return;
    }

    this.servicoUsu.excluir(id).subscribe({
      next: () => this.carregarUsuarios(),
      error: () => this.erro.set("Não foi possível excluir usuário."),
    });
  }
}
