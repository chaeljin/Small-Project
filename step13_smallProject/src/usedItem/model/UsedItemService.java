package usedItem.model;

import java.sql.SQLException;
import java.util.ArrayList;

import usedItem.exception.NotExistException;
import usedItem.model.dto.BuyerDTO;
import usedItem.model.dto.SellerDTO;
import usedItem.model.dto.UsedItemDTO;
import usedItem.model.dto.UsedItemUploadDTO;

public class UsedItemService {

	private static UsedItemService instance = new UsedItemService();

	private UsedItemService() {
	}

	public static UsedItemService getInstance() {
		return instance;
	}

	// 중고 물건 - CRUD
	public static void notExistUsedItem(String usedItemId) throws SQLException, NotExistException {
		UsedItemDTO usedItem = UsedItemDAO.getUsedItem(usedItemId);
		if (usedItem == null) {
			throw new NotExistException("검색하신 중고 물건이 없습니다.");
		}
	}

	// 모든 거래 정보 반환
	public static ArrayList<UsedItemDTO> getAllUsedItems() throws SQLException {
		return UsedItemDAO.getAllUsedItems();
	}

	// 물건 ID로 검색
	public static UsedItemDTO getUsedItem(String usedItemId) throws SQLException, NotExistException {
		UsedItemDTO usedItem = UsedItemDAO.getUsedItem(usedItemId);
		if (usedItem == null) {
			throw new NotExistException("검색하신 물건 정보가 없습니다.");
		}
		return usedItem;
	}

	// 새로운 물건 저장
	public static boolean addUsedItem(UsedItemDTO usedItem) throws SQLException {
		return UsedItemDAO.addUsedItem(usedItem);
	}

	// 기존 물건 가격 수정
	public static boolean updateUsedItemPrice(String usedItemId, String usedItemPrice) throws NotExistException, SQLException {
		notExistUsedItem(usedItemId);
		return UsedItemDAO.updateUsedItemPrice(usedItemId, usedItemPrice);
	}
	
	// 기존 물건 거래 상태 수정
	public static boolean updateUsedItemStatus(String usedItemId, String dealStatus) throws NotExistException, SQLException {
		notExistUsedItem(usedItemId);
		return UsedItemDAO.updateDealStatus(usedItemId, dealStatus);
	}

	// 물건 삭제
	public boolean deleteUsedItem(String usedItemId) throws NotExistException, SQLException {
		notExistUsedItem(usedItemId);
		return UsedItemDAO.deleteUsedItem(usedItemId);
	}

	// 판매자 - CRUD
	public static void notExistSeller(String sellerId) throws NotExistException, SQLException {
		SellerDTO seller = SellerDAO.getSeller(sellerId);
		if (seller == null) {
			throw new NotExistException("검색하는 판매자가 존재하지 않습니다.");
		}
	}

	// 판매자 추가
	public static boolean addSeller(SellerDTO seller) throws NotExistException, SQLException {
		return SellerDAO.addSeller(seller);
	}

	// 기존 판매자 희망 거래 유형 수정
	public static boolean updateSeller(String sellerId, String dealType) throws NotExistException, SQLException {
		notExistUsedItem(sellerId);
		return SellerDAO.updateSeller(sellerId, dealType);
	}

	// 판매자 삭제
	public static boolean deleteSeller(String sellerId) throws NotExistException, SQLException {
		notExistSeller(sellerId);
		return SellerDAO.deleteSeller(sellerId);
	}

	// 판매자 ID로 검색
	public static SellerDTO getSeller(String sellerId) throws NotExistException, SQLException {
		SellerDTO seller = SellerDAO.getSeller(sellerId);
		if (seller == null) {
			throw new NotExistException("검색하는 판매자가 존재하지 않습니다.");
		}
		return seller;
	}

	public static ArrayList<SellerDTO> getAllSellers() throws NotExistException, SQLException {
		return SellerDAO.getAllSellers();
	}

	// 구매자 - CRUD
	public static void notExistBuyer(String buyerId) throws NotExistException, SQLException {
		BuyerDTO buyer = BuyerDAO.getBuyer(buyerId);
		if (buyer == null) {
			throw new NotExistException("검색하는 구매자가 존재하지 않습니다.");
		}
	}

	// 구매자 추가
	public static boolean addBuyer(BuyerDTO buyer) throws NotExistException, SQLException {
		return BuyerDAO.addBuyer(buyer);
	}

	// 기존 구매자 희망 거래 유형 수정
	public static boolean updateBuyer(String buyerId, String dealType) throws NotExistException, SQLException {
		notExistBuyer(buyerId);
		return BuyerDAO.updateBuyer(buyerId, dealType);
	}

	// 구매자 삭제
	public static boolean deleteBuyer(String buyerId) throws NotExistException, SQLException {
		notExistBuyer(buyerId);
		return BuyerDAO.deleteBuyer(buyerId);
	}

	// 구매자 ID로 검색
	public static BuyerDTO getBuyer(String buyerId) throws NotExistException, SQLException {
		BuyerDTO buyer = BuyerDAO.getBuyer(buyerId);
		if (buyer == null) {
			throw new NotExistException("검색하는 구매자가 존재하지 않습니다.");
		}
		return buyer;
	}

	public static ArrayList<BuyerDTO> getAllBuyers() throws NotExistException, SQLException {
		return BuyerDAO.getAllBuyers();
	}

	// UsedItemUserDAO - CRUD
	public static void notExistUsedItemUser(int usedItemUserId) throws NotExistException, SQLException {
		UsedItemUploadDTO usedItemUser = UsedItemUploadDAO.getUsedItemUpload(usedItemUserId);
		if (usedItemUser == null) {
			throw new NotExistException("검색하는 중고 거래가 없습니다.");
		}
	}

	public static boolean addUsedItemUser(UsedItemUploadDTO usedItemUser) throws NotExistException, SQLException {
		return UsedItemUploadDAO.addUsedItemUpload(usedItemUser);
	}

	public static boolean updateUsedItemUserSeller(int usedItemUserId, String sellerId) throws NotExistException, SQLException {
		notExistUsedItemUser(usedItemUserId);
		return UsedItemUploadDAO.updateUsedItemUploadSeller(usedItemUserId, sellerId);
	}

	public static boolean updateUsedItemUserBuyer(int usedItemUserId, String buyerId) throws NotExistException, SQLException {
		notExistUsedItemUser(usedItemUserId);
		return UsedItemUploadDAO.updateUsedItemUploadBuyer(usedItemUserId, buyerId);
	}

	public static boolean deleteUsedItemUser(int usedItemUserId) throws NotExistException, SQLException {
		notExistUsedItemUser(usedItemUserId);
		return UsedItemUploadDAO.deleteUsedItemUpload(usedItemUserId);
	}

	// 중고 물건 업로드 ID로 검색
	public static UsedItemUploadDTO getUsedItemUser(int usedItemUserId) throws NotExistException, SQLException {
		UsedItemUploadDTO usedItemUser = UsedItemUploadDAO.getUsedItemUpload(usedItemUserId);
		if (usedItemUser == null) {
			throw new NotExistException("검색하는 중고 물건에 해당하는 글이 없습니다.");
		}
		return usedItemUser;
	}

	public static ArrayList<UsedItemUploadDTO> getAllUsedItemUsers() throws NotExistException, SQLException {
		return UsedItemUploadDAO.getAllUsedItemUploads();
	}

}
