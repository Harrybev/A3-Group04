public class Main {
	public static void main(String[] args) {
		WriteFiles runTest = new WriteFiles();
		ReadFiles runTest2 = new ReadFiles();
		//runTest.writeUsers(runTest2.readUsers());
		//runTest.writeArtworks(runTest2.readArtworks());
		runTest.writeAuctions(runTest2.readAuctions(runTest2.readUsers(), runTest2.readArtworks()));
	}
}