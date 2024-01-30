package api.payLoad;
import java.util.Date;
public class Store {
	
		int id;
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id=id;
		}

		public double getPetId() {
			return petId;
		}

		public void setPetId(double petId) {
			this.petId = petId;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getShipdate() {
			return shipdate;
		}

		public void setShipdate(String shipdate) {
			this.shipdate = shipdate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getComplete() {
			return complete;
		}

		public void setComplete(String complete) {
			this.complete = complete;
		}

		double  petId;
		int  quantity ;
		 String shipdate;
		  String status;String complete;
		
}
