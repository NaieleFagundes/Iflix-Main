import { Component, signal, Signal } from "@angular/core";
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { Usuario } from "../models/usuario";
import { UsuarioService } from "../services/usuario-service";

@Component({
  imports: [ReactiveFormsModule],
  selector: "app-usuario-form",
  templateUrl: "./usuario-form.html",
})
export class UsuarioForm {
  id?: number;
  msg = signal<String | null>(null);
  form = new FormGroup({
    nome: new FormControl("", Validators.required),
    email: new FormControl("", Validators.required),
    senha: new FormControl("", Validators.required),
    tipo: new FormControl<"ADMIN" | "COMUM">("COMUM", Validators.required),
  });

  constructor(
    private router: ActivatedRoute,
    private servico: UsuarioService,
  ) {
    // pega da url o id
    const parametro = router.snapshot.paramMap.get("id");
    // somente existe parametro na edicao
    if (parametro) {
      // busco a categoria pelo id
      this.id = Number(parametro);
      servico.buscaPorId(this.id).subscribe((usuario) => {
        this.form.patchValue(usuario);
      });
    }
  }

  salvar() {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      // aborta a executar
      return;
    }

    console.log("salvando...");
    const usuario = {
      idUsuario: this.id,
      nome: this.form.value.nome!,
      email: this.form.value.email!,
      senha: this.form.value.senha!,
      tipo: this.form.value.tipo!,
    };
    //conferir
    const operacao =
      this.id !== undefined
        ? this.servico.atualizar(this.id, usuario)
        : this.servico.cadastrar(usuario);

    operacao.subscribe((u) => {
      this.id = u.idUsuario;
      this.msg.set("Usuário salvo com sucesso!");
    });
  }
}
