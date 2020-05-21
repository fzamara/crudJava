package br.com.longping.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.longping.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{

	List<User> findByNameIgnoreCaseContaining(String name);
	User findByUsername(String username);
}
	