package log4j;

import org.apache.log4j.Logger;

import usedItem.model.dto.UsedItemUploadDTO;

public class Log {
	static Logger logger = Logger.getLogger("log4j.Log");

	public static void uploadCheck(String message, UsedItemUploadDTO usedItemUpload) {
		if (message.equals("Success")) {
			logger.info("ㅡㅡㅡ새로운 글이 올라왔습니다. 확인해주세요.ㅡㅡㅡㅡ      \n\t\t\t--->추가된 거래 내역: " + usedItemUpload);
		}
	}
	public static void itemUpdateStatusCheck(String message, String usedItemId, String usedItemStatus) {
		if (message.equals("Success")) {
			logger.info("ㅡㅡㅡ물건의 정보가 수정되었습니다. 확인해주세요.ㅡㅡㅡㅡ" + "    \n\t\t\t--->수정된 가격 정보: " + usedItemId +"물건 가격이 '" + usedItemStatus + "'으로 수정되었습니다");
		}
	}
	public static void itemPriceUpdateCheck(String message, String usedItemId, String usedItemPrice) {
		
		if (message.equals("Success")) {
			logger.info("ㅡㅡㅡ물건의 정보가 수정되었습니다. 확인해주세요.ㅡㅡㅡㅡ" + "    \\n\\t\\t\\t--->수정된 상태 정보: " + usedItemId + "물건 상태가 " + usedItemPrice + "로 변경되었습니다.");
		}
	}
	public static void example(String usedItemId, String usedItemStatus) {
		logger.info(usedItemId + " " + usedItemStatus);
	}

}
