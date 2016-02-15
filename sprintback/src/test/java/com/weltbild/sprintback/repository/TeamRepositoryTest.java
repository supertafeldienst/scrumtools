package com.weltbild.sprintback.repository;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;
import com.weltbild.sprintback.SprintbackApplication;
import com.weltbild.sprintback.model.Team;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SprintbackApplication.class)
@ActiveProfiles("test")
public class TeamRepositoryTest
{

	@Autowired
	private TeamRepository repo;

	@After
	public void clean()
	{
		repo.deleteAll();
	}

	@Test
	public void findByName()
	{
		assertThat(repo.findAll(), is(emptyIterable()));

		Team teamSortiment = new Team.Builder().withName("Sortiment").build();
		Team teamBoris = new Team.Builder().withName("Boris").build();
		repo.save(Lists.newArrayList(teamSortiment, teamBoris));

		assertThat(repo.findAll(), is(iterableWithSize(2)));
		assertThat(repo.findByName("Sortiment"), is(equalTo(teamSortiment)));
		assertThat(repo.findByName("Boris"), is(equalTo(teamBoris)));
	}

	@Test
	public void findByNameLike()
	{
		assertThat(repo.findAll(), is(emptyIterable()));

		Team teamSortiment = new Team.Builder().withName("Sortiment").build();
		Team teamBoris = new Team.Builder().withName("Boris").build();
		repo.save(Lists.newArrayList(teamSortiment, teamBoris));

		List<Team> result = repo.findByNameLike("%ment");
		assertThat(result, is(iterableWithSize(1)));
		assertThat(result.get(0), is(equalTo(teamSortiment)));

		List<Team> result2 = repo.findByNameLike("So%");
		assertThat(result2, is(iterableWithSize(1)));
		assertThat(result2.get(0), is(equalTo(teamSortiment)));

		List<Team> result3 = repo.findByNameLike("%or%");
		assertThat(result3, is(iterableWithSize(2)));
		assertThat(result3, hasItems(teamSortiment, teamBoris));

		List<Team> result4 = repo.findByNameLike("%XXX%");
		assertThat(result4, is(emptyIterable()));
	}
}
