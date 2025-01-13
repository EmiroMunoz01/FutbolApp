import { inject, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule,
  FormsModule,
  FormControl,
} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ClubService } from '../servicios/club.service';
import { Club } from '../modelo/club.interface';
import { Entrenador } from '../modelo/entrenador.interface';
import { EntrenadorService } from '../servicios/entrenador.service';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-club-formulario',
  imports: [RouterModule, ReactiveFormsModule, FormsModule, CommonModule],
  templateUrl: './club-formulario.component.html',
  styleUrl: './club-formulario.component.css',
})
export default class ClubFormularioComponent implements OnInit {
  private fb = inject(FormBuilder);
  private clubServicio = inject(ClubService);
  private entrenadorServicio = inject(EntrenadorService);
  private router = inject(Router);
  private route = inject(ActivatedRoute);

  form?: FormGroup;
  clubValidador?: Club;
  entrenadorForm: FormGroup;

  entrenadores: Entrenador[] = [];
  entrenadorSeleccionado: Entrenador | undefined;
  entrenadorSeleccionBD: Entrenador | undefined;

  entrenadorOpcionPredeterminada: Entrenador | undefined;



  selectedOption: number | undefined;
  constructor(private http: HttpClient) {
    this.entrenadorForm = new FormGroup({ entrenador: new FormControl('') });
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');

    //usaremos estos datos para inicializar el formulario
    if (id) {
      this.entrenadorServicio.listar().subscribe((data) => {
        this.entrenadores = data;
      });

      this.entrenadorServicio
        .obtener(parseInt(id))
        .subscribe((valorSeleccionado) => {
          this.entrenadorOpcionPredeterminada = valorSeleccionado;
        });

      this.clubServicio.obtener(parseInt(id)).subscribe((club) => {
        this.clubValidador = club;

        this.form = this.fb.group({
          nombre: [club.nombre, [Validators.required]],
          paisOrigen: [club.paisOrigen, [Validators.required]],

          entrenadorBloqueado: [
            {
              value: club.entrenador.nombre + ' ' + club.entrenador.apellido,
              disabled: true,
            },
            [Validators.required],
          ],

          entrenadorCedula: [
            {
              value: club.entrenador.cedula_entrenador,
              disabled: true,
            },
            [Validators.required],
          ],
          opcionEntrenador: [''],
          entrenador: [club.entrenador.nombre, [Validators.required]],

          jugadores: [club.jugadores],
        });
      });

      //traemos el valor desde el backend

      const selectedOption = this.entrenadorOpcionPredeterminada;

      this.form?.get('opcionEntrenador')?.setValue(selectedOption);
    } else {
      this.entrenadorServicio.listar().subscribe((data) => {
        this.entrenadores = data;
      });

      this.form = this.fb.group({
        nombre: ['', [Validators.required]],
        paisOrigen: ['', [Validators.required]],
        entrenador: ['', [Validators.required]],
      });
    }
  }

  obtenerSeleccionDelBackend(id: number) {
    return this.entrenadorServicio
      .obtener(id)
      .subscribe((valorSeleccionado) => {
        this.entrenadorSeleccionBD = valorSeleccionado;
      });
  }

  guardar() {
    if (this.form?.invalid) {
      return;
    }

    const clubFormulario = this.form!.value;

    if (this.clubValidador) {
      this.clubServicio
        .actualizar(this.clubValidador.id, clubFormulario)
        .subscribe(() => {
          this.router.navigate(['/clubes']);
        });
    } else {
      this.clubServicio.crear(clubFormulario).subscribe(() => {
        this.router.navigate(['/clubes']);
      });
    }
  }
}
