package de.reservo.dto;

public class ServiceGroupEmployeeDTO {

	private Long serviceId;
	private Long employeeId;
	private Long groupId;

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long pServiceId) {
		serviceId = pServiceId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long pEmployeeId) {
		employeeId = pEmployeeId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long pGroupId) {
		groupId = pGroupId;
	}

}
