package model;

/**
 * This class is used for representation single board item.
 */

public class BoardItem 
{
	private Integer number;
	private Boolean positive;
	private Boolean active;
	private Boolean visible;

	public BoardItem(Integer size)
	{
		double d = Math.random();
		Long L = Math.round(d*1000);
		this.number = Integer.valueOf(L.intValue()%10);
		d = Math.random();
		L = Math.round(d*10);
		if (Integer.valueOf(L.intValue()%2) == 0)
		{
			this.positive = true;
		}
		else
		{
			this.positive = false;
		}
		this.active = false;
		this.visible = true;
		if (this.number == 0) this.number = 1;
	}

	public BoardItem(Integer number, Boolean positive)
	{
		this.number = number;
		this.positive = positive;
		this.active = false;
		this.visible = true;
	}
	
	public Integer getNumber() 
	{
		if(positive) return number;
		else return (-1)*number;
	}

	public Boolean getPositive()
	{	
		return positive;
	}

	public void setPositive(Boolean positive)
	{
		this.positive = positive;
	}

	public Boolean getActive()
	{
		return active;
	}

	public void setActive(Boolean active)
	{
		this.active = active;
	}

	public Boolean getVisible()
	{
		return visible;
	}

	public void setVisible(Boolean visible)
	{
		this.visible = visible;
	}

	public void setDigit(Integer digit)
	{
		this.number = digit;
	}
}