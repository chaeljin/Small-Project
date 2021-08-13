package usedItem.model.dto;

public class UsedItemDTO {
	private String usedItemId;
	private String usedItemName;
	private String usedItemPrice;
	private String usedItemCondition;
	private String usedItemDetail;
	private String dealStatus;
	
	public UsedItemDTO() {}
	
	public UsedItemDTO(String usedItemId, String usedItemName, String usedItemPrice, 
					   String usedItemCondition, String usedItemDetail, String dealStatus) {
		this.usedItemId = usedItemId;
		this.usedItemName = usedItemName;
		this.usedItemPrice = usedItemPrice;
		this.usedItemCondition = usedItemCondition;
		this.usedItemDetail = usedItemDetail;
		this.dealStatus = dealStatus;
	}
	
	public String getUsedItemId() {
		return usedItemId;
	}
	
	public void setUsedItemId(String usedItemId) {
		this.usedItemId = usedItemId;
	}
	
	public String getUsedItemName() {
		return usedItemName;
	}
	
	public void setUsedItemName(String usedItemName) {
		this.usedItemName = usedItemName;
	}
	
	public String getUsedItemPrice() {
		return usedItemPrice;
	}
	
	public void setUsedItemPrice(String usedItemPrice) {
		this.usedItemPrice = usedItemPrice;
	}
	
	public String getUsedItemCondition() {
		return usedItemCondition;
	}
	
	public void setUsedItemCondition(String usedItemCondition) {
		this.usedItemCondition = usedItemCondition;
	}
	
	public String getUsedItemDetail() {
		return usedItemDetail;
	}
	
	public void setUsedItemDetail(String usedItemDetail) {
		this.usedItemDetail = usedItemDetail;
	}
	
	public String getDealStatus() {
		return dealStatus;
	}
	
	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" 1)거래 ID: ");
		builder.append(usedItemId);
		builder.append("\n 2)물건 이름: ");
		builder.append(usedItemName);
		builder.append("\n 3)물건 가격: ");
		builder.append(usedItemPrice);
		builder.append("\n 4)물건 상태: ");
		builder.append(usedItemCondition);
		builder.append("\n 5)물건 디테일: ");
		builder.append(usedItemDetail);
		builder.append("\n 6)물건 거래 상태: ");
		builder.append(dealStatus);
		return builder.toString();
		
	}
}