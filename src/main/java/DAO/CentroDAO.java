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
public class CentroDAO implements ICentroDAO{

    @Override
    public Centro agregarCentro(AgregarCentroDTO nuevoCentro) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        Centro centro = new Centro();
        centro.setNombre(nuevoCentro.getNombre());
        centro.setContraseña(nuevoCentro.getContraseña());
        centro.setFechaFin(nuevoCentro.getFechaFin());
        centro.setFechaInicio(nuevoCentro.getFechaInicio());
        entityManager.getTransaction().begin();
        entityManager.persist(centro);
        entityManager.getTransaction().commit();
        entityManager.close();
        fabrica.close();
        return centro;
        
    }

    @Override
    public List<Centro> buscarCentros() {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Centro> criteriaQuery = criteriaBuilder.createQuery(Centro.class);
        List<Centro> centros = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        fabrica.close();
        return centros;
    }

    @Override
    public Centro BuscarCentroID(Long Id) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Centro> criteriaQuery = criteriaBuilder.createQuery(Centro.class);
        Root<Centro> root = criteriaQuery.from(Centro.class);
        criteriaQuery.select(root)
                     .where(criteriaBuilder.equal(root.get("id"), Id));
        TypedQuery<Centro> typedQuery = entityManager.createQuery(criteriaQuery);
        Centro centro = typedQuery.getSingleResult();
        entityManager.close();
        fabrica.close();
        return centro;
    }

    @Override
    public Regla agregarRegla(AgregarReglaDTO nuevaRegla) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        Regla regla = new Regla();
        regla.setDescripcion(nuevaRegla.getDescripcion());
        entityManager.getTransaction().begin();
        entityManager.persist(regla);
        entityManager.getTransaction().commit();
        entityManager.close();
        fabrica.close();
        return regla;
    }

    @Override
    public Regla BuscarReglaId(Long Id) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = fabrica.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Regla> criteriaQuery = criteriaBuilder.createQuery(Regla.class);
        Root<Regla> root = criteriaQuery.from(Regla.class);
        criteriaQuery.select(root)
                     .where(criteriaBuilder.equal(root.get("id"), Id));
        TypedQuery<Regla> typedQuery = entityManager.createQuery(criteriaQuery);
        Regla regla = typedQuery.getSingleResult();
        entityManager.close();
        fabrica.close();
        return regla;
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
