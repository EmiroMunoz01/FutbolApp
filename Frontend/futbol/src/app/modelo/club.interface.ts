//crearemos la estructura que trae la respuesta de crear contacto

import { Entrenador } from "./entrenador.interface";

export interface Club {
  id: number;
  nombre: string;
  paisOrigen: string;
  entrenador: Entrenador;
  jugadores: string;
  fechaCreacionSistema: string;
}
