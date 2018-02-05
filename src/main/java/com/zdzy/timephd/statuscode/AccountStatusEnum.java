package com.zdzy.timephd.statuscode;


public enum AccountStatusEnum {

	WAIT_ACTIVATE("未激活", 0), // 待认证
	SUCCESS_ACTIVATE("已激活", 1), 
	FAILURE_ACTIVATE("停用", 2);

	private String name;
	private Integer value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	private AccountStatusEnum(String name, int value) {
		this.name = name;
		this.value = value;
	}

	static public String getStatusName(String statusName) {
		for (AccountStatusEnum statusEnum : AccountStatusEnum.values()) {
			if (statusEnum.name().equals(statusName)) {
				return statusEnum.getName();
			}
		}
		return null;
	}
	static public Integer getStatusValue(String statusName) {
		for (AccountStatusEnum statusEnum : AccountStatusEnum.values()) {
			if (statusEnum.name().equals(statusName)) {
				return statusEnum.getValue();
			}
		}
		return null;
	}
	public static void main(String[] args) {
		
		
		System.out.println(AccountStatusEnum.getStatusValue("WAIT_ACTIVATE"));
	}
}
