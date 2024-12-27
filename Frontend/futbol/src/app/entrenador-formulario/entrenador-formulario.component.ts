import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-entrenador-formulario',
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './entrenador-formulario.component.html',
  styleUrl: './entrenador-formulario.component.css',
})
export default class EntrenadorFormularioComponent {
  //injectamos el formulario
  private fb = inject(FormBuilder);


  form = this.fb.group({
    nombre: ['', [Validators.required]],
    apellido: ['', [Validators.required]],
    edad: ['', [Validators.required]],
    cedula: ['', [Validators.required]],
    nacionalidad: ['', [Validators.required]],
  });

  //

  crear(){
    console.log(this.form.value);
  }
}
