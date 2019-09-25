package com.chavis.biz.carpairshop.vo;

public class carPairShopVO {
	private String bodyShopId;
	private String address;
	private String latitude;
	private String longitude;

	public carPairShopVO() {
	}

	public carPairShopVO(String bodyShopId, String address, String latitude, String longitude) {
		super();
		this.bodyShopId = bodyShopId;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getBodyShopId() {
		return bodyShopId;
	}

	public void setBodyShopId(String bodyShopId) {
		this.bodyShopId = bodyShopId;
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

	@Override
	public String toString() {
		return "carFairShopVO [bodyShopId=" + bodyShopId + ", address=" + address + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((bodyShopId == null) ? 0 : bodyShopId.hashCode());
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
		carPairShopVO other = (carPairShopVO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (bodyShopId == null) {
			if (other.bodyShopId != null)
				return false;
		} else if (!bodyShopId.equals(other.bodyShopId))
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
