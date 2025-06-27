/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.alumnos.AgregarAlumnoDTO;
import DTO.alumnos.AgregarCarreraDTO;
import DTO.alumnos.BloquearAlumnoDTO;
import DTO.alumnos.BuscarAlumnoDTO;
import DTO.alumnos.ConfirmarAlumnoDTO;
import Dominio.Alumno;
import Dominio.Bloqueo;
import Dominio.Carrera;
import Interfaces.IAlumnoDAO;
import java.util.List;

/**
 *
 * @author LABCISCO-PC036
 */
public class AlumnoDAO implements IAlumnoDAO {

    @Override
    public Carrera agregarCarrera(AgregarCarreraDTO nuevaCarrera) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Carrera buscarCarreraID(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Alumno agregarAlumno(AgregarAlumnoDTO alumnoNuevo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Alumno iniciarSesion(ConfirmarAlumnoDTO alumnoSesion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Bloqueo bloquearAlumno(BloquearAlumnoDTO nuevoBloqueo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Bloqueo> Bloqueos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Bloqueo BuscarBloqueoId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Alumno Buscar(BuscarAlumnoDTO alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> BuscarAlumnos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Carrera> ListaCarreras() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
