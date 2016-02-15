package com.weltbild.sprintback.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.core.style.ToStringCreator;

public class Team
{
	private long id;
	private String name;

	public long getId()
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
		EqualsBuilder equalsBuilder = new EqualsBuilder();

		return equalsBuilder
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
}
