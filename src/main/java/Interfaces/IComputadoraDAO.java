/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTO.computadoras.ActualizarEstadoComputadoraDTO;
import DTO.computadoras.AgregarComputadoraDTO;
import DTO.reservas.GuardarReservaDTO;
import DTO.software.AgregarSoftwareDTO;
import DTO.software.InstalarSoftwareDTO;
import Dominio.Computadora;
import Dominio.Instalacion;
import Dominio.Reservacion;
import Dominio.Software;
import java.util.List;

/**
 *
 * @author LABCISCO-PC036
 */
public interface IComputadoraDAO {
    public Computadora agregarComputadora(AgregarComputadoraDTO nuevacomputadora);
    public Computadora buscarComputadoraId(Long Id);
    public Computadora actualizarEstado(ActualizarEstadoComputadoraDTO actualizarEstado);
    public Reservacion reservarComputadora(GuardarReservaDTO nuevaReservacion);
    public Reservacion buscarReservacionId(Long Id);
    public List<Instalacion> softwareInstalado(Long idComputadora);
    public Software agregarSoftware(AgregarSoftwareDTO nuevoSoftware);
    public Software BuscarSoftware(Long Id);
    public Instalacion InstalarSoftware(InstalarSoftwareDTO nuevoSoftwareDTO);

}
