import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ReadFiles {
	public static BST readUsers() {
		File inputFile = new File("users.txt");
		Scanner in = null;

		try {
			in = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("oops");
		}

		BST userTree = new BST();

		while (in.hasNextLine()) {
			String currLine = in.nextLine();
			Scanner lineScanner = new Scanner(currLine);
			lineScanner.useDelimiter(";");
			String username = lineScanner.next();
			String firstName = lineScanner.next();
			String lastName = lineScanner.next();
			String telNo = lineScanner.next();
			String add1 = lineScanner.next();
			String add2 = lineScanner.next();
			String add3 = lineScanner.next();
			String add4 = lineScanner.next();
			String postcode = lineScanner.next();

			String imagePath = lineScanner.next();

			Address add = new Address(add1, add2, add3, add4, postcode);

			User user = new User(username, firstName, lastName, telNo, add, imagePath);
			BSTNode node = new BSTNode(user);
			userTree.addNode(node);

			lineScanner.close();
		}
		in.close();

		populateFavourites(userTree);

		return userTree;
	}

	private static void populateFavourites(BST userTree) {
		File inputFile = new File("users.txt");
		Scanner in = null;

		try {
			in = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("oops");
		}

		while (in.hasNextLine()) {

			String currLine = in.nextLine();
			Scanner lineScanner = new Scanner(currLine);
			lineScanner.useDelimiter(";");
			String username = lineScanner.next();

			lineScanner.next();
			lineScanner.next();
			lineScanner.next();
			lineScanner.next();
			lineScanner.next();
			lineScanner.next();
			lineScanner.next();
			lineScanner.next();
			lineScanner.next();

			User currentUser = (User) userTree.searchBST(username).getSortable();

			ArrayList<User> favouriteList = new ArrayList<>();
			while (lineScanner.hasNext()) {
				String favouriteName = lineScanner.next();
				User favouriteUser = (User) userTree.searchBST(favouriteName).getSortable();

				favouriteList.add(favouriteUser);
			}
			currentUser.setFavouriteUsers(favouriteList);
		}
		in.close();
	}

	public static BST readAuctions(BST userTree, BST artTree) {
		File inputFile = new File("auctions.txt");
		Scanner in = null;

		try {
			in = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("oops");
		}

		BST auctTree = new BST();

		while (in.hasNextLine()) {
			String currLine = in.nextLine();
			Scanner lineScanner = new Scanner(currLine);
			lineScanner.useDelimiter(";");
			String sellName= lineScanner.next();
			User seller = null;
			ArrayList<Sortable> userList = userTree.inOrderList();
			for(Sortable s : userList){
				User user =  (User) s;
				if(user.getUsername().equals(sellName)){
					seller = user;
				}
			}
			String artwork = lineScanner.next();
			Artwork artName = null;
			ArrayList<Sortable> artList = artTree.inOrderList();
			for(Sortable art : artList){
				if(((Artwork) art).getTitle().equals(artwork)){
					artName = (Artwork) art;
				}
			}
			int bidNum = lineScanner.nextInt();
			double resPrice = lineScanner.nextDouble();
			boolean hasEnd = lineScanner.nextBoolean();

			ArrayList<Bid> bidList = new ArrayList<>();
			// if there are bids on the auction
			while (lineScanner.hasNext()) {
				Double bidAmount = lineScanner.nextDouble();
				String bidderNameString = lineScanner.next();
				User bidderName = null;
				for (Sortable users : userList) {
					if (((User) users).getUsername().equals(bidderNameString)) {
						bidderName = (User) users;
					}
				}

				LocalDateTime bidTime = LocalDateTime.parse(lineScanner.next());

				Bid newBid = new Bid(bidAmount, bidderName, bidTime);
				bidList.add(newBid);
			}

			Auction auct = new Auction(seller, artName, bidNum, resPrice, hasEnd);
			auct.setBidList(bidList);
			BSTNode node = new BSTNode(auct);
			auctTree.addNode(node);
			lineScanner.close();
		}
		in.close();

		return auctTree;
	}

	public static BST readArtworks() {
		File inputFile = new File("artworks.txt");
		Scanner in = null;

		try {
			in = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("oops");
		}

		BST artTree = new BST();

		while (in.hasNextLine()) {
			String currLine = in.nextLine();
			Scanner lineScanner = new Scanner(currLine);
			lineScanner.useDelimiter(";");
			String type = lineScanner.next();
			String title = lineScanner.next();
			String description = lineScanner.next();
			String photoPath = lineScanner.next();
			String creatorName = lineScanner.next();
			int creationYear = lineScanner.nextInt();
			double width = lineScanner.nextDouble();
			double height = lineScanner.nextDouble();
			BSTNode node;
			if(type.equals("Painting")){
				Painting painting = new Painting(title, type, description,
						photoPath, creatorName, creationYear, width, height);

				node = new BSTNode(painting);
			}else{
				double depth = lineScanner.nextDouble();
				String mainMaterial = lineScanner.next();
				String photoString = lineScanner.next();
				ArrayList<String> morePhotos = new ArrayList<String>();
				if(photoString.contains(",")){
					 String[] newString = photoString.split(",");
					 for(String elem : newString){
						 morePhotos.add(elem);
					 	}
					 }else{
						 morePhotos.add(photoString);
					 }
				Sculpture sculpture = new Sculpture(title, type,  description,
						photoPath, creatorName,	creationYear, width, height, depth, mainMaterial, morePhotos);

				node = new BSTNode(sculpture);
				}
				artTree.addNode(node);
				lineScanner.close();
		}
		in.close();

		return artTree;
		}
	}