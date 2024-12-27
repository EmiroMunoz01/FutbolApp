import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { EntrenadorService } from '../servicios/entrenador.service';

@Component({
  selector: 'app-entrenador-formulario',
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './entrenador-formulario.component.html',
  styleUrl: './entrenador-formulario.component.css',
})
export default class EntrenadorFormularioComponent {
  //inyectamos el formulario
  private fb = inject(FormBuilder);
  //inyectamos el servicio, por medio de la inyeccion de dependencias
  private entrenadorServicio = inject(EntrenadorService);

  private router = inject(Router);

  form = this.fb.group({
    nombre: ['', [Validators.required]],
    apellido: ['', [Validators.required]],
    edad_entrenador: ['', [Validators.required]],
    cedula_entrenador: ['', [Validators.required]],
    nacionalidad: ['', [Validators.required]],
  });

  //

  crear() {
    const entrenador = this.form.value;
    //llamaremos el servicio
    this.entrenadorServicio.crear(entrenador).subscribe(() => {
      this.router.navigate(['/entrenadores']);
    });
  }
}
