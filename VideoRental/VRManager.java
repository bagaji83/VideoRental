import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class VRManager {

    private static Scanner scanner = new Scanner(System.in) ;

    private List<Customer> customers = new ArrayList<Customer>() ;

    private List<Video> videos = new ArrayList<Video>() ;

    public VRManager() {
    }

    public void clearRentals() {
        System.out.println("Enter customer name: ");
        Customer foundCustomer = foundCustomer(scanner.next());
        if (foundCustomer == null) {
            System.out.println("No customer found");
            return;
        }

        System.out.println("Name: " + foundCustomer.getName() +
                "\tRentals: " + foundCustomer.getRentals().size());
        for (Rental rental : foundCustomer.getRentals()) {
            System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ");
            System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode());
        }

        List<Rental> rentals = new ArrayList<Rental>();
        foundCustomer.setRentals(rentals);
    }

    Customer foundCustomer(String customerName) {
        for ( Customer customer: customers ) {
            if ( customer.getName().equals(customerName)) {
                return customer;
            }
        }
        return null;
    }

    Video foundVideo(String videoTitle) {
        for ( Video video: videos ) {
            if ( video.getTitle().equals(videoTitle) && !video.isRented()) {
                return  video;
            }
        }
        return null;
    }

    public void returnVideo() {
        System.out.println("Enter customer name: ") ;
        Customer foundCustomer = foundCustomer(scanner.next(), vrui) ;
        if ( foundCustomer == null ) return ;

        System.out.println("Enter video title to return: ") ;
        foundCustomer.returnVideo(scanner.next());
    }

    public void listVideos() {
        System.out.println("List of videos");

        for ( Video video: videos ) {
            System.out.println("Price code: " + video.getPriceCode() +"\tTitle: " + video.getTitle()) ;
        }
        System.out.println("End of list");
    }

    public void listCustomers() {
        System.out.println("List of customers");
        for ( Customer customer: customers ) {
            System.out.println("Name: " + customer.getName() +
                    "\tRentals: " + customer.getRentals().size()) ;
            for ( Rental rental: customer.getRentals() ) {
                System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ") ;
                System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode()) ;
            }
        }
        System.out.println("End of list");
    }

    public void getCustomerReport() {
        System.out.println("Enter customer name: ") ;
        Customer foundCustomer = foundCustomer(scanner.next(), vrui);

        if ( foundCustomer == null ) {
            System.out.println("No customer found") ;
        } else {
            String result = foundCustomer.getReport() ;
            System.out.println(result);
        }
    }

    public void rentVideo() {
        System.out.println("Enter customer name: ") ;
        Customer foundCustomer = foundCustomer(scanner.next(), vrui);
        if ( foundCustomer == null ) return ;

        System.out.println("Enter video title to rent: ") ;
        Video foundVideo = foundVideo(scanner.next(), vrui);
        if ( foundVideo == null ) return ;

        Rental rental = new Rental(foundVideo) ;
        foundVideo.setRented(true);

        List<Rental> customerRentals = foundCustomer.getRentals() ;
        customerRentals.add(rental);
        foundCustomer.setRentals(customerRentals);
    }

    public void registerCustomer() {
            System.out.println("Enter customer name: ");
            String name = scanner.next();
            Customer customer = new Customer(name);
            customers.add(customer);
    }

    public void registerVideo() {
            System.out.println("Enter video title to register: ") ;
            String title = scanner.next() ;

            System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):") ;
            int videoType = scanner.nextInt();

            System.out.println("Enter price code( 1 for Regular, 2 for New Release ):") ;
            int priceCode = scanner.nextInt();

            Date registeredDate = new Date();
            Video video = new Video(title, videoType, priceCode, registeredDate) ;
            vrui.videos.add(video) ;
    }
}