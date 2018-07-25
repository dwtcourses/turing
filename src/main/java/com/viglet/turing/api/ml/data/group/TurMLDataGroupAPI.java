package com.viglet.turing.api.ml.data.group;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viglet.turing.persistence.model.storage.TurDataGroup;
import com.viglet.turing.persistence.repository.storage.TurDataGroupRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ml/data/group")
public class TurMLDataGroupAPI {

	@Autowired
	TurDataGroupRepository turDataGroupRepository;

	@ApiOperation(value = "Machine Learning Data Group List")
	@GetMapping
	public List<TurDataGroup> list() throws JSONException {
		return this.turDataGroupRepository.findAll();
	}

	@ApiOperation(value = "Show a Machine Learning Data Group")
	@GetMapping("/{id}")
	public TurDataGroup dataGroup(@PathVariable int id) throws JSONException {
		return this.turDataGroupRepository.findById(id);
	}

	@ApiOperation(value = "Update a Machine Learning Data Group")
	@PutMapping("/{id}")
	public TurDataGroup update(@PathVariable int id, @RequestBody TurDataGroup turDataGroup) throws Exception {
		TurDataGroup turDataGroupEdit = this.turDataGroupRepository.findById(id);
		turDataGroupEdit.setName(turDataGroup.getName());
		turDataGroupEdit.setDescription(turDataGroup.getDescription());
		this.turDataGroupRepository.save(turDataGroupEdit);
		return turDataGroupEdit;
	}

	@Transactional
	@ApiOperation(value = "Delete a Machine Learning Data Group")
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) throws Exception {
		this.turDataGroupRepository.delete(id);
		return true;

	}

	@ApiOperation(value = "Create a Machine Learning Data Group")
	@PostMapping
	public TurDataGroup add(@RequestBody TurDataGroup turDataGroup) throws Exception {
		this.turDataGroupRepository.save(turDataGroup);
		return turDataGroup;

	}
}
