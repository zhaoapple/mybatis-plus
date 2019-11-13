package com.info33.mybatisplus.entity;


public class Demo {

  private long id;
  private long pid;
  private String name;

  public Demo() {
  }
  public Demo( long pid, String name) {
    this.pid = pid;
    this.name = name;
  }
  public Demo( long pid) {
    this.pid = pid;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
