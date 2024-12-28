import { Component, inject, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { EntrenadorService } from '../servicios/entrenador.service';
import { Entrenador } from '../modelo/entrenador.interface';

@Component({
  selector: 'app-entrenador-formulario',
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './entrenador-formulario.component.html',
  styleUrl: './entrenador-formulario.component.css',
})
export default class EntrenadorFormularioComponent implements OnInit {
  //inyectamos el formulario
  private fb = inject(FormBuilder);
  //inyectamos el servicio, por medio de la inyeccion de dependencias
  private entrenadorServicio = inject(EntrenadorService);

  private router = inject(Router);
  private route = inject(ActivatedRoute);

  // form = this.fb.group({
  //   nombre: ['', [Validators.required]],
  //   apellido: ['', [Validators.required]],
  //   edad_entrenador: ['', [Validators.required]],
  //   cedula_entrenador: ['', [Validators.required]],
  //   nacionalidad: ['', [Validators.required]],
  // });

  form?: FormGroup;
  entrenadorValidador?: Entrenador;

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');

    //usaremos estos datos para inicializar el formulario
    if (id) {
      this.entrenadorServicio.obtener(parseInt(id)).subscribe((entrenador) => {
        this.entrenadorValidador = entrenador;

        this.form = this.fb.group({
          nombre: [entrenador.nombre, [Validators.required]],
          apellido: [entrenador.apellido, [Validators.required]],
          edad_entrenador: [entrenador.edad_entrenador, [Validators.required]],
          cedula_entrenador: [
            entrenador.cedula_entrenador,
            [Validators.required],
          ],
          nacionalidad: [entrenador.nacionalidad, [Validators.required]],
        });
      });
    } else {
      this.form = this.fb.group({
        nombre: ['', [Validators.required]],
        apellido: ['', [Validators.required]],
        edad_entrenador: ['', [Validators.required]],
        cedula_entrenador: ['', [Validators.required]],
        nacionalidad: ['', [Validators.required]],
      });
    }
  }

  guardar() {
    if (this.form?.invalid) {
      return;
    }

    const entrenadorFormulario = this.form!.value;
    //llamaremos el servicio

    if (this.entrenadorValidador) {
      this.entrenadorServicio
        .actualizar(this.entrenadorValidador.id, entrenadorFormulario)
        .subscribe(() => {
          this.router.navigate(['/entrenadores']);
        });
    } else {
      this.entrenadorServicio.crear(entrenadorFormulario).subscribe(() => {
        this.router.navigate(['/entrenadores']);
      });
    }
  }
}
