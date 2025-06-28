/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTO.centro.AgregarCentroDTO;
import DTO.centro.AgregarReglaDTO;
import DTO.plantel.AgregarPlantelDTO;
import Dominio.Centro;
import Dominio.Computadora;
import Dominio.Plantel;
import Dominio.Regla;
import java.util.List;

/**
 *
 * @author LABCISCO-PC036
 */
public interface ICentroDAO {
    public Plantel agregarPlantel(AgregarPlantelDTO agregarPlantelDTO);
    public List<Plantel> planteles();
    public Plantel BuscarPlantelID(long id);
    public List<Centro> ListaCentroPlantel(Plantel plantel);
    public Centro agregarCentro(AgregarCentroDTO nuevoCentro);
    public List<Centro> buscarCentros();
    public Centro BuscarCentroID(Long Id);
    public Regla agregarRegla(AgregarReglaDTO nuevaRegla);
    public Regla BuscarReglaId(Long Id);
    public List<Computadora> computadorasCentro(Centro centro);

}
