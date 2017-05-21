package xgj.mcj.entity;

import java.util.Date;

public class StatementOfBill {
    private Integer id;

    private Integer userid;

    private Double shouru;

    private Double zhichu;

    private Double yue;

    private Double zhichuzong;

    private Double shouruzong;

    private String neirong;

    private Double yusuan;
    
    private Date startTime ;
    
    private Date endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Double getShouru() {
        return shouru;
    }

    public void setShouru(Double shouru) {
        this.shouru = shouru;
    }

    public Double getZhichu() {
        return zhichu;
    }

    public void setZhichu(Double zhichu) {
        this.zhichu = zhichu;
    }

    public Double getYue() {
        return yue;
    }

    public void setYue(Double yue) {
        this.yue = yue;
    }

    public Double getZhichuzong() {
        return zhichuzong;
    }

    public void setZhichuzong(Double zhichuzong) {
        this.zhichuzong = zhichuzong;
    }

    public Double getShouruzong() {
        return shouruzong;
    }

    public void setShouruzong(Double shouruzong) {
        this.shouruzong = shouruzong;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong == null ? null : neirong.trim();
    }

    public Double getYusuan() {
        return yusuan;
    }

    public void setYusuan(Double yusuan) {
        this.yusuan = yusuan;
    }

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
    
}