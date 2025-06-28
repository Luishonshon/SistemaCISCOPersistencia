/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemaciscopersistencia;
import Interfaces.*;
import DAO.*;
import Dominio.*;
import DTO.alumnos.*;
import DTO.centro.*;
import DTO.computadoras.*;
import DTO.reportes.*;
import DTO.reservas.*;
import DTO.software.*;
/**
 *
 * @author luishonshon
 */
public class SistemaCISCOPersistencia {

    public static void main(String[] args) {
        IAlumnoDAO alumnoDAO = new AlumnoDAO();
        Carrera carrera1 = alumnoDAO.agregarCarrera(
                new AgregarCarreraDTO(
                "Ingeniería en Software	",
                300,
                "5538219476"
                ));
        Alumno alumno = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Valeria", 
                        "Sánchez", 
                        "Ramírez", 
                        "kF72pQx1Zt", 
                        true, 
                        carrera1)
                );
    }
}
