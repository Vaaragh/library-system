package models;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import controller.LoginController;
import controller.RegisterController;
import managers.AdminManager;
import view.LoginView;
import view.RegisterView;

public class Main {

	public static void main(String[] args) throws IOException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		// Program init
		AdminManager.getInstance().loadAdmins();
		if (AdminManager.getInstance().getAllAdmins().size()==0) {
			RegisterView rv = new RegisterView("Register");
			RegisterController rc = new RegisterController(rv);
			rc.initController();
		} else {
			LoginView lv = new LoginView("Login");
			LoginController lc = new LoginController(lv);
			lc.initController();
		}
//		
//		
//		// TEST BLOCK
//		System.out.println(Validator.isDateFormat("2020-02-20"));
//		System.out.println(Validator.isUUIDFormat(UUID.randomUUID().toString()));
//		System.out.println(Validator.isJmbgFormat("1234567890123"));
//		System.out.println(Validator.isNameFormat("Jean Luc"));
//		System.out.println(Validator.isNickFormat("JeanLuc23"));
//		System.out.println(Validator.isNumberFormat("1234"));
//		System.out.println(Validator.isPhoneFormat("+381641258240"));
//		System.out.println(Validator.isTimeFormat("00:01"));
//		System.out.println(Validator.isYearFormat("2000"));
//		System.out.println(Validator.isJmbgFormat("1234567890123"));
		
//		LocalDate last = LocalDate.of(2022, 6, 22);
//		LocalDate now = LocalDate.now();
//		System.out.println((now.toEpochDay()- last.toEpochDay()));
		
		
		
//		// Files
//		String ADMIN_FILE = "text/admin.txt";
//		String LIBRARIAN_FILE = "text/librarian.txt";
//		String GENRE_FILE = "text/genre.txt";
//		String BOOK_FILE = "text/book.txt";
//		String BOOK_COPY_FILE = "text/bookCopy.txt";
//		String MEMBERSHIP_FILE = "text/membership.txt";
//		String MEMBER_FILE = "text/member.txt";
//		String RENTAL_FILE = "text/rental.txt";
//		String LIBRARY_FILE = "text/library.txt";
//		
//		
//		//Managers
//		AdminManager adMan = AdminManager.getInstance();
//		LibrarianManager liMan = LibrarianManager.getInstance();
//		GenreManager genMan = GenreManager.getInstance();
//		BookManager booMan = BookManager.getInstance();
//		BookCopyManager booCoMan = BookCopyManager.getInstance();
//		MembershipManager memShiMan = MembershipManager.getInstance();
//		MemberManager memMan = MemberManager.getInstance();
//		RentalManager renMan = RentalManager.getInstance();
//		LibraryManager libMan = LibraryManager.getInstance();
//		
//		
//		// Temporary HashMaps
//		HashMap<String, Admin> admins = new HashMap<String, Admin>();
//		HashMap<String, Librarian> librarians = new HashMap<String, Librarian>();
//		HashMap<String, Genre> genres = new HashMap<String, Genre>();
//		HashMap<String, Book> books = new HashMap<String, Book>();
//		HashMap<String, BookCopy> bookCopies = new HashMap<String, BookCopy>();
//		HashMap<String, Membership> memberships = new HashMap<String, Membership>();
//		HashMap<String, Member> members = new HashMap<String, Member>();
//		HashMap<String, Rental> rentals = new HashMap<String, Rental>();
//		HashMap<String, Library> libraries = new HashMap<String, Library>();
//		
//		String id = UUID.randomUUID().toString();
//		
//		// Objects
//		Library library = new Library(id, "libraryName", "libraryAdress", "libraryPhone", LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0),false);
//		Admin admin = new Admin("adminId", "adminName", "adminLasstName", "adminJmbg", "adminAdress", Gender.OTHER, 200, "adu", "adp", false);
//		Admin admin2 = new Admin("adminId", "adminName", "adminLasstName", "adminJmbg", "adminAdress", Gender.FEMALE, 200, "adminUsername", "adminPassword", false);
//
//		Librarian librarian = new Librarian("librarianId", "librarianName", "librarianLastName", "librarianJmbg", "librarianAdress", Gender.OTHER, 100, "libu", "libp", false);
//		Genre genre = new Genre("genreId", "genreTag", "genreDescription", false);
//		Book book = new Book("bookId", "bookOgTitle", "bookAuthor", "bookDescription", genre, Language.ENGLISH, 1992, false);
//		BookCopy bookCopy = new BookCopy("copyId","copyTitle", book,150,1999,Binding.HARDCOVER,Language.FRENCH, true, false);
//		BookCopy bookCopy1 = new BookCopy("copyId2","copyTitle", book,150,1999,Binding.HARDCOVER,Language.FRENCH, true, false);
//		Membership membership = new Membership("MembershipType", 200, "MembershipId",false);
//		Member member = new Member("memberId","memberName","memberLastName", "memberJmbg", "memberAdress", Gender.FEMALE, "memberMembershipNum", LocalDate.parse("2021-05-03"), 3, membership, false, true);
//		Rental rental = new Rental(LocalDate.now(), LocalDate.now().plusDays(14), librarian, member, bookCopies,"rentalId", false);
//		
//		
//		//Linking Temporary to Managers
//		libraries.put(library.getIdentification(), library);
//		libMan.setAllLibraries(libraries);
//		libMan.saveLibraries();
//		libMan.loadLibraries();
//		System.out.println(libMan.getAllLibraries());
//		
//		admins.put(admin.getIdentification(), admin);
//		adMan.setAllAdmins(admins);		
//		adMan.saveAdmins();
//		adMan.loadAdmins();
//		System.out.println(adMan.getAllAdmins());
//		adMan.createAdmin("newAdress|newLastName|newName|MALE|newID|false|newJMBG|newPassword|newUsername|150".split("\\|"));
//		adMan.updateAdmin("newAdress|newLastName|newName|MALE|adminId|true|newJMBG|newPassword|newUsername|150".split("\\|"),"adminId");
//		System.out.println(adMan.getActiveAdmins());
//		System.out.println(adMan.getInactiveAdmins());
//		
//		librarians.put(librarian.getIdentification(), librarian);
//		liMan.setAllLibrarians(librarians);
//		liMan.saveLibrarians();
//		liMan.loadLibrarians();
//		System.out.println(liMan.getAllLibrarians());
//		
//		genres.put(genre.getIdentification(), genre);
//		genMan.setAllGenres(genres);
//		genMan.saveGenres();
//		genMan.loadGenres();
//		System.out.println(genMan.getAllGenres());
//		
//		books.put(book.getIdentification(), book);
//		booMan.setAllBooks(books);
//		booMan.saveBooks();
//		booMan.loadBooks();
//		System.out.println(booMan.getAllBooks());
//		
//		bookCopies.put(bookCopy.getIdentification(), bookCopy);
//		bookCopies.put(bookCopy1.getIdentification(), bookCopy1);
//		booCoMan.setAllBookCopies(bookCopies);
//		booCoMan.saveBookCopies();
//		booCoMan.loadBookCopies();
//		System.out.println(booCoMan.getAllBookCopies());
//		
//		memberships.put(membership.getIdentification(), membership);
//		memShiMan.setAllMemberships(memberships);
//		memShiMan.saveMemberships();
//		memShiMan.loadMemberships();
//		System.out.println(memShiMan.getAllMemberships());
//		
//		members.put(member.getIdentification(), member);
//		memMan.setAllMembers(members);
//		memMan.saveMembers();
//		memMan.loadMembers();
//		System.out.println(memMan.getAllMembers());
//		
//		rentals.put(rental.getIdentification(), rental);
//		renMan.setAllRentals(rentals);
//		renMan.saveRentals();
//		renMan.loadRentals();
//		System.out.println(renMan.getAllRentals());
//
//		
//		ArrayList<Object> allObjects = new ArrayList<Object>();
//		allObjects.add(rental);
//		allObjects.add(member);
//		allObjects.add(admin);
//		allObjects.add(librarian);
//		allObjects.add(book);
//		allObjects.add(bookCopy);
//		allObjects.add(genre);
//		allObjects.add(membership);
//		allObjects.add(library);
//
//		System.out.println(ToolKit.evaluateTime(LocalDate.of(2022, 1, 15), 6));
//		
//		// Object Testing
//		Object test = rental;
//		
//		System.out.println(ToolKit.getAllFields(test.getClass()).size());
//		HashMap<Field, Method> hashSet = ToolKit.getSetterHash(test.getClass(),ToolKit.getAllFields(test.getClass()));
//		HashMap<Field, Method> hashGet = ToolKit.getGetterHash(test.getClass(),ToolKit.getAllFields(test.getClass()));
//		
//		for (Field f: hashSet.keySet()) {
//			System.out.println(f.getGenericType().getTypeName() + "----"+ hashSet.get(f).getName());
//		}
//		System.out.println("------------");
//		for (Field f: hashGet.keySet()) {
//			System.out.println(f.getName() + "----"+ hashGet.get(f).getName());
//		}		
//		
//		// IllegalAccessException Generator
//		String s = ToolKit.generateFileLine(mem);
//		System.out.println(s);
//		System.out.println("-------------------------------");
//		ToolKit.generateFileLine(gen);
//		System.out.println("-------------------------------");
//		ToolKit.generateFileLine(boo);
	}

}


