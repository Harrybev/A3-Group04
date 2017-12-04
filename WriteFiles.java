<<<<<<< HEAD
import java.io.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * Reads information off of construct BST's and writes information to a text
 * file.
 * 
 * @author Harry Bevan
 * @version 1.3
 */
public class WriteFiles {
	/**
	 * Writes out information from a sorted tree of Users to the user text file.
	 * 
	 * @param userTree
	 *            A tree of users.
	 */
	public void writeUsers(BST userTree) {
		// Gets user file to write out to.
		File outputFile = new File("users.txt");
		FileWriter out = null;
		// If the file is not found an error occurs.
		try {
			out = new FileWriter(outputFile, true);
		} catch (IOException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		// Goes through the sorted list of users.
		ArrayList<Sortable> userList = userTree.inOrderList();
		for (Sortable elem : userList) {
			// Assigns variables to write out to each variable of the User.
			User user = (User) elem;
			String username = user.getUsername();
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			String telephoneNumber = user.getTelephoneNumber();
			String address1 = user.getAddress().getAddress1();
			String address2 = user.getAddress().getAddress2();
			String address3 = user.getAddress().getAddress3();
			String address4 = user.getAddress().getAddress4();
			String postcode = user.getAddress().getPostCode();
			ZonedDateTime lastLogin = user.getLastLoginTime();
			String profileImagePath = user.getProfileImagePath();

			// Writes out the information to the file (If this is not possible
			// an error occurs).
			try {
				out.write("\n" + username + ";" + firstName + ";" + lastName + ";" + telephoneNumber + ";" + address1
						+ ";" + address2 + ";" + address3 + ";" + address4 + ";" + postcode + ";" + lastLogin + ";"
						+ profileImagePath + ";");
			} catch (IOException e) {
				System.out.println("Output error!");
			}

			// Testing print statements to the system.
			System.out.println("Username: " + username + " FirstName: " + firstName + " LastName: " + lastName
					+ " TelePhone Number: " + telephoneNumber + " Address1: " + address1 + " Address2: " + address2
					+ " Address3: " + address3 + " Address4: " + address4 + " Postcode: " + postcode + " LastLogin: "
					+ lastLogin + " Profile Image Path: " + profileImagePath);
		}
		// closes the file (if this cannot be done an error occurs).
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes out information from a sorted tree of Users to the user text file.
	 * 
	 * @param artworkTree
	 *            A tree of Artworks to be wrote to.
	 */
	public void writeArtworks(BST artworkTree) {
		// Sets the output file to the artworks text file if this can't be done
		// an error occurs
		File outputFile = new File("artworks.txt");
		FileWriter out = null;
		try {
			out = new FileWriter(outputFile, true);
		} catch (IOException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		// Looks at all of the sorted artworks.
		ArrayList<Sortable> artList = artworkTree.inOrderList();
		for (Sortable elem : artList) {
			// Sets the outgoing variables to the variables of the Artwork
			Artwork artwork = (Artwork) elem;
			String type = artwork.getType();
			String title = artwork.getTitle();
			String description = artwork.getDescription();
			String photoPath = artwork.getPhotoPath();
			String creatorName = artwork.getCreatorName();
			int creationYear = artwork.getCreationYear();
			Double width = artwork.getWidth();
			Double height = artwork.getHeight();
			// Sets dummy values to be set when a sculpture is detected
			double depth = 0.0;
			String mainMat = "Not Available";
			ArrayList<String> morePhotos = new ArrayList<String>();
			// If the artwork is a Sculpture
			if (artwork.getType().equals("Sculpture")) {
				// The variables are reassigned to actual values
				depth = ((Sculpture) artwork).getDepth();
				mainMat = ((Sculpture) artwork).getMainMaterial();
				morePhotos = ((Sculpture) artwork).getAdditionalPhotosList();
			}
			// Testing Strings to make sure it works
			System.out.println("Type: " + type + " Title: " + title + " Description: " + description + " PhotoPath: "
					+ photoPath + " Creator Name: " + creatorName + " Creation Year: " + creationYear + " Width: "
					+ width + " Height: " + height + " Depth: " + depth + " Main Material: " + mainMat + " MorePhotos "
					+ morePhotos);
			// Conditional clause dictates which way the file is wrote out to
			// according to the artworks type.
			try {
				if (artwork.getType().equals("Sculpture")) {
					out.write("\n" + type + ";" + title + ";" + description + ";" + photoPath + ";" + creatorName + ";"
							+ creationYear + ";" + width + ";" + height + ";" + depth + ";" + mainMat + ";" + morePhotos
							+ ";");
				} else {
					out.write("\n" + type + ";" + title + ";" + description + ";" + photoPath + ";" + creatorName + ";"
							+ creationYear + ";" + width + ";" + height + ";");
				}
			} catch (IOException e) {
				System.out.println("Error!");
			}
		}
		// The file stream is then closed
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes out to a file the information from each Auction in the tree of
	 * Auctions
	 * 
	 * @param auctionTree
	 *            A sorted tree of auctions.
	 */
	public void writeAuctions(BST auctionTree) {
		// The file that is written to is set to the text file of auctions.
		File outputFile = new File("auctions.txt");
		FileWriter out = null;
		try {
			out = new FileWriter(outputFile, true);
		} catch (IOException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		// The sorted tree of auctions is iterated through
		ArrayList<Sortable> aucList = auctionTree.inOrderList();
		for (Sortable elem : aucList) {
			// The output variables are set to the variables of the Auction.
			Auction auction = (Auction) elem;
			User seller = auction.getSeller();
			Artwork artwork = auction.getArtwork();
			int numberOfBids = auction.getNumberOfBids();
			Double reservePrice = auction.getReservePrice();
			ArrayList<Bid> bidList = auction.getBidList();
			Boolean hasEnded = auction.isHasEnded();

			// The variables are outputted onto the file one way if there are bids and another if not.
			if (bidList.isEmpty()) {
				try {
					out.write("\n" + seller.getUsername() + ";" + artwork.getTitle() + ";" + numberOfBids + ";"+ reservePrice + ";" + hasEnded + ";");
				} catch (IOException e) {
					System.out.println("Incorrect input");
				}
				// Strings to test the output of this function.
				System.out.println("Seller: " + seller.getUsername() + " Artwork: " + artwork.getTitle()
						+ " NumOfBids: " + numberOfBids + " ReservePrice: " + reservePrice + " hasEnded: " + hasEnded);
			} else {
				try {
					out.write("\n" + seller.getUsername() + ";" + artwork.getTitle() + ";" + numberOfBids + ";"
							+ reservePrice + ";" + hasEnded + toString(bidList) + ";");
				} catch (IOException e) {
					System.out.println("i dont even know anymore");
				}
				System.out.println("Seller: " + seller.getUsername() + " Artwork: " + artwork.getTitle()
						+ " NumOfBids: " + numberOfBids + " ReservePrice: " + reservePrice + " BidList: "
						+ toString(bidList) + " hasEnded: " + hasEnded);
			}
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String toString(ArrayList<Bid> bidList) {
		String printOut = ";";
		for (Bid elem : bidList) {
			printOut = printOut + elem.getBidAmount() + ";" + elem.getBidder().getUsername() + ";" + elem.getBidTime();
		}
		return printOut;
	}
}
