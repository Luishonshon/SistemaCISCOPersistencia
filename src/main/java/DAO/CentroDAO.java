/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.centro.AgregarCentroDTO;
import DTO.centro.AgregarReglaDTO;
import DTO.centro.AsignarReglaCentroDTO;
import Dominio.Centro;
import Dominio.CentroRegla;
import Dominio.Computadora;
import Dominio.Regla;
import Interfaces.ICentroDAO;
import java.util.List;

/**
 *
 * @author LABCISCO-PC036
 */
public class CentroDAO implements ICentroDAO{

    @Override
    public Centro agregarCentro(AgregarCentroDTO nuevoCentro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Centro> buscarCentros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Centro BuscarCentroID(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Regla agregarRegla(AgregarReglaDTO nuevaRegla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Regla BuscarReglaId(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CentroRegla asignarRegla(AsignarReglaCentroDTO regla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Computadora> computadorasCentro(Centro centro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
