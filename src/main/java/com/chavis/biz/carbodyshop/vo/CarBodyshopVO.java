package com.chavis.biz.carbodyshop.vo;

public class CarBodyshopVO {
	private String bodyshop_no;
	private String bodyshop_id;
	private String bodyshop_pw;
	private String bodyshop_name;
	private String bodyshop_address;
	private String bodyshop_lat;
	private String bodyshop_long;

	public CarBodyshopVO() {
	}

	public CarBodyshopVO(String bodyshop_id, String bodyshop_pw, String bodyshop_name,
			String bodyshop_address, String bodyshop_lat, String bodyshop_long) {
		super();
		this.bodyshop_id = bodyshop_id;
		this.bodyshop_pw = bodyshop_pw;
		this.bodyshop_name = bodyshop_name;
		this.bodyshop_address = bodyshop_address;
		this.bodyshop_lat = bodyshop_lat;
		this.bodyshop_long = bodyshop_long;
	}

	public String getBodyshop_no() {
		return bodyshop_no;
	}

	public void setBodyshop_no(String bodyshop_no) {
		this.bodyshop_no = bodyshop_no;
	}

	public String getBodyshop_id() {
		return bodyshop_id;
	}

	public void setBodyshop_id(String bodyshop_id) {
		this.bodyshop_id = bodyshop_id;
	}

	public String getBodyshop_pw() {
		return bodyshop_pw;
	}

	public void setBodyshop_pw(String bodyshop_pw) {
		this.bodyshop_pw = bodyshop_pw;
	}

	public String getBodyshop_name() {
		return bodyshop_name;
	}

	public void setBodyshop_name(String bodyshop_name) {
		this.bodyshop_name = bodyshop_name;
	}

	public String getBodyshop_address() {
		return bodyshop_address;
	}

	public void setBodyshop_address(String bodyshop_address) {
		this.bodyshop_address = bodyshop_address;
	}

	public String getBodyshop_lat() {
		return bodyshop_lat;
	}

	public void setBodyshop_lat(String bodyshop_lat) {
		this.bodyshop_lat = bodyshop_lat;
	}

	public String getBodyshop_long() {
		return bodyshop_long;
	}

	public void setBodyshop_long(String bodyshop_long) {
		this.bodyshop_long = bodyshop_long;
	}

	@Override
	public String toString() {
		return "CarBodyshopVO [bodyshop_no=" + bodyshop_no + ", bodyshop_id=" + bodyshop_id + ", bodyshop_pw="
				+ bodyshop_pw + ", bodyshop_name=" + bodyshop_name + ", bodyshop_address=" + bodyshop_address
				+ ", bodyshop_lat=" + bodyshop_lat + ", bodyshop_long=" + bodyshop_long + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bodyshop_address == null) ? 0 : bodyshop_address.hashCode());
		result = prime * result + ((bodyshop_id == null) ? 0 : bodyshop_id.hashCode());
		result = prime * result + ((bodyshop_lat == null) ? 0 : bodyshop_lat.hashCode());
		result = prime * result + ((bodyshop_long == null) ? 0 : bodyshop_long.hashCode());
		result = prime * result + ((bodyshop_name == null) ? 0 : bodyshop_name.hashCode());
		result = prime * result + ((bodyshop_no == null) ? 0 : bodyshop_no.hashCode());
		result = prime * result + ((bodyshop_pw == null) ? 0 : bodyshop_pw.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarBodyshopVO other = (CarBodyshopVO) obj;
		if (bodyshop_address == null) {
			if (other.bodyshop_address != null)
				return false;
		} else if (!bodyshop_address.equals(other.bodyshop_address))
			return false;
		if (bodyshop_id == null) {
			if (other.bodyshop_id != null)
				return false;
		} else if (!bodyshop_id.equals(other.bodyshop_id))
			return false;
		if (bodyshop_lat == null) {
			if (other.bodyshop_lat != null)
				return false;
		} else if (!bodyshop_lat.equals(other.bodyshop_lat))
			return false;
		if (bodyshop_long == null) {
			if (other.bodyshop_long != null)
				return false;
		} else if (!bodyshop_long.equals(other.bodyshop_long))
			return false;
		if (bodyshop_name == null) {
			if (other.bodyshop_name != null)
				return false;
		} else if (!bodyshop_name.equals(other.bodyshop_name))
			return false;
		if (bodyshop_no == null) {
			if (other.bodyshop_no != null)
				return false;
		} else if (!bodyshop_no.equals(other.bodyshop_no))
			return false;
		if (bodyshop_pw == null) {
			if (other.bodyshop_pw != null)
				return false;
		} else if (!bodyshop_pw.equals(other.bodyshop_pw))
			return false;
		return true;
	}
	
	
}
