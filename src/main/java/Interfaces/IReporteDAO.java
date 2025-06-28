/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTO.reportes.FiltroReporteCarrera;
import DTO.reportes.FiltroReporteCentro;
import DTO.reportes.ReporteCarrerasDTO;
import DTO.reportes.ReporteCentroDTO;
import java.util.List;

/**
 *
 * @author santi
 */
public interface IReporteDAO {
    public List<ReporteCarrerasDTO> generarReporte(FiltroReporteCarrera filtro);
    
    public List<ReporteCentroDTO> generarReporteCentro(FiltroReporteCentro filtro);
}
