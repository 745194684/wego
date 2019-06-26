package edu.xawl.pojo;

public class User {
	private String tnumber;
	private String tpassword;
	private String tname;
	private String tstep;
	private String up_date;

	public String getTnumber() {
		return tnumber;
	}

	public void setTnumber(String tnumber) {
		this.tnumber = tnumber;
	}

	
	public String getTpassword() {
		return tpassword;
	}

	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTstep() {
		return tstep;
	}

	public void setTstep(String tstep) {
		this.tstep = tstep;
	}

	public String getUp_date() {
		return up_date;
	}

	public void setUp_date(String up_date) {
		this.up_date = up_date;
	}

	@Override
	public String toString() {
		return "User [tnumber=" + tnumber + ", tpassword=" + tpassword + ", tname=" + tname + ", tstep=" + tstep
				+ ", up_date=" + up_date + "]";
	}

	
	
}
