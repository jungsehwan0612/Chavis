package com.chavis.biz.car;

public class carVO {
	private String carId;
	private String tireDistance;
	private String wiperDistance;
	private String coolerLeft;
	private String engineOilLeft;
	private String distance;
	
	public carVO() {
	}
	
	public carVO(String carId, String tireDistance, String wiperDistance, String coolerLeft, String engineOilLeft,
			String distance) {
		super();
		this.carId = carId;
		this.tireDistance = tireDistance;
		this.wiperDistance = wiperDistance;
		this.coolerLeft = coolerLeft;
		this.engineOilLeft = engineOilLeft;
		this.distance = distance;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getTireDistance() {
		return tireDistance;
	}

	public void setTireDistance(String tireDistance) {
		this.tireDistance = tireDistance;
	}

	public String getWiperDistance() {
		return wiperDistance;
	}

	public void setWiperDistance(String wiperDistance) {
		this.wiperDistance = wiperDistance;
	}

	public String getCoolerLeft() {
		return coolerLeft;
	}

	public void setCoolerLeft(String coolerLeft) {
		this.coolerLeft = coolerLeft;
	}

	public String getEngineOilLeft() {
		return engineOilLeft;
	}

	public void setEngineOilLeft(String engineOilLeft) {
		this.engineOilLeft = engineOilLeft;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "carVO [carId=" + carId + ", tireDistance=" + tireDistance + ", wiperDistance=" + wiperDistance
				+ ", coolerLeft=" + coolerLeft + ", engineOilLeft=" + engineOilLeft + ", distance=" + distance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carId == null) ? 0 : carId.hashCode());
		result = prime * result + ((coolerLeft == null) ? 0 : coolerLeft.hashCode());
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((engineOilLeft == null) ? 0 : engineOilLeft.hashCode());
		result = prime * result + ((tireDistance == null) ? 0 : tireDistance.hashCode());
		result = prime * result + ((wiperDistance == null) ? 0 : wiperDistance.hashCode());
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
		carVO other = (carVO) obj;
		if (carId == null) {
			if (other.carId != null)
				return false;
		} else if (!carId.equals(other.carId))
			return false;
		if (coolerLeft == null) {
			if (other.coolerLeft != null)
				return false;
		} else if (!coolerLeft.equals(other.coolerLeft))
			return false;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (engineOilLeft == null) {
			if (other.engineOilLeft != null)
				return false;
		} else if (!engineOilLeft.equals(other.engineOilLeft))
			return false;
		if (tireDistance == null) {
			if (other.tireDistance != null)
				return false;
		} else if (!tireDistance.equals(other.tireDistance))
			return false;
		if (wiperDistance == null) {
			if (other.wiperDistance != null)
				return false;
		} else if (!wiperDistance.equals(other.wiperDistance))
			return false;
		return true;
	}
	
}
