package com.springapp.mvc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kouyang on 2/27/2015.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
