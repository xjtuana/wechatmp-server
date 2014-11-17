/**
 * UserInfoPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.ana.wcmp.webservice.client.info;

public interface UserInfoPortType extends java.rmi.Remote {
    public org.ana.wcmp.webservice.client.info.xsd.SimpleInfoDto getSimpleInfoById(java.lang.String limited, java.lang.String uid) throws java.rmi.RemoteException;
    public org.ana.wcmp.webservice.client.info.xsd.UserInfoDto[] getInfoByName(java.lang.String auth, java.lang.String sname) throws java.rmi.RemoteException;
    public org.ana.wcmp.webservice.client.info.xsd.UserInfoDto getInfoByNo(java.lang.String auth, java.lang.String sno) throws java.rmi.RemoteException;
    public org.ana.wcmp.webservice.client.info.xsd.UserInfoDto getInfoById(java.lang.String auth, java.lang.String uid) throws java.rmi.RemoteException;
    public org.ana.wcmp.webservice.client.info.xsd.UserInfoDto[] getInfoByMobile(java.lang.String auth, java.lang.String mobile) throws java.rmi.RemoteException;
}
