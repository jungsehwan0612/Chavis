package com.chavis.biz.carbodyshop.vo;

public class CarBodyshopVO {
	private String bodyshop_num;
	private String address;
	private String latitude;
	private String longitude;
	private String body_pw;
	private String body_id;

	public CarBodyshopVO() {
	}
	
	public CarBodyshopVO(String bodyshop_num, String address, String latitude, String longitude, String body_pw,
			String body_id) {
		super();
		this.bodyshop_num = bodyshop_num;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.body_pw = body_pw;
		this.body_id = body_id;
	}	

	public String getBodyshop_num() {
		return bodyshop_num;
	}

	public void setBodyshop_num(String bodyshop_num) {
		this.bodyshop_num = bodyshop_num;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}	
	
	public String getBody_pw() {
		return body_pw;
	}

	public void setBody_pw(String body_pw) {
		this.body_pw = body_pw;
	}

	public String getBody_id() {
		return body_id;
	}

	public void setBody_id(String body_id) {
		this.body_id = body_id;
	}	
	
	@Override
	public String toString() {
		return "CarBodyshopVO [bodyshop_num=" + bodyshop_num + ", address=" + address + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", body_pw=" + body_pw + ", body_id=" + body_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((body_id == null) ? 0 : body_id.hashCode());
		result = prime * result + ((body_pw == null) ? 0 : body_pw.hashCode());
		result = prime * result + ((bodyshop_num == null) ? 0 : bodyshop_num.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
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
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (body_id == null) {
			if (other.body_id != null)
				return false;
		} else if (!body_id.equals(other.body_id))
			return false;
		if (body_pw == null) {
			if (other.body_pw != null)
				return false;
		} else if (!body_pw.equals(other.body_pw))
			return false;
		if (bodyshop_num == null) {
			if (other.bodyshop_num != null)
				return false;
		} else if (!bodyshop_num.equals(other.bodyshop_num))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		return true;
	}	
}
