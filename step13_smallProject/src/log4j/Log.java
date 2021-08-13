package log4j;

import org.apache.log4j.Logger;

import usedItem.model.dto.UsedItemUploadDTO;

public class Log {
	static Logger logger = Logger.getLogger("log4j.Log");

	public static void uploadCheck(String message, UsedItemUploadDTO usedItemUpload) {
		if (message.equals("Success")) {
			logger.info("�ѤѤѻ��ο� ���� �ö�Խ��ϴ�. Ȯ�����ּ���.�ѤѤѤ�      \n\t\t\t--->�߰��� �ŷ� ����: " + usedItemUpload);
		}
	}
	public static void itemUpdateStatusCheck(String message, String usedItemId, String usedItemStatus) {
		if (message.equals("Success")) {
			logger.info("�ѤѤѹ����� ������ �����Ǿ����ϴ�. Ȯ�����ּ���.�ѤѤѤ�" + "    \n\t\t\t--->������ ���� ����: " + usedItemId +"���� ������ '" + usedItemStatus + "'���� �����Ǿ����ϴ�");
		}
	}
	public static void itemPriceUpdateCheck(String message, String usedItemId, String usedItemPrice) {
		
		if (message.equals("Success")) {
			logger.info("�ѤѤѹ����� ������ �����Ǿ����ϴ�. Ȯ�����ּ���.�ѤѤѤ�" + "    \\n\\t\\t\\t--->������ ���� ����: " + usedItemId + "���� ���°� " + usedItemPrice + "�� ����Ǿ����ϴ�.");
		}
	}
	public static void example(String usedItemId, String usedItemStatus) {
		logger.info(usedItemId + " " + usedItemStatus);
	}

}
