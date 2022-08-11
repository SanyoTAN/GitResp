package Pojo;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;

    public Emp(Integer empno, String ename, String job, Integer mgr, Date hiredate, Double sal, Double comm, Integer deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public Integer getEmpno() {
        return empno;
    }

    public String getEname() {
        return ename;
    }

    public String getJob() {
        return job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public Double getSal() {
        return sal;
    }

    public Double getComm() {
        return comm;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }
}
