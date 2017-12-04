import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Information from a text file is read into a Generated Tree
 * 
 * @author Harry Bevan
 * @version 1.3
 */
public class ReadFiles {
	/**
	 * User information is read into a BST
	 * 
	 * @return The tree of users generated
	 */
	public BST readUsers() {
		// The input file is set to the text file of users
		File inputFile = new File("users.txt");
		Scanner in = null;

		// If the file is not found then an error is thrown
		try {
			in = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("oops");
		}

		// A Tree of users is created.
		BST userTree = new BST();

		// The Scanner looks at each "Line" using a known delimiter to separate
		// the variables.
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

			// A Date object of the given format is created.
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E, MMM d H:mm:ss z uuuu", Locale.UK);
			String inputDate = lineScanner.next();
			ZonedDateTime lastLogin;
			try{
			lastLogin = ZonedDateTime.parse(inputDate, dtf);}catch(DateTimeParseException e){
				lastLogin = ZonedDateTime.parse(inputDate);
			}

			String imagePath = lineScanner.next();

			// An Address object is created.
			Address add = new Address(add1, add2, add3, add4, postcode);

			// A user object is created with the information read in which is
			// then used to create a node and added to the Tree.
			User user = new User(username, firstName, lastName, telNo, add, lastLogin, imagePath);
			BSTNode node = new BSTNode(user);
			userTree.addNode(node);
			// The scanner of the line is then closed.
			lineScanner.close();
		}
		// The scanner of the file is then closed and a tree of users is
		// returned.
		in.close();

		return userTree;
	}

	/**
	 * Auctions from a text file is read into a BST.
	 * 
	 * @param userTree
	 *            a BST of users.
	 * @param artTree
	 *            a BST of artworks.
	 * @return a BST of auctions
	 */
	public BST readAuctions(BST userTree, BST artTree) {
		// The file to be read from is set to the auctions text file.
		File inputFile = new File("auctions.txt");
		Scanner in = null;

		// If there is no file to be found an error occurs.
		try {
			in = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("oops");
		}

		// A BST of auctions is created.
		BST auctTree = new BST();

		// A scanner iterates through the file.
		while (in.hasNextLine()) {
			// Sets each variable to a bit of the line.
			String currLine = in.nextLine();
			Scanner lineScanner = new Scanner(currLine);
			lineScanner.useDelimiter(";");
			String sellName = lineScanner.next();
			User seller = null;
			// Checks to see if the seller is a user on the tree of current
			// users.
			ArrayList<Sortable> userList = userTree.inOrderList();
			for (Sortable user : userList) {
				if (((User) user).getUsername().equals(sellName)) {
					seller = (User) user;
				}
			}
			String artworks = lineScanner.next();
			Artwork artName = null;
			// Checks to see if the artwork is in the tree of artworks available
			ArrayList<Sortable> artList = artTree.inOrderList();
			for (Sortable art : artList) {
				if (((Artwork) art).getTitle().equals(artworks)) {
					artName = (Artwork) art;
				}
			}
			int bidNum = lineScanner.nextInt();
			double resPrice = lineScanner.nextDouble();
			boolean hasEnd = lineScanner.nextBoolean();
			Auction auct = new Auction(seller, artName, bidNum, resPrice, hasEnd);
			while(lineScanner.hasNext()){
				Double bidAmount = lineScanner.nextDouble();
				String bidderNameString = lineScanner.next();
				User bidderName = null;
				// Checks to set the bidders name to that of the inputted string.
				for (Sortable users : userList) {
					if (((User) users).getUsername().equals(bidderNameString)) {
						bidderName = (User) users;
					}
				}
				long bidTimeString = lineScanner.nextLong();
				Time bidTime = new Time(bidTimeString);
				// An auction and a bid is created using the read in file.
				Bid newBid = new Bid(bidAmount, bidderName, bidTime);
				auct.getBidList().add(newBid);
			}

			// A node is created with the auction and is added to a tree.
			BSTNode node = new BSTNode(auct);
			auctTree.addNode(node);
			// The scanner of the line is closed.
			lineScanner.close();
		}
		// The Scanner of the file is closed.
		in.close();

		return auctTree;
	}

	/**
	 * Information from a text file is read into a tree.
	 * 
	 * @return BST of artworks.
	 */
	public BST readArtworks() {
		// An artwork text file is set as the input.
		File inputFile = new File("artworks.txt");
		Scanner in = null;

		try {
			in = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
		}

		BST artTree = new BST();

		// The File is iterated through.
		while (in.hasNextLine()) {
			// Variables are set via the scanner of the current line.
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
			// The artwork read from the file is then created into either a
			// sculpture or a painting depending on the type.
			Artwork art;
			if (type.equals("Painting")) {
				art = new Painting(title, description, photoPath, creatorName, creationYear, width, height, type);
			} else {
				double depth = lineScanner.nextDouble();
				String mainMaterial = lineScanner.next();
				String photoString = lineScanner.next();
				// More photos are set via a string splitting techniwue.
				ArrayList<String> morePhotos = new ArrayList<String>();
				if (photoString.contains(",")) {
					String[] newString = photoString.split(",");
					for (String elem : newString) {
						morePhotos.add(elem);
					}
				} else {
					morePhotos.add(photoString);
				}
				art = new Sculpture(title, description, photoPath, creatorName, creationYear, width, height, depth,
						mainMaterial, morePhotos, type);
			}
			// The node created from the information of the node is added to the
			// tree of art.
			BSTNode node = new BSTNode(art);
			artTree.addNode(node);
			// The line scanner is closed.
			lineScanner.close();
		}
		// The scanner of the file is closed.
		in.close();

		return artTree;
	}
}
