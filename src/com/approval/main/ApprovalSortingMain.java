package com.approval.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.approval.dto.SalesOrder;

public class ApprovalSortingMain {

	public static void main(String[] args) {
		// List of sales orders with approvals
		List<SalesOrder> salesOrders = new ArrayList<>();
		salesOrders.add(new SalesOrder("SO001", List.of("P123", "P234")));
		salesOrders.add(new SalesOrder("SO002", List.of("P234")));
		salesOrders.add(new SalesOrder("SO003", List.of("P123")));
		salesOrders.add(new SalesOrder("SO004", List.of("P980", "P123")));
		salesOrders.add(new SalesOrder("SO005", List.of("P234", "P980")));

		// Grouping sales orders by approval
		Map<String, List<String>> approvalToSalesOrdersMap = groupSalesOrdersByApproval(salesOrders);

		// Printing the grouped results
		for (Map.Entry<String, List<String>> entry : approvalToSalesOrdersMap.entrySet()) {
			System.out.println("Approval ID: " + entry.getKey());
			System.out.println("Sales Orders: " + entry.getValue());
			System.out.println("-------------");
		}
	}

	// Method to group sales orders by each approval ID
	public static Map<String, List<String>> groupSalesOrdersByApproval(List<SalesOrder> salesOrders) {
		Map<String, List<String>> approvalToSalesOrdersMap = new HashMap<>();

		for (SalesOrder order : salesOrders) {
			String salesOrderId = order.getSalesOrderId();

			// Iterate through each approval ID associated with the sales order
			for (String approvalId : order.getApprovalIds()) {
				// Initialize a new list if the approval ID doesn't exist in the map
				approvalToSalesOrdersMap.computeIfAbsent(approvalId, k -> new ArrayList<>());

				// Add sales order ID to the corresponding approval list
				approvalToSalesOrdersMap.get(approvalId).add(salesOrderId);
			}
		}

		return approvalToSalesOrdersMap;
	}
}
