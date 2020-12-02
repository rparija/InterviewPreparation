
public class StringOperations {

	public static void main(String[] args) {
		String reservationRequestDetailId = null;
		String orderLineId = "1:1:1594982168512";
		if (orderLineId.contains(":")) {
			reservationRequestDetailId = orderLineId.substring(0, orderLineId.indexOf(":"));
		} else {
			reservationRequestDetailId = orderLineId;
		}

		whileLoopTest();
	}

	public static void whileLoopTest() {
		Double invRiseQty = 2D;
		int page=0;
		while (invRiseQty > 0) {
			System.out.println(page);
			invRiseQty = decrementinvRiseQty(invRiseQty);
			page++;
		}
	}

	public static Double decrementinvRiseQty(Double invRiseQty) {
		invRiseQty = invRiseQty-1;
		return invRiseQty;
	}
}