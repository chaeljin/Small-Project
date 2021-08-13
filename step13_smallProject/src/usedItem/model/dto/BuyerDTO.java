package usedItem.model.dto;

public class BuyerDTO extends Member {
	private String item;
	private String dealType;

	public BuyerDTO() {
	}

	public BuyerDTO(String id, String name, String phone, String loc, String grade, String item, String dealType) {
		super(id, name, phone, loc, grade);
		this.item = item;
		this.dealType = dealType;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDealType() {
		return dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("\n 6)°Å·¡ ¹°°Ç: ");
		builder.append(item);
		builder.append("\n 7)Èñ¸Á °Å·¡ À¯Çü: ");
		builder.append(dealType);
		return builder.toString();
	}

}
