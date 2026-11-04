import { Routes } from "@angular/router";
import { CategoriaList } from "./categoria-list/categoria-list";
import { CategoriaForm } from "./categoria-form/categoria-form";
import { UsuarioList } from "./usuario-list/usuario-list";
import { UsuarioForm } from "./usuario-form/usuario-form";
export const routes: Routes = [
  {
    path: "",
    component: CategoriaList,
  },
  {
    path: "categoria",
    component: CategoriaForm,
  },
  {
    path: "categoria/:id",
    component: CategoriaForm,
  },

  {
    path: "usuarios",
    component: UsuarioList,
  },
  {
    path: "usuario",
    component: UsuarioForm,
  },
  {
    path: "usuario/:id",
    component: UsuarioForm,
  },
];
