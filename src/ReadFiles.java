import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
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

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E, MMM d H:mm:ss z uuuu", Locale.UK);
			String inputDate = lineScanner.next();
			ZonedDateTime lastLogin = ZonedDateTime.parse(inputDate, dtf);

			String imagePath = lineScanner.next();

			Address add = new Address(add1, add2, add3, add4, postcode);

			User user = new User(username, firstName, lastName, telNo, add, lastLogin, imagePath);
			BSTNode node = new BSTNode(user);
			userTree.addNode(node);
			lineScanner.close();
		}
		in.close();

		return userTree;
	}

//	public BST readAuctions(BST userTree, BST artTree) {
//		File inputFile = new File("auctions.txt");
//		Scanner in = null;
//
//		try {
//			in = new Scanner(inputFile);
//		} catch (FileNotFoundException e) {
//			System.out.println("oops");
//		}
//
//		BST auctTree = new BST();
//
//		while (in.hasNextLine()) {
//			String currLine = in.nextLine();
//			Scanner lineScanner = new Scanner(currLine);
//			lineScanner.useDelimiter(";");
//			String sellName= lineScanner.next();
//			User seller = null;
//			ArrayList<Sortable> userList = userTree.inOrderList();
//			for(Sortable user : userList){
//				if(((User) user).getUsername().equals(sellName)){
//					seller = (User) user;
//				}
//			}
//			String artworks = lineScanner.next();
//			Artwork artName = null;
//			ArrayList<Sortable> artList = artTree.inOrderList();
//			for(Sortable art : artList){
//				if(((Artwork) art).getTitle().equals(artworks)){
//					artName = (Artwork) art;
//				}
//			}
//			int bidNum = lineScanner.nextInt();
//			double resPrice = lineScanner.nextDouble();
//			boolean hasEnd = lineScanner.nextBoolean();
//			Double bidAmount = lineScanner.nextDouble();
//			String bidderNameString = lineScanner.next();
//			User bidderName = null;
//			for(Sortable users : userList){
//				if(((User) users).getUsername() == bidderNameString){
//					bidderName = (User) users;
//				}
//			}
//			long bidTimeString = lineScanner.nextLong();
//			Time bidTime = new Time(bidTimeString);
//
//			Auction auct = new Auction(seller, artName, bidNum, resPrice, hasEnd);
//			Bid newBid = new Bid(bidAmount, bidderName, bidTime);
//			auct.getBidList().add(newBid);
//			BSTNode node = new BSTNode(auct);
//			auctTree.addNode(node);
//			lineScanner.close();
//		}
//		in.close();
//
//		return auctTree;
//	}
//
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
//			Artwork art;
			BSTNode node;
			if(type.equals("Painting")){
				Painting painting = new Painting(title, description, photoPath, creatorName, creationYear, width, height);

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
				Sculpture sculpture = new Sculpture(title, description, photoPath, creatorName,	creationYear, width, height, depth, mainMaterial, morePhotos);

				node = new BSTNode(sculpture);
				}
				artTree.addNode(node);
				lineScanner.close();
		}
		in.close();

		return artTree;
		}
	}