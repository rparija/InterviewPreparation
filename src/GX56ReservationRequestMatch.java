

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;



public class GX56ReservationRequestMatch implements Serializable
{

    public GX56ReservationRequestMatch(String hashId, String reservationRequest, String locationId, Double quantity,
			String itemId) {
		super();
		this.hashId = hashId;
		this.reservationRequest = reservationRequest;
		this.locationId = locationId;
		this.quantity = quantity;
		this.itemId = itemId;
	}



	private static final long serialVersionUID = 1749191100712922434L;

   
    private String hashId;

  
    private String reservationRequest;

    
    private String locationId;

    private Double quantity;

    private String itemId;

    private String supplyTypeId;

    private Long pK;

    public String getHashId() {
		return hashId;
	}



	public void setHashId(String hashId) {
		this.hashId = hashId;
	}



	public String getReservationRequest() {
		return reservationRequest;
	}



	public void setReservationRequest(String reservationRequest) {
		this.reservationRequest = reservationRequest;
	}



	public String getLocationId() {
		return locationId;
	}



	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}



	public Double getQuantity() {
		return quantity;
	}



	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}



	public String getItemId() {
		return itemId;
	}



	public void setItemId(String itemId) {
		this.itemId = itemId;
	}



	public String getSupplyTypeId() {
		return supplyTypeId;
	}



	public void setSupplyTypeId(String supplyTypeId) {
		this.supplyTypeId = supplyTypeId;
	}



	public Long getpK() {
		return pK;
	}



	public void setpK(Long pK) {
		this.pK = pK;
	}



	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}



	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	private Map<String, Object> additionalProperties = new HashMap<>();

   

    public void setAdditionalProperty(String name, Object value)
    {
        this.additionalProperties.put(name, value);
    }

    
}