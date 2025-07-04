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
import Dominio.Alumno;
import Dominio.Computadora;
import Dominio.Instalacion;
import Dominio.Regla;
import Dominio.Reservacion;
import Dominio.Software;
import Interfaces.IComputadoraDAO;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

/**
 *
 * @author LABCISCO-PC036
 */
public class ComputadoraDAO implements IComputadoraDAO {

    @Override
    public Computadora agregarComputadora(AgregarComputadoraDTO nuevacomputadora) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        Computadora computadora = new Computadora();
        computadora.setNumero(nuevacomputadora.getNumero());
        computadora.setCentro(nuevacomputadora.getCentro());
        computadora.setIp(nuevacomputadora.getIp());
        computadora.setEstado(nuevacomputadora.isEstado());
        entityManager.getTransaction().begin();
        entityManager.persist(computadora);
        entityManager.getTransaction().commit();
        entityManager.close();
        fabrica.close();
        return computadora;
    }

    @Override
    public Computadora buscarComputadoraId(Long Id) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Computadora> criteriaQuery = criteriaBuilder.createQuery(Computadora.class);
        Root<Computadora> root = criteriaQuery.from(Computadora.class);
        criteriaQuery.select(root)
                     .where(criteriaBuilder.equal(root.get("id"), Id));
        TypedQuery<Computadora> typedQuery = entityManager.createQuery(criteriaQuery);
        Computadora computadora = typedQuery.getSingleResult();
        entityManager.close();
        fabrica.close();
        return computadora;
    }

   @Override
    public Reservacion reservarComputadora(GuardarReservaDTO nuevaReservacion) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();

        Alumno alumno = entityManager.find(Alumno.class, nuevaReservacion.getIdAlumno());
        Computadora computadora = entityManager.find(Computadora.class, nuevaReservacion.getIdComputadora());

        // Verificar disponibilidad
        Long count = entityManager.createQuery(
            "SELECT COUNT(r) FROM Reservacion r WHERE " +
            "r.computadora = :comp AND " +
            "r.fechaInicio < :fin AND " +
            "r.fechaFin > :inicio", Long.class)
            .setParameter("comp", computadora)
            .setParameter("inicio", nuevaReservacion.getFechaHoraInicio())
            .setParameter("fin", nuevaReservacion.getFechaHoraFin())
            .getSingleResult();

        Reservacion reservacion = new Reservacion();
        reservacion.setFechaInicio(nuevaReservacion.getFechaHoraInicio());
        reservacion.setFechaFin(nuevaReservacion.getFechaHoraFin());
        reservacion.setAlumno(alumno);
        reservacion.setComputadora(computadora);

        computadora.setEstado(false);

        entityManager.getTransaction().begin();
        entityManager.persist(reservacion);
        entityManager.merge(computadora);
        entityManager.getTransaction().commit();

        entityManager.close();
        fabrica.close();
        return reservacion;
    }

    @Override
    public Reservacion buscarReservacionId(Long Id) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Reservacion> criteriaQuery = criteriaBuilder.createQuery(Reservacion.class);
        Root<Reservacion> root = criteriaQuery.from(Reservacion.class);
        criteriaQuery.select(root)
                     .where(criteriaBuilder.equal(root.get("id"), Id));
        TypedQuery<Reservacion> typedQuery = entityManager.createQuery(criteriaQuery);
        Reservacion reservacion = typedQuery.getSingleResult();
        entityManager.close();
        fabrica.close();
        return reservacion;
    }

    @Override
    public List<Instalacion> softwareInstalado(Long idComputadora) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Instalacion> criteriaQuery = criteriaBuilder.createQuery(Instalacion.class);
        
        Root<Instalacion> root = criteriaQuery.from(Instalacion.class);
        criteriaQuery.select(root)
                   .where(criteriaBuilder.equal(root.get("idCentro"), idComputadora));
        
        List<Instalacion> instalacions = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        fabrica.close();
        return instalacions;
    }

    @Override
    public Software agregarSoftware(AgregarSoftwareDTO nuevoSoftware) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        Software software = new Software();
        software.setNombre(nuevoSoftware.getNombre());
        entityManager.getTransaction().begin();
        entityManager.persist(software);
        entityManager.getTransaction().commit();
        entityManager.close();
        fabrica.close();
        return software;
    }

    @Override
    public Software BuscarSoftware(Long Id) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Software> criteriaQuery = criteriaBuilder.createQuery(Software.class);
        Root<Software> root = criteriaQuery.from(Software.class);
        criteriaQuery.select(root)
                     .where(criteriaBuilder.equal(root.get("id"), Id));
        TypedQuery<Software> typedQuery = entityManager.createQuery(criteriaQuery);
        Software software = typedQuery.getSingleResult();
        entityManager.close();
        fabrica.close();
        return software;
    }

    @Override
    public Instalacion InstalarSoftware(InstalarSoftwareDTO nuevoSoftwareDTO) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        Instalacion instalacion = new Instalacion();
        instalacion.setComputadora(nuevoSoftwareDTO.getComputadora());
        instalacion.setSoftware(nuevoSoftwareDTO.getSoftware());
        instalacion.setVersion(nuevoSoftwareDTO.getVersion());
        entityManager.getTransaction().begin();
        entityManager.persist(instalacion);
        entityManager.getTransaction().commit();
        entityManager.close();
        fabrica.close();
        return instalacion;
    }

    @Override
    public Computadora buscarComputadoraIp(String ip) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Computadora> criteriaQuery = criteriaBuilder.createQuery(Computadora.class);
        Root<Computadora> root = criteriaQuery.from(Computadora.class);
        criteriaQuery.select(root)
                     .where(criteriaBuilder.equal(root.get("ip"), ip));
        TypedQuery<Computadora> typedQuery = entityManager.createQuery(criteriaQuery);
        Computadora computadora = typedQuery.getSingleResult();
        entityManager.close();
        fabrica.close();
        return computadora;  
    }

    @Override
    public Computadora actualizarEstado(ActualizarEstadoComputadoraDTO actualizarEstado) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();

        Computadora pc = entityManager.find(Computadora.class, actualizarEstado.getIdComputadora());

        if ("ocupado".equalsIgnoreCase(actualizarEstado.getEstadoNuevo())) {
            pc.setEstado(false);
        } else if ("desocupado".equalsIgnoreCase(actualizarEstado.getEstadoNuevo())) {
            pc.setEstado(true);
        }

        Computadora updated = entityManager.merge(pc);
        entityManager.close();
        fabrica.close();
        return updated;
    }
    
}
