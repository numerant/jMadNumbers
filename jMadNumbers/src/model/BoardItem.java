package model;

/**
 * 
 * @author Michal Zolyniak
 * @since 2014-11-29
 *
 */

public class BoardItem 
{
	private Integer digit;
	private Boolean positive;
	private Boolean active;
	private Boolean visible;

	public BoardItem(Integer size)
	{
	    //TODO prevent zeros from appearing on board
		double d = Math.random();
		Long L = Math.round(d*100);
		this.digit = Integer.valueOf(L.intValue()%size);
		d = Math.random();
		L = Math.round(d*100);
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
		if (this.digit == 0) this.digit = 1;
	}

	public Integer getDigit() 
	{
		if(positive) return digit;
		else return (-1)*digit;
	}

	public Boolean getPositive() {
		return positive;
	}

	public void setPositive(Boolean positive) {
		this.positive = positive;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public void setDigit(Integer digit) {
		this.digit = digit;
	}
}
