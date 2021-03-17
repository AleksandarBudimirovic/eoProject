/**
 * 
 */
package com.app.eoProject.service;

import java.util.List;

import com.app.eoProject.model.Account;
import com.app.eoProject.model.Student;

/**
 * @author WinX
 *
 */
public interface AccountServiceInterface {

	Account findOne(Long id);
	
	List<Account> findAll();
	
	Account save(Account account);
	
	void remove(Long id);
}
