import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRUI {
	private final VRManager VRManager = new VRManager();

	public static void main(String[] args) {
		VRUI ui = new VRUI() ;

		boolean quit = false ;
		while ( ! quit ) {
			int command = ui.showCommand() ;
			switch ( command ) {
				case 0: quit = true ; break ;
				case 1: ui.VRManager.listCustomers() ; break ;
				case 2: ui.VRManager.listVideos() ; break ;
				case 3: ui.VRManager.registerCustomer() ; break ;
				case 4: ui.VRManager.registerVideo() ; break ;
				case 5: ui.VRManager.rentVideo() ; break ;
				case 6: ui.VRManager.returnVideo() ; break ;
				case 7: ui.VRManager.getCustomerReport() ; break;
				case 8: ui.VRManager.clearRentals() ; break ;
				case -1: ui.init() ; break ;
				default: break ;
			}
		}
		System.out.println("Bye");
	}

	private void init() {
		Customer james = new Customer("James") ;
		Customer brown = new Customer("Brown") ;
		customers.add(james) ;
		customers.add(brown) ;

		Video v1 = new Video("v1", VideoType.CD, PriceCode.REGULAR, new Date()) ;
		Video v2 = new Video("v2", VideoType.DVD, PriceCode.NEW_RELEASE, new Date()) ;
		videos.add(v1) ;
		videos.add(v2) ;

		Rental r1 = new Rental(v1) ;
		Rental r2 = new Rental(v2) ;

		james.addRental(r1) ;
		james.addRental(r2) ;
	}

	public int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. List videos");
		System.out.println("\t 3. Register customer");
		System.out.println("\t 4. Register video");
		System.out.println("\t 5. Rent video");
		System.out.println("\t 6. Return video");
		System.out.println("\t 7. Show customer report");
		System.out.println("\t 8. Show customer and clear rentals");

		int command = scanner.nextInt() ;

		return command ;

	}
}
