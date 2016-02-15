package com.weltbild.sprintback.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.core.style.ToStringCreator;

public class Sprint
{
	private Long id;
	private int number;
	private String name;
	private Team team;

	public long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Team getTeam()
	{
		return team;
	}

	public void setTeam(Team team)
	{
		this.team = team;
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder()
				.append(number)
				.append(name)
				.append(team)
				.build();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Sprint)) {
			return false;
		}

		Sprint other = (Sprint) obj;
		return new EqualsBuilder()
				.append(this.number, other.number)
				.append(this.name, other.name)
				.append(this.team, other.team)
				.isEquals();
	}

	@Override
	public String toString()
	{
		return new ToStringCreator(this)
				.append(number)
				.append(name)
				.append(team)
				.toString();
	}

}
