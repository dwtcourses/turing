package com.viglet.turing.persistence.repository.ml;

import com.viglet.turing.persistence.model.ml.TurMLCategory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TurMLCategoryRepository extends JpaRepository<TurMLCategory, Integer> {

	List<TurMLCategory> findAll();

	TurMLCategory findById(int id);
	
	TurMLCategory save(TurMLCategory turMLCategory);

	@Modifying
	@Query("delete from  TurMLCategory mc where mc.id = ?1")
	void delete(int id);
}
