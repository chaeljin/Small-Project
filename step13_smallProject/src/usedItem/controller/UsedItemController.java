package usedItem.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import log4j.Log;
import usedItem.exception.NotExistException;
import usedItem.model.BuyerDAO;
import usedItem.model.SellerDAO;
import usedItem.model.UsedItemDAO;
import usedItem.model.UsedItemUploadDAO;
import usedItem.model.UsedItemService;
import usedItem.model.dto.UsedItemUploadDTO;
import usedItem.view.RunEndView;

public class UsedItemController {

	private static UsedItemController instance = new UsedItemController();

	private UsedItemController() {
	}

	public static UsedItemController getInstance() {
		return instance;
	}

	// 모든 중고거래 검색
	public static void getAllUsedItemUploads() {
		try {
			RunEndView.uploadListView(UsedItemUploadDAO.getAllUsedItemUploads());
		} catch (SQLException e) {
//			e.printStackTrace();
			RunEndView.showError("모든 중고 거래 검색 시 에러 발생");
		}
	}

	// 새로운 중고거래 저장
	public static boolean addUsedItemUpload(UsedItemUploadDTO usedItemUpload) {
		boolean result = false;

		try {
			result = UsedItemUploadDAO.addUsedItemUpload(usedItemUpload);
			Log.uploadCheck("Success", usedItemUpload);
		} catch (SQLException e) {
//			e.printStackTrace();
			RunEndView.showError("모든 중고 거래 저장 시 에러 발생");
		}
		return result;
	}

	// 모든 물건 검색
	public static void getAllUsedItems() {

		try {
			RunEndView.uploadListView(UsedItemDAO.getAllUsedItems());
		} catch (SQLException e) {
//			e.printStackTrace();
			RunEndView.showError("모든 물건 검색 시 에러가 발생");
		}
	}

	// 모든 판매자 검색
	public static void getAllSellers() {

		try {
			RunEndView.uploadListView(SellerDAO.getAllSellers());
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("모든 판매자 검색 시 에러가 발생");
		}
	}

	// 모든 구매자 검색
	public static void getAllBuyers() {

		try {
			RunEndView.uploadListView(BuyerDAO.getAllBuyers());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("모든 판매자 검색 시 에러가 발생");
		}
	}

	// 중고 물건 아이디로 물건 가격 수정
	public static void updateUsedItemPrice(String usedItemId, String usedItemPrice) {
		try {
			boolean r = UsedItemService.updateUsedItemPrice(usedItemId, usedItemPrice);
			RunEndView.updateView(r, usedItemId);
			Log.example(usedItemId, usedItemPrice);
		} catch (SQLException e) {
//			e.printStackTrace();
			RunEndView.showError("id확인 후 재시도");
		} catch (NotExistException e) {
//			e.printStackTrace();
			RunEndView.showError("id로 물건 가격 변경 오류");
		}
	}

	public static void updateUsedItemStatus(String usedItemId, String usedItemStatus) {
		try {
			boolean r = UsedItemService.updateUsedItemStatus(usedItemId, usedItemStatus);
			RunEndView.updateView(r, usedItemId);
			Log.itemPriceUpdateCheck("Success", usedItemId, usedItemStatus);
		} catch (SQLException e) {
//			e.printStackTrace();
			RunEndView.showError("id확인 후 재시도");
		} catch (NotExistException e) {
//			e.printStackTrace();
			RunEndView.showError("id로 물건 상태 변경 오류");
		}
	}

	// 중고 물건 아이디로 물건 검색
	public static void getUsedItem(String usedItemId) {

		try {
			RunEndView.allView(UsedItemDAO.getUsedItem(usedItemId));
		} catch (SQLException e) {
//			e.printStackTrace();
			RunEndView.showError("현재 ID로 중고 물건 거래 검색 오류");
		}
	}

	public void createMenu() {
		Scanner scan = new Scanner(System.in);
		BufferedReader search = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("       [[WELCOME!! 진 상 마 켓!!]]");

		boolean finish = false;
		while (!finish) {
			System.out.println("=====================================" + "\n       >>>원하는 항목을 선택 하세요<<<"
					+ "\n1. 모든 중고 거래 검색" + "\n2. 모든 중고 물건 검색" + "\n3. 특정 물건 검색" + "\n4. 모든 판매자 검색" + "\n5. 모든 구매자 검색"
					+ "\n6. 특정 물건 가격 수정 후 재검색" + "\n7. 특정 물건 거래 상태 수정 후 재검색" + "\n0. SYSTEM 종료"
					+ "\n=====================================\n");
			try {
				int number = scan.nextInt();

				if (number == 1) {
					System.out.println("       >>>모든 중고 거래 리스트입니다<<<");
					UsedItemController.getAllUsedItemUploads();
				}
				if (number == 2) {
					System.out.println("       >>>모든 중고 물건 리스트입니다<<<");
					UsedItemController.getAllUsedItems();
				}
				if (number == 3) {
					System.out.println("       >>물건의 ID를 입력하세요 :");
					String itemId = search.readLine();
					UsedItemController.getUsedItem(itemId);
				}
				if (number == 4) {
					System.out.println("모든 판매자 리스트입니다");
					UsedItemController.getAllBuyers();
				}
				if (number == 5) {
					System.out.println("모든 구매자 리스트입니다");
					UsedItemController.getAllSellers();
				}
				if (number == 6) {
					System.out.println("가격을 수정하고 싶은 물건의 ID를 입력하세요:");
					String itemId = search.readLine();
					System.out.println("수정하고 싶은 물건의 가격을 입력하세요:");
					String itemPrice = search.readLine();
					UsedItemController.updateUsedItemPrice(itemId, itemPrice);
					UsedItemController.getUsedItem(itemId);
				}
				if (number == 7) {
					System.out.println("거래 상태를 수정하고 싶은 물건의 ID를 입력하세요:");
					String itemId = search.readLine();
					System.out.println("수정하고 싶은 물건의 거래 상태를 입력하세요(판매중/예약중/판매완료):");
					String itemStatus = search.readLine();
					UsedItemController.updateUsedItemStatus(itemId, itemStatus);
					UsedItemController.getUsedItem(itemId);
				}
				if (number == 0) {
					finish = true;
					System.out.println("안녕~");
				}
			} catch (Exception e) {
				System.out.println("검색 결과는 존재하지 않습니다.");
				break;
			}
		}
		scan.close();
		try {
			search.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
