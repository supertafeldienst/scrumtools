package com.weltbild.sprintback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weltbild.sprintback.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long>
{
	public Team findByName(String name);

	public List<Team> findByNameLike(String name);
}
