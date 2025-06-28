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
import Dominio.Centro;
import Interfaces.IAlumnoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author LABCISCO-PC036
 */
public class AlumnoDAO implements IAlumnoDAO {

    @Override
    public Carrera agregarCarrera(AgregarCarreraDTO nuevaCarrera) {
       EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        Carrera carrera =  new Carrera();
        carrera.setNombre(nuevaCarrera.getNombre());
        carrera.setTelefono(nuevaCarrera.getTelefono());
        carrera.setTiempoLimite(nuevaCarrera.getTiempoLimite());
        entityManager.getTransaction().begin();
        entityManager.persist(carrera);
        entityManager.getTransaction().commit();
        entityManager.close();
        fabrica.close();
        return carrera;
    }

    @Override
    public Carrera buscarCarreraID(Long Id) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Carrera> criteriaQuery = criteriaBuilder.createQuery(Carrera.class);
        Root<Carrera> root = criteriaQuery.from(Carrera.class);
        criteriaQuery.select(root)
                     .where(criteriaBuilder.equal(root.get("id"), Id));
        TypedQuery<Carrera> typedQuery = entityManager.createQuery(criteriaQuery);
        Carrera carrera = typedQuery.getSingleResult();
        entityManager.close();
        fabrica.close();
        return carrera;
    }

    @Override
    public Alumno agregarAlumno(AgregarAlumnoDTO alumnoNuevo) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        Alumno alumno = new Alumno();
        alumno.setNombre(alumnoNuevo.getNombre());
        alumno.setApellidoPaterno(alumnoNuevo.getApellidoPaterno());
        alumno.setApellidoMaterno(alumnoNuevo.getApellidoMaterno());
        alumno.setContrasenia(alumnoNuevo.getContraseña());
        alumno.setEstado(true);
        alumno.setCarrera(alumnoNuevo.getCarrera());
        entityManager.getTransaction().begin();
        entityManager.persist(alumno);
        entityManager.getTransaction().commit();
        entityManager.close();
        fabrica.close();
        return alumno;
    }

    @Override
    public Alumno iniciarSesion(ConfirmarAlumnoDTO alumnoSesion) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Alumno> criteriaQuery = criteriaBuilder.createQuery(Alumno.class);
        Root<Alumno> root = criteriaQuery.from(Alumno.class);
        criteriaQuery.select(root)
                     .where(criteriaBuilder
                     .and(
                        criteriaBuilder.equal(root.get("id"), alumnoSesion.getId()),
                        criteriaBuilder.equal(root.get("contrasenia"), alumnoSesion.getContraseña())    
                     ));
        
        TypedQuery<Alumno> typedQuery = entityManager.createQuery(criteriaQuery);
        Alumno alumnoBuscado = typedQuery.getSingleResult();
        entityManager.close();
        fabrica.close();
        return alumnoBuscado;
    }

    @Override
    public Bloqueo bloquearAlumno(BloquearAlumnoDTO nuevoBloqueo) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        Bloqueo bloqueo = new Bloqueo();
        bloqueo.setAlumno(nuevoBloqueo.getAlumno());
        bloqueo.setMotivo(nuevoBloqueo.getMotivo());
        bloqueo.setFechaBloqueo(nuevoBloqueo.getFechaBloqueo());
        entityManager.getTransaction().begin();
        entityManager.persist(bloqueo);
        entityManager.getTransaction().commit();
        entityManager.close();
        fabrica.close();
        return bloqueo;
    }

    @Override
    public List<Bloqueo> Bloqueos() {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bloqueo> criteriaQuery = criteriaBuilder.createQuery(Bloqueo.class);
        
        Root<Bloqueo> root = criteriaQuery.from(Bloqueo.class);
        criteriaQuery.select(root);
        
        List<Bloqueo> bloqueos = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        fabrica.close();
        return bloqueos;
    }

    @Override
    public Bloqueo BuscarBloqueoId(Long id) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bloqueo> criteriaQuery = criteriaBuilder.createQuery(Bloqueo.class);
        Root<Bloqueo> root = criteriaQuery.from(Bloqueo.class);
        criteriaQuery.select(root)
                     .where(criteriaBuilder.equal(root.get("id"), id));
        TypedQuery<Bloqueo> typedQuery = entityManager.createQuery(criteriaQuery);
        Bloqueo bloqueo = typedQuery.getSingleResult();
        entityManager.close();
        fabrica.close();
        return bloqueo;
    }

    @Override
    public Alumno Buscar(BuscarAlumnoDTO alumno) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Alumno> criteriaQuery = criteriaBuilder.createQuery(Alumno.class);
        Root<Alumno> root = criteriaQuery.from(Alumno.class);
        criteriaQuery.select(root)
                     .where(criteriaBuilder.equal(root.get("id"), alumno.getId()));
        TypedQuery<Alumno> typedQuery = entityManager.createQuery(criteriaQuery);
        Alumno alumnoBuscado = typedQuery.getSingleResult();
        entityManager.close();
        fabrica.close();
        return alumnoBuscado;
    }

    @Override
    public List<Alumno> BuscarAlumnos() {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Alumno> criteriaQuery = criteriaBuilder.createQuery(Alumno.class);
        
        Root<Alumno> root = criteriaQuery.from(Alumno.class);
        criteriaQuery.select(root);
        
        List<Alumno> alumnos = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        fabrica.close();
        return alumnos;
    }

    @Override
    public List<Carrera> ListaCarreras() {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Carrera> criteriaQuery = criteriaBuilder.createQuery(Carrera.class);
        
        Root<Carrera> root = criteriaQuery.from(Carrera.class);
        criteriaQuery.select(root);
        
        List<Carrera> carreras = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        fabrica.close();
        return carreras;
    }

    @Override
    public Bloqueo desbloqueAlumno(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Bloqueo ultimoBloqueoAlumno(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> ObtenerAlumnosBloqueados() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
