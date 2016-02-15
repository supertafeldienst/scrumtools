package com.weltbild.sprintback.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.core.style.ToStringCreator;

public class Criteria
{
	private Long id;
	private String name;
	private int min;
	private int max;

	public long getId()
	{
		return id;
	}

	public void setId(Long id)
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

	public int getMin()
	{
		return min;
	}

	public void setMin(int min)
	{
		this.min = min;
	}

	public int getMax()
	{
		return max;
	}

	public void setMax(int max)
	{
		this.max = max;
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder()
				.append(name)
				.append(min)
				.append(max)
				.build();

	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Criteria)) {
			return false;
		}

		Criteria other = (Criteria) obj;
		EqualsBuilder equalsBuilder = new EqualsBuilder();

		return equalsBuilder
				.append(this.name, other.name)
				.append(this.min, other.min)
				.append(this.max, other.max)
				.isEquals();
	}

	@Override
	public String toString()
	{
		return new ToStringCreator(this)
				.append(name)
				.append(min)
				.append(max)
				.toString();
	}

}
