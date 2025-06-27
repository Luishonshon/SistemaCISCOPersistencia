/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTO.alumnos.AgregarAlumnoDTO;
import DTO.alumnos.AgregarCarreraDTO;
import DTO.alumnos.BloquearAlumnoDTO;
import DTO.alumnos.BuscarAlumnoDTO;
import DTO.alumnos.ConfirmarAlumnoDTO;
import Dominio.Alumno;
import Dominio.Bloqueo;
import Dominio.Carrera;
import java.util.List;

/**
 *
 * @author LABCISCO-PC036
 */
public interface IAlumnoDAO {
    public Carrera agregarCarrera(AgregarCarreraDTO nuevaCarrera);
    public Carrera buscarCarreraID(Long Id);
    public Alumno agregarAlumno(AgregarAlumnoDTO alumnoNuevo);
    public Alumno iniciarSesion(ConfirmarAlumnoDTO alumnoSesion);
    public Bloqueo bloquearAlumno(BloquearAlumnoDTO nuevoBloqueo);
    public List<Bloqueo> Bloqueos();
    public Bloqueo BuscarBloqueoId(Long id);
    public Alumno Buscar(BuscarAlumnoDTO alumno);
    public List<Alumno> BuscarAlumnos();
    public List<Carrera>  ListaCarreras();

}
