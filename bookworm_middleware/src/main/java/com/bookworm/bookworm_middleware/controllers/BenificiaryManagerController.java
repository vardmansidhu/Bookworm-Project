package com.bookworm.bookworm_middleware.controllers;

import com.bookworm.bookworm_middleware.entities.*;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookworm_middleware.services.IBenificiaryManager;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/beneficiary")
public class BenificiaryManagerController {

	@Autowired
	private IBenificiaryManager benrepo;

	@GetMapping(value = "get")
	public ResponseEntity<List<Beneficiary>> showallBen() {
		List<Beneficiary> benli = benrepo.getallBen();
		return new ResponseEntity<>(benli, HttpStatus.OK);

	}

	@GetMapping("get/{ID}")
	public ResponseEntity<Beneficiary> getBenById(@PathVariable long id) {
		java.util.Optional<Beneficiary> optional = benrepo.getBen(id);
		if (optional.isPresent()) {
			return new ResponseEntity<>(optional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Void> addben(@RequestBody Beneficiary ben) {
		try {
			benrepo.addBeneficiary(ben);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @PutMapping("/update/{id}")
	 * public ResponseEntity<Void> updateben(@PathVariable long id,@RequestBody
	 * Beneficiary ben){
	 * try {
	 * benrepo.update(ben, id);
	 * return new ResponseEntity<>(HttpStatus.OK);
	 * }
	 * catch(Exception e) {
	 * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	 * }
	 * }
	 **/
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> delByid(@PathVariable long id) {
		try {
			benrepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
