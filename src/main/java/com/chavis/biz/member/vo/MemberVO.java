package com.chavis.biz.member.vo;

public class MemberVO {
	private int member_no;
	private String member_id;
	private String member_pw;
	private String member_mname;
	private String member_phonenumber;
	private String car_no;
	
	public MemberVO() {
		super();
	}

	public MemberVO(int member_no, String member_id, String member_pw, String member_mname, String member_phonenumber,
			String car_no) {
		super();
		this.member_no = member_no;
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_mname = member_mname;
		this.member_phonenumber = member_phonenumber;
		this.car_no = car_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_mname() {
		return member_mname;
	}

	public void setMember_mname(String member_mname) {
		this.member_mname = member_mname;
	}

	public String getMember_phonenumber() {
		return member_phonenumber;
	}

	public void setMember_phonenumber(String member_phonenumber) {
		this.member_phonenumber = member_phonenumber;
	}

	public String getCar_no() {
		return car_no;
	}

	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car_no == null) ? 0 : car_no.hashCode());
		result = prime * result + ((member_id == null) ? 0 : member_id.hashCode());
		result = prime * result + ((member_mname == null) ? 0 : member_mname.hashCode());
		result = prime * result + member_no;
		result = prime * result + ((member_phonenumber == null) ? 0 : member_phonenumber.hashCode());
		result = prime * result + ((member_pw == null) ? 0 : member_pw.hashCode());
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
		MemberVO other = (MemberVO) obj;
		if (car_no == null) {
			if (other.car_no != null)
				return false;
		} else if (!car_no.equals(other.car_no))
			return false;
		if (member_id == null) {
			if (other.member_id != null)
				return false;
		} else if (!member_id.equals(other.member_id))
			return false;
		if (member_mname == null) {
			if (other.member_mname != null)
				return false;
		} else if (!member_mname.equals(other.member_mname))
			return false;
		if (member_no != other.member_no)
			return false;
		if (member_phonenumber == null) {
			if (other.member_phonenumber != null)
				return false;
		} else if (!member_phonenumber.equals(other.member_phonenumber))
			return false;
		if (member_pw == null) {
			if (other.member_pw != null)
				return false;
		} else if (!member_pw.equals(other.member_pw))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MemberVO [member_no=" + member_no + ", member_id=" + member_id + ", member_pw=" + member_pw
				+ ", member_mname=" + member_mname + ", member_phonenumber=" + member_phonenumber + ", car_no=" + car_no
				+ "]";
	}
}
