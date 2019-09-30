package com.chavis.biz.reserve.vo;

public class ReserveVO {
	private String reserve_id;
	private String client_id;
	private String key;
	private String reserve_time;
	private String key_expire_time;
	private String repair_time;
	private String bodyshop_id;
	
	public ReserveVO() {
		super();
	}

	public ReserveVO(String reserve_id, String client_id, String key, String reserve_time, String key_expire_time,
			String repair_time, String bodyshop_id) {
		super();
		this.reserve_id = reserve_id;
		this.client_id = client_id;
		this.key = key;
		this.reserve_time = reserve_time;
		this.key_expire_time = key_expire_time;
		this.repair_time = repair_time;
		this.bodyshop_id = bodyshop_id;
	}

	public String getReserve_id() {
		return reserve_id;
	}

	public void setReserve_id(String reserve_id) {
		this.reserve_id = reserve_id;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getReserve_time() {
		return reserve_time;
	}

	public void setReserve_time(String reserve_time) {
		this.reserve_time = reserve_time;
	}

	public String getKey_expire_time() {
		return key_expire_time;
	}

	public void setKey_expire_time(String key_expire_time) {
		this.key_expire_time = key_expire_time;
	}

	public String getRepair_time() {
		return repair_time;
	}

	public void setRepair_time(String repair_time) {
		this.repair_time = repair_time;
	}

	public String getBodyshop_id() {
		return bodyshop_id;
	}

	public void setBodyshop_id(String bodyshop_id) {
		this.bodyshop_id = bodyshop_id;
	}

	@Override
	public String toString() {
		return "ReserveVO [reserve_id=" + reserve_id + ", client_id=" + client_id + ", key=" + key + ", reserve_time="
				+ reserve_time + ", key_expire_time=" + key_expire_time + ", repair_time=" + repair_time
				+ ", bodyshop_id=" + bodyshop_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bodyshop_id == null) ? 0 : bodyshop_id.hashCode());
		result = prime * result + ((client_id == null) ? 0 : client_id.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((key_expire_time == null) ? 0 : key_expire_time.hashCode());
		result = prime * result + ((repair_time == null) ? 0 : repair_time.hashCode());
		result = prime * result + ((reserve_id == null) ? 0 : reserve_id.hashCode());
		result = prime * result + ((reserve_time == null) ? 0 : reserve_time.hashCode());
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
		ReserveVO other = (ReserveVO) obj;
		if (bodyshop_id == null) {
			if (other.bodyshop_id != null)
				return false;
		} else if (!bodyshop_id.equals(other.bodyshop_id))
			return false;
		if (client_id == null) {
			if (other.client_id != null)
				return false;
		} else if (!client_id.equals(other.client_id))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (key_expire_time == null) {
			if (other.key_expire_time != null)
				return false;
		} else if (!key_expire_time.equals(other.key_expire_time))
			return false;
		if (repair_time == null) {
			if (other.repair_time != null)
				return false;
		} else if (!repair_time.equals(other.repair_time))
			return false;
		if (reserve_id == null) {
			if (other.reserve_id != null)
				return false;
		} else if (!reserve_id.equals(other.reserve_id))
			return false;
		if (reserve_time == null) {
			if (other.reserve_time != null)
				return false;
		} else if (!reserve_time.equals(other.reserve_time))
			return false;
		return true;
	}



	
	
	
}
