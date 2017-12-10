import java.io.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class WriteFiles {
	public static void writeUsers(BST userTree) {
		File outputFile = new File("users.txt");
		FileWriter out = null;
		try {
			out = new FileWriter(outputFile);
		} catch (IOException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		ArrayList<Sortable> userList = userTree.inOrderList();
		for (Sortable elem : userList) {
			User user = (User)elem;
			String username = user.getUsername();
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			String telephoneNumber = user.getTelephoneNumber();
			String address1 = user.getAddress().getAddress1();
			String address2 = user.getAddress().getAddress2();
			String address3 = user.getAddress().getAddress3();
			String address4 = user.getAddress().getAddress4();
			String postcode = user.getAddress().getPostCode();
			String profileImagePath = user.getProfileImagePath();
			String favouriteUsers = "";
			if (!user.getFavouriteUsers().isEmpty()) {
				for (User favouriteUser : user.getFavouriteUsers()) {
					favouriteUsers += favouriteUser.getUsername() + ";";
				}
			}
			try {
				out.write(username + ";" + firstName + ";" + lastName + ";"
						+ telephoneNumber + ";" + address1 + ";"
						+ address2 + ";" + address3 + ";" + address4 + ";" + postcode + ";" + profileImagePath + ";" + favouriteUsers + "\n");

			} catch (IOException e) {
				System.out.println("This Error!");
			}
		}
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public void writeArtworks(BST artworkTree) {
//		File outputFile = new File("artworks.txt");
//		FileWriter out = null;
//		try {
//			out = new FileWriter(outputFile, true);
//		} catch (IOException e) {
//			System.out.println("File not found.");
//			System.exit(0);
//		}
//		ArrayList<Sortable> artList = artworkTree.inOrderList();
//		for (Sortable elem : artList) {
//				Artwork artwork = (Artwork)elem;
//				String type = artwork.getType();
//				String title = artwork.getTitle();
//				String description = artwork.getDescription();
//				String photoPath = artwork.getPhotoPath();
//				String creatorName = artwork.getCreatorName();
//				int creationYear = artwork.getCreationYear();
//				Double width = artwork.getWidth();
//				Double height = artwork.getHeight();
//				double depth = 0.0;
//				String mainMat = "Not Available";
//				ArrayList<String> morePhotos = new ArrayList<String>();
//				if(artwork.getType().equals("Sculpture")){
//					depth = ((Sculpture)artwork).getDepth();
//					mainMat = ((Sculpture)artwork).getMainMaterial();
//					morePhotos = ((Sculpture)artwork).getAdditionalPhotosList();
//				}
//				System.out.println("Type: " + type + " Title: " + title + " Description: " + description + " PhotoPath: " + photoPath + " Creator Name: " + creatorName + " Creation Year: " + creationYear + " Width: " + width + " Height: " + height + " Depth: " + depth + " Main Material: " + mainMat + " MorePhotos " + morePhotos);
//
//			try {
//				out.write(type + ";" + title + ";" + description + ";" + photoPath + ";" + creatorName + ";" + creationYear + ";"
//						+ width + ";" + height + ";" + depth + ";" + mainMat + ";" + morePhotos + ";");
//			} catch (IOException e) {
//				System.out.println("Error!");
//			}
//		}
//		try {
//			out.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

//	public void writeAuctions(BST auctionTree) {
//		File outputFile = new File("auctions.txt");
//		FileWriter out = null;
//		try {
//			out = new FileWriter(outputFile, true);
//		} catch (IOException e) {
//			System.out.println("File not found.");
//			System.exit(0);
//		}
//		ArrayList<Sortable> aucList = auctionTree.inOrderList();
//		for (Sortable elem : aucList) {
//				Auction auction = (Auction)elem;
//				User seller = auction.getSeller();
//				Artwork artwork = auction.getArtwork();
//				int numberOfBids = auction.getNumberOfBids();
//				Double reservePrice = auction.getReservePrice();
//				ArrayList<Bid> bidList = auction.getBidList();
//				Boolean hasEnded = auction.isHasEnded();
//
//			try {
//				out.write(seller + ";" + artwork + ";" + numberOfBids + ";" + reservePrice + ";" + bidList + ";"
//						+ hasEnded + ";");
//				out.close();
//			} catch (IOException e) {
//				System.out.println("Error!");
//			}
//			System.out.println("Seller: " + seller.getUsername() + " Artwork: " + artwork.getTitle() + " NumOfBids: " + numberOfBids + " ReservePrice: " + reservePrice + " BidList: " + bidList + " hasEnded: " + hasEnded);
//		}
//	}
}
