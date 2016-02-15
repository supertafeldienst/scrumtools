package com.weltbild.sprintback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "NAME" }) )
public class Team
{
	@Id
	@GeneratedValue
	private Long id;

	private String name;

	public Team()
	{
	}

	public Team(Builder builder)
	{
		id = builder.id;
		name = builder.name;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder()
				.append(name)
				.build();

	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Team)) {
			return false;
		}

		Team other = (Team) obj;
		return new EqualsBuilder()
				.append(this.name, other.name)
				.isEquals();
	}

	@Override
	public String toString()
	{
		return new ToStringCreator(this)
				.append(name)
				.toString();
	}

	public static class Builder
	{
		private Long id;
		private String name;

		public Builder withId(Long id)
		{
			this.id = id;
			return this;
		}

		public Builder withName(String name)
		{
			this.name = name;
			return this;
		}

		public Team build()
		{
			return new Team(this);
		}
	}
}
