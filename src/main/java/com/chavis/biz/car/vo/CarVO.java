package com.chavis.biz.car.vo;

public class CarVO {
	private String car_id;
	private String tire_change_distance;
	private String wiper_change_distance;
	private String cooler_left;
	private String engine_oil_left;
	private String distance;
	
	public CarVO() {
	}
	
	public CarVO(String carId, String tireDistance, String wiperDistance, String coolerLeft, String engineOilLeft,
			String distance) {
		super();
		this.car_id = carId;
		this.tire_change_distance = tireDistance;
		this.wiper_change_distance = wiperDistance;
		this.cooler_left = coolerLeft;
		this.engine_oil_left = engineOilLeft;
		this.distance = distance;
	}

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String carId) {
		this.car_id = carId;
	}

	public String getTire_change_distance() {
		return tire_change_distance;
	}

	public void setTire_change_distance(String tireDistance) {
		this.tire_change_distance = tireDistance;
	}

	public String getWiper_change_distance() {
		return wiper_change_distance;
	}

	public void setWiper_change_distance(String wiperDistance) {
		this.wiper_change_distance = wiperDistance;
	}

	public String getCooler_left() {
		return cooler_left;
	}

	public void setCooler_left(String coolerLeft) {
		this.cooler_left = coolerLeft;
	}

	public String getEngineoil_left() {
		return engine_oil_left;
	}

	public void setEngineoil_left(String engineOilLeft) {
		this.engine_oil_left = engineOilLeft;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "carVO [carId=" + car_id + ", tireDistance=" + tire_change_distance + ", wiperDistance=" + wiper_change_distance
				+ ", coolerLeft=" + cooler_left + ", engineOilLeft=" + engine_oil_left + ", distance=" + distance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car_id == null) ? 0 : car_id.hashCode());
		result = prime * result + ((cooler_left == null) ? 0 : cooler_left.hashCode());
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((engine_oil_left == null) ? 0 : engine_oil_left.hashCode());
		result = prime * result + ((tire_change_distance == null) ? 0 : tire_change_distance.hashCode());
		result = prime * result + ((wiper_change_distance == null) ? 0 : wiper_change_distance.hashCode());
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
		CarVO other = (CarVO) obj;
		if (car_id == null) {
			if (other.car_id != null)
				return false;
		} else if (!car_id.equals(other.car_id))
			return false;
		if (cooler_left == null) {
			if (other.cooler_left != null)
				return false;
		} else if (!cooler_left.equals(other.cooler_left))
			return false;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (engine_oil_left == null) {
			if (other.engine_oil_left != null)
				return false;
		} else if (!engine_oil_left.equals(other.engine_oil_left))
			return false;
		if (tire_change_distance == null) {
			if (other.tire_change_distance != null)
				return false;
		} else if (!tire_change_distance.equals(other.tire_change_distance))
			return false;
		if (wiper_change_distance == null) {
			if (other.wiper_change_distance != null)
				return false;
		} else if (!wiper_change_distance.equals(other.wiper_change_distance))
			return false;
		return true;
	}
	
}
