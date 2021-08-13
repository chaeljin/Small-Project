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

	// ��� �߰�ŷ� �˻�
	public static void getAllUsedItemUploads() {
		try {
			RunEndView.uploadListView(UsedItemUploadDAO.getAllUsedItemUploads());
		} catch (SQLException e) {
//			e.printStackTrace();
			RunEndView.showError("��� �߰� �ŷ� �˻� �� ���� �߻�");
		}
	}

	// ���ο� �߰�ŷ� ����
	public static boolean addUsedItemUpload(UsedItemUploadDTO usedItemUpload) {
		boolean result = false;

		try {
			result = UsedItemUploadDAO.addUsedItemUpload(usedItemUpload);
			Log.uploadCheck("Success", usedItemUpload);
		} catch (SQLException e) {
//			e.printStackTrace();
			RunEndView.showError("��� �߰� �ŷ� ���� �� ���� �߻�");
		}
		return result;
	}

	// ��� ���� �˻�
	public static void getAllUsedItems() {

		try {
			RunEndView.uploadListView(UsedItemDAO.getAllUsedItems());
		} catch (SQLException e) {
//			e.printStackTrace();
			RunEndView.showError("��� ���� �˻� �� ������ �߻�");
		}
	}

	// ��� �Ǹ��� �˻�
	public static void getAllSellers() {

		try {
			RunEndView.uploadListView(SellerDAO.getAllSellers());
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("��� �Ǹ��� �˻� �� ������ �߻�");
		}
	}

	// ��� ������ �˻�
	public static void getAllBuyers() {

		try {
			RunEndView.uploadListView(BuyerDAO.getAllBuyers());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��� �Ǹ��� �˻� �� ������ �߻�");
		}
	}

	// �߰� ���� ���̵�� ���� ���� ����
	public static void updateUsedItemPrice(String usedItemId, String usedItemPrice) {
		try {
			boolean r = UsedItemService.updateUsedItemPrice(usedItemId, usedItemPrice);
			RunEndView.updateView(r, usedItemId);
			Log.example(usedItemId, usedItemPrice);
		} catch (SQLException e) {
//			e.printStackTrace();
			RunEndView.showError("idȮ�� �� ��õ�");
		} catch (NotExistException e) {
//			e.printStackTrace();
			RunEndView.showError("id�� ���� ���� ���� ����");
		}
	}

	public static void updateUsedItemStatus(String usedItemId, String usedItemStatus) {
		try {
			boolean r = UsedItemService.updateUsedItemStatus(usedItemId, usedItemStatus);
			RunEndView.updateView(r, usedItemId);
			Log.itemPriceUpdateCheck("Success", usedItemId, usedItemStatus);
		} catch (SQLException e) {
//			e.printStackTrace();
			RunEndView.showError("idȮ�� �� ��õ�");
		} catch (NotExistException e) {
//			e.printStackTrace();
			RunEndView.showError("id�� ���� ���� ���� ����");
		}
	}

	// �߰� ���� ���̵�� ���� �˻�
	public static void getUsedItem(String usedItemId) {

		try {
			RunEndView.allView(UsedItemDAO.getUsedItem(usedItemId));
		} catch (SQLException e) {
//			e.printStackTrace();
			RunEndView.showError("���� ID�� �߰� ���� �ŷ� �˻� ����");
		}
	}

	public void createMenu() {
		Scanner scan = new Scanner(System.in);
		BufferedReader search = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("       [[WELCOME!! �� �� �� ��!!]]");

		boolean finish = false;
		while (!finish) {
			System.out.println("=====================================" + "\n       >>>���ϴ� �׸��� ���� �ϼ���<<<"
					+ "\n1. ��� �߰� �ŷ� �˻�" + "\n2. ��� �߰� ���� �˻�" + "\n3. Ư�� ���� �˻�" + "\n4. ��� �Ǹ��� �˻�" + "\n5. ��� ������ �˻�"
					+ "\n6. Ư�� ���� ���� ���� �� ��˻�" + "\n7. Ư�� ���� �ŷ� ���� ���� �� ��˻�" + "\n0. SYSTEM ����"
					+ "\n=====================================\n");
			try {
				int number = scan.nextInt();

				if (number == 1) {
					System.out.println("       >>>��� �߰� �ŷ� ����Ʈ�Դϴ�<<<");
					UsedItemController.getAllUsedItemUploads();
				}
				if (number == 2) {
					System.out.println("       >>>��� �߰� ���� ����Ʈ�Դϴ�<<<");
					UsedItemController.getAllUsedItems();
				}
				if (number == 3) {
					System.out.println("       >>������ ID�� �Է��ϼ��� :");
					String itemId = search.readLine();
					UsedItemController.getUsedItem(itemId);
				}
				if (number == 4) {
					System.out.println("��� �Ǹ��� ����Ʈ�Դϴ�");
					UsedItemController.getAllBuyers();
				}
				if (number == 5) {
					System.out.println("��� ������ ����Ʈ�Դϴ�");
					UsedItemController.getAllSellers();
				}
				if (number == 6) {
					System.out.println("������ �����ϰ� ���� ������ ID�� �Է��ϼ���:");
					String itemId = search.readLine();
					System.out.println("�����ϰ� ���� ������ ������ �Է��ϼ���:");
					String itemPrice = search.readLine();
					UsedItemController.updateUsedItemPrice(itemId, itemPrice);
					UsedItemController.getUsedItem(itemId);
				}
				if (number == 7) {
					System.out.println("�ŷ� ���¸� �����ϰ� ���� ������ ID�� �Է��ϼ���:");
					String itemId = search.readLine();
					System.out.println("�����ϰ� ���� ������ �ŷ� ���¸� �Է��ϼ���(�Ǹ���/������/�ǸſϷ�):");
					String itemStatus = search.readLine();
					UsedItemController.updateUsedItemStatus(itemId, itemStatus);
					UsedItemController.getUsedItem(itemId);
				}
				if (number == 0) {
					finish = true;
					System.out.println("�ȳ�~");
				}
			} catch (Exception e) {
				System.out.println("�˻� ����� �������� �ʽ��ϴ�.");
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
