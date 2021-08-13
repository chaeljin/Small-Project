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
					System.out.println("검색정보 " + (index+1) + "-" + allUsedItems.get(index));
				}
			} else {
				System.out.println("요청하신 정보는 없습니다\n");
			}
		} else {
			System.out.println("요청하신 정보는 없습니다\n");
		}
	}
	
	
	public static void uploadView(UsedItemUploadDTO upload){
		System.out.println(upload);		
	}

	public static void allView(Object data){
		if(data != null) {
			System.out.println(data);
		}else {
			System.out.println("요청하신 id에 해당하는 정보가 없습니다");
		}
	}
	
	public static void updateView(boolean result, String id) {
		if(result) {
			System.out.println("요청하신 " + id + " 수정 완료되었습니다");
		} else {
			System.out.println("요청하신 " + id + " 수정 실패, id 재확인하세요.");
		}
	}
	
	public static void showError(String message){
		System.out.println(message);		
	}

}
