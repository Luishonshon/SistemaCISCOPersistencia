/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.reportes.FiltroReporteCarrera;
import DTO.reportes.FiltroReporteCentro;
import DTO.reportes.ReporteCarrerasDTO;
import DTO.reportes.ReporteCentroDTO;
import Interfaces.IReporteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author santi
 */
public class ReporteDAO implements IReporteDAO{

    @Override
    public List<ReporteCarrerasDTO> generarReporte(FiltroReporteCarrera filtro) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        
        List<ReporteCarrerasDTO> resultados = entityManager.createQuery(
            "SELECT ReporteCarrerasDTO( " +
            "c.nombre, " +
            "SUM(FUNCTION('TIMESTAMPDIFF', MINUTE, r.fechaInicio, r.fechaFin)), " +
            "COUNT(DISTINCT r.alumno), " +
            "CAST(r.fechaInicio AS DATE)) " +
            "FROM Reservacion r " +
            "JOIN r.alumno a " +
            "JOIN a.carrera c " +
            "WHERE CAST(r.fechaInicio AS DATE) BETWEEN :inicio AND :fin " +
            "AND (:carrera IS NULL OR c = :carrera) " +
            "GROUP BY c.nombre, CAST(r.fechaInicio AS DATE)", ReporteCarrerasDTO.class)
            .setParameter("inicio", filtro.getFechaInicio())
            .setParameter("fin", filtro.getFechaFin())
            .setParameter("carrera", filtro.getCarrera())
            .getResultList();

        int inicio = Math.min(filtro.getOffset(), resultados.size());
        int fin = Math.min(filtro.getOffset() + filtro.getLimit(), resultados.size());

        return resultados.subList(inicio, fin);
    }

    @Override
    public List<ReporteCentroDTO> generarReporteCentro(FiltroReporteCentro filtro) {
        EntityManager entityManager = Persistence
        .createEntityManagerFactory("ConexionJPA")
        .createEntityManager();

        TypedQuery<ReporteCentroDTO> query = entityManager.createQuery(
            "SELECT NEW ReporteCentroDTO( " +
            "centro.nombre, " +
            "COUNT(DISTINCT r.computadora), " +
            "COUNT(DISTINCT r.alumno), " +
            "SUM(FUNCTION('TIMESTAMPDIFF', MINUTE, r.fechaInicio, r.fechaFin)), " +
            "CAST(r.fechaInicio AS DATE)) " +
            "FROM Reservacion r " +
            "JOIN r.computadora comp " +
            "JOIN comp.centro centro " +
            "JOIN r.alumno a " +
            "WHERE CAST(r.fechaInicio AS DATE) BETWEEN :fechaInicio AND :fechaFin " +
            "AND (:centro IS NULL OR comp.centro = :centro) " +
            "AND (:carrera IS NULL OR a.carrera = :carrera) " +
            "GROUP BY centro.nombre, CAST(r.fechaInicio AS DATE) " +
            "ORDER BY CAST(r.fechaInicio AS DATE), centro.nombre",
            ReporteCentroDTO.class
        );

        query.setParameter("fechaInicio", filtro.getFechaInicio());
        query.setParameter("fechaFin", filtro.getFechaFin());
        query.setParameter("centro", filtro.getCentro());
        query.setParameter("carrera", filtro.getCarrera());

        query.setFirstResult(filtro.getOffset());
        query.setMaxResults(filtro.getLimit());

        return query.getResultList();
    }
    
}
