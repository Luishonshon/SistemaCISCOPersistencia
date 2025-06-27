/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.computadoras.ActualizarEstadoComputadoraDTO;
import DTO.computadoras.AgregarComputadoraDTO;
import DTO.reservas.GuardarReservaDTO;
import DTO.software.AgregarSoftwareDTO;
import DTO.software.InstalarSoftwareDTO;
import Dominio.Computadora;
import Dominio.Instalacion;
import Dominio.Reservacion;
import Dominio.Software;
import Interfaces.IComputadoraDAO;
import java.util.List;

/**
 *
 * @author LABCISCO-PC036
 */
public class ComputadoraDAO implements IComputadoraDAO {

    @Override
    public Computadora agregarComputadora(AgregarComputadoraDTO nuevacomputadora) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Computadora buscarComputadoraId(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Computadora actualizarEstado(ActualizarEstadoComputadoraDTO actualizarEstado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reservacion reservarComputadora(GuardarReservaDTO nuevaReservacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reservacion buscarReservacionId(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Instalacion> softwareInstalado(Long idComputadora) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Software agregarSoftware(AgregarSoftwareDTO nuevoSoftware) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Software BuscarSoftware(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Instalacion InstalarSoftware(InstalarSoftwareDTO nuevoSoftwareDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
