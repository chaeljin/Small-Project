package usedItem.model.dto;

public class UsedItemUploadDTO {
	private int usedItemUploadId;
	private String usedItemUploadName;
	private String usedItemId;
	private String sellerId;
	private String buyerId;
	
	public UsedItemUploadDTO() {}
	
	public UsedItemUploadDTO(int usedItemUploadId, String usedItemUploadName, 
							 String usedItemId, String sellerId, String buyerId) {
		this.usedItemUploadId = usedItemUploadId;
		this.usedItemUploadName = usedItemUploadName;
		this.usedItemId = usedItemId;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
	}
	
	public int getUsedItemUploadId() {
		return usedItemUploadId;
	}
	
	public void setUsedItemUploadId(int usedItemUploadId) {
		this.usedItemUploadId = usedItemUploadId;
	}
	
	public String getUsedItemUploadName() {
		return usedItemUploadName;
	}
	
	public void setUsedItemUploadName(String usedItemUploadName) {
		this.usedItemUploadName = usedItemUploadName;
	}
	
	public String getUsedItemId() {
		return usedItemId;
	}
	
	public void setUsedItemId(String usedItemId) {
		this.usedItemId = usedItemId;
	}
	
	public String getSellerId() {
		return sellerId;
	}
	
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
	public String getBuyerId() {
		return buyerId;
	}
	
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" 1)거래 ID: ");
		builder.append(usedItemUploadId);
		builder.append("\n 2)중고거래 물건: ");
		builder.append(usedItemUploadName);
		builder.append("\n 3)물건 ID: ");
		builder.append(usedItemId);
		builder.append("\n 4)판매자 ID: ");
		builder.append(sellerId);
		builder.append("\n 5)구매자 ID: ");
		builder.append(buyerId);
		return builder.toString();
	}
}
