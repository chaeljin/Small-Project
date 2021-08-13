package usedItem.view;

import java.util.ArrayList;

import usedItem.model.dto.UsedItemDTO;
import usedItem.model.dto.UsedItemUploadDTO;

public class RunEndView {

	public static void uploadListView(ArrayList allUsedItems) {
		if(allUsedItems != null) {
			int length = allUsedItems.size();

			if(length != 0 ){
				for(int index = 0; index < length; index++){			
					System.out.println("�˻����� " + (index+1) + "-" + allUsedItems.get(index));
				}
			} else {
				System.out.println("��û�Ͻ� ������ �����ϴ�\n");
			}
		} else {
			System.out.println("��û�Ͻ� ������ �����ϴ�\n");
		}
	}
	
	
	public static void uploadView(UsedItemUploadDTO upload){
		System.out.println(upload);		
	}

	public static void allView(Object data){
		if(data != null) {
			System.out.println(data);
		}else {
			System.out.println("��û�Ͻ� id�� �ش��ϴ� ������ �����ϴ�");
		}
	}
	
	public static void updateView(boolean result, String id) {
		if(result) {
			System.out.println("��û�Ͻ� " + id + " ���� �Ϸ�Ǿ����ϴ�");
		} else {
			System.out.println("��û�Ͻ� " + id + " ���� ����, id ��Ȯ���ϼ���.");
		}
	}
	
	public static void showError(String message){
		System.out.println(message);		
	}

}
