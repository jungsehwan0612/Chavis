package com.chavis.biz.user.vo;

public class ClientVO {
	private String client_num;
	private String client_name;
	private String car_type;
	private String car_id;
	private String tel;
	private String client_id;
	private String password;
	
	public ClientVO() {
		super();
	}

	public ClientVO(String client_num, String client_name, String car_type, 
			String car_id, String tel, String client_id, String password) {
		super();
		this.client_num = client_num;
		this.client_name = client_name;
		this.car_type = car_type;
		this.car_id = car_id;
		this.tel = tel;
		this.client_id = client_id;
		this.password = password;
	}

	public String getClientNum() {
		return client_num;
	}

	public void setClientNum(String client_num) {
		this.client_num = client_num;
	}

	public String getClientName() {
		return client_name;
	}

	public void setClientName(String client_name) {
		this.client_name = client_name;
	}

	public String getCarType() {
		return car_type;
	}

	public void setCarType(String car_type) {
		this.car_type = car_type;
	}

	public String getCarId() {
		return car_id;
	}

	public void setCarId(String car_id) {
		this.car_id = car_id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getClientId() {
		return client_id;
	}

	public void setClientId(String client_id) {
		this.client_id = client_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "userVO [client_num=" + client_num + ", client_name=" + client_name + ", car_type=" + car_type
				+ ", car_id=" + car_id + ", tel=" + tel + ", client_id=" + client_id + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car_id == null) ? 0 : car_id.hashCode());
		result = prime * result + ((car_type == null) ? 0 : car_type.hashCode());
		result = prime * result + ((client_id == null) ? 0 : client_id.hashCode());
		result = prime * result + ((client_name == null) ? 0 : client_name.hashCode());
		result = prime * result + ((client_num == null) ? 0 : client_num.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		ClientVO other = (ClientVO) obj;
		if (car_id == null) {
			if (other.car_id != null)
				return false;
		} else if (!car_id.equals(other.car_id))
			return false;
		if (car_type == null) {
			if (other.car_type != null)
				return false;
		} else if (!car_type.equals(other.car_type))
			return false;
		if (client_id == null) {
			if (other.client_id != null)
				return false;
		} else if (!client_id.equals(other.client_id))
			return false;
		if (client_name == null) {
			if (other.client_name != null)
				return false;
		} else if (!client_name.equals(other.client_name))
			return false;
		if (client_num == null) {
			if (other.client_num != null)
				return false;
		} else if (!client_num.equals(other.client_num))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
}
