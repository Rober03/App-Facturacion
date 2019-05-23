/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;

import java.io.Serializable;
import java.util.List;
import model.entities.Entity;

/**
 *
 * @author Rober03
 * @param <E>
 * @param <D>
 */
public interface GenericDAO<E extends Entity, D extends Serializable>{
	void create(E entity);
	E read(D pk);
	void update(E entity);
	void delete(E entity);
	List<E> list();
}
