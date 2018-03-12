package org.yjcycc.shop.common.rmi;

import org.yjcycc.shop.common.utils.JsonUtil;

import java.io.Serializable;

public class UsingIpPort implements Serializable{
 
	private static final long serialVersionUID = -1379542048893122000L;
	
	private String ip;
	

	private int port;

	/**
	 * 用的第几套配置文件；
	 */
	private int index;
	
	/**
	 * 是否是主服务器，主服务器会启动定时任务，子服务器不启动定时任务；
	 */
	private boolean isMaster = false;
	
	
	
	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}

	public UsingIpPort(){}
	
	/**
	 * @param ip
	 * @param port
	 */
	public UsingIpPort(String ip ,int port,int  index){
		this.ip = ip;
		this.port  = port;
		this.index = index;
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * 是否是主服务器，主服务器会启动定时任务，子服务器不启动定时任务；
	 * @return
	 */
	public boolean isMaster() {
		return isMaster;
	}
	
	/**
	 * 是否是主服务器，主服务器会启动定时任务，子服务器不启动定时任务；
	 * @return
	 */
	public boolean getMaster() {
		return isMaster;
	}

	/**
	 * 是否是主服务器，主服务器会启动定时任务，子服务器不启动定时任务；
	 * @param isMaster
	 */
	public void setMaster(boolean isMaster) {
		this.isMaster = isMaster;
	}

	/**
	 * 用的第几套配置文件；
	 * @return
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * 用的第几套配置文件；
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	
	/** (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + port;
		return result;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsingIpPort other = (UsingIpPort) obj;
		if (index != other.index)
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (port != other.port)
			return false;
		return true;
	}
}
