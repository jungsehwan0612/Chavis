package com.chavis.biz.reserve.vo;

public class reserveVO {
	private String reserveId;
	private String clientId;
	private String key;
	private String reserveTime;
	private String keyExpireTime;
	private String repairTime;
	private String bodyshopId;
	
	public reserveVO() {
		super();
	}

	public reserveVO(String reserveId, String clientId, String key, String reserveTime, String keyExpireTime,
			String repairTime, String bodyshopId) {
		super();
		this.reserveId = reserveId;
		this.clientId = clientId;
		this.key = key;
		this.reserveTime = reserveTime;
		this.keyExpireTime = keyExpireTime;
		this.repairTime = repairTime;
		this.bodyshopId = bodyshopId;
	}

	public String getReserveId() {
		return reserveId;
	}

	public void setReserveId(String reserveId) {
		this.reserveId = reserveId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}

	public String getKeyExpireTime() {
		return keyExpireTime;
	}

	public void setKeyExpireTime(String keyExpireTime) {
		this.keyExpireTime = keyExpireTime;
	}

	public String getRepairTime() {
		return repairTime;
	}

	public void setRepairTime(String repairTime) {
		this.repairTime = repairTime;
	}

	public String getBodyshopId() {
		return bodyshopId;
	}

	public void setBodyshopId(String bodyshopId) {
		this.bodyshopId = bodyshopId;
	}

	@Override
	public String toString() {
		return "reserveVO [reserveId=" + reserveId + ", clientId=" + clientId + ", key=" + key + ", reserveTime="
				+ reserveTime + ", keyExpireTime=" + keyExpireTime + ", repairTime=" + repairTime + ", bodyshopId="
				+ bodyshopId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bodyshopId == null) ? 0 : bodyshopId.hashCode());
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((keyExpireTime == null) ? 0 : keyExpireTime.hashCode());
		result = prime * result + ((repairTime == null) ? 0 : repairTime.hashCode());
		result = prime * result + ((reserveId == null) ? 0 : reserveId.hashCode());
		result = prime * result + ((reserveTime == null) ? 0 : reserveTime.hashCode());
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
		reserveVO other = (reserveVO) obj;
		if (bodyshopId == null) {
			if (other.bodyshopId != null)
				return false;
		} else if (!bodyshopId.equals(other.bodyshopId))
			return false;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (keyExpireTime == null) {
			if (other.keyExpireTime != null)
				return false;
		} else if (!keyExpireTime.equals(other.keyExpireTime))
			return false;
		if (repairTime == null) {
			if (other.repairTime != null)
				return false;
		} else if (!repairTime.equals(other.repairTime))
			return false;
		if (reserveId == null) {
			if (other.reserveId != null)
				return false;
		} else if (!reserveId.equals(other.reserveId))
			return false;
		if (reserveTime == null) {
			if (other.reserveTime != null)
				return false;
		} else if (!reserveTime.equals(other.reserveTime))
			return false;
		return true;
	}
	
	
}
