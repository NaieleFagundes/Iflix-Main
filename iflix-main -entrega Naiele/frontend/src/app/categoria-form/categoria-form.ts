import { Component, signal, Signal } from "@angular/core";
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";

import { CategoriaService } from "../services/categoria-service";

@Component({
  imports: [ReactiveFormsModule],
  selector: "app-categoria-form",
  styleUrl: "./categoria-form.scss",
  templateUrl: "./categoria-form.html",
})
export class CategoriaForm {
  id?: number;
  msg = signal<String | null>(null);
  form = new FormGroup({
    nome: new FormControl("", Validators.required),
  });
  constructor(
    private router: ActivatedRoute,
    private servico: CategoriaService,
  ) {
    // pega da url o id
    const parametro = router.snapshot.paramMap.get("id");
    // somente existe parametro na edicao
    if (parametro) {
      // busco a categoria pelo id
      this.id = Number(parametro);
      servico.buscaPorId(this.id).subscribe((cat) => {
        this.form.patchValue(cat);
      });
    }
  }

  salvar() {
    if (this.form.invalid) {
      this.form.markAllAsTouched;
      // aborta a executar
      return;
    }
    console.log("salvando...");
    const categoria = {
      idCategoria: this.id,
      nome: this.form.value.nome!,
    };
    this.servico.gravar(categoria).subscribe((c) => {
      this.id = c.idCategoria;
      console.log(c);
      this.msg.set("Categoria salva com sucesso!");
    });
  }
}
