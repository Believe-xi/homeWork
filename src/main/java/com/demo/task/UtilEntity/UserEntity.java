package com.demo.task.UtilEntity;

public interface UserEntity {
    int id=-1;
    String num=null;
    String passWord=null;
    String name=null;
    String sex=null;
    int classId=-1;

    int getId();
    String getNum();
    String getName();
    String getPassWord();
    String getSex();
    int getClassId();

    void setNum(String userNum);
    void setPassWord(String passWord);
    void setName(String name);
    void setSex(String sex);
    void setClassId(int classId);
}
