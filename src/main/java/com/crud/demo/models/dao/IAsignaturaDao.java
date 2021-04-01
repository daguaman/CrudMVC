package com.crud.demo.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.models.entity.Asignatura;

@Repository
public interface IAsignaturaDao extends CrudRepository<Asignatura, Long>{
	@Query(value = "SELECT comment.comment, comment.published_timestamp, "
			+ "comment.username FROM comment LEFT JOIN users ON comment.id_user = users.id_user "
			+ "WHERE users.uuid = :uuid ORDER BY comment.published_timestamp DESC", nativeQuery = true)
	public List<Asignatura> findCommentsByUUID(String uuid);
	
	//decoratorQuery

}


