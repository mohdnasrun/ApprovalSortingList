package com.approval.dto;

import java.util.List;

public class SalesOrder {
	private String salesOrderId;
	private List<String> approvalIds;

	public SalesOrder(String salesOrderId, List<String> approvalIds) {
		this.salesOrderId = salesOrderId;
		this.approvalIds = approvalIds;
	}

	public String getSalesOrderId() {
		return salesOrderId;
	}

	public List<String> getApprovalIds() {
		return approvalIds;
	}
}
