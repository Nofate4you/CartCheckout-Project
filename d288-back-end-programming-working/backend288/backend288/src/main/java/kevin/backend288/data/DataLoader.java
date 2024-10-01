package kevin.backend288.data;

import kevin.backend288.dao.CustomerRepository;
import kevin.backend288.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final CustomerRepository customerRepository;

    public DataLoader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) {
        if (customerRepository.count() == 1) {
            Customer customer1 = new Customer("George", "Washington", "3200 Mount Vernon", "(703)799-8600", "22131");
            // No division is being set here
            customerRepository.save(customer1);

            Customer customer2 = new Customer("Abraham", "Lincoln", "413 S 8th Street", "(232)588-8844", "73233");
            customerRepository.save(customer2);

            Customer customer3 = new Customer("Franklin", "Roosevelt", "3333 Moon Lane", "(333)222-1212", "32323");
            customerRepository.save(customer3);

            Customer customer4 = new Customer("Theodore", "Roosevelt", "3333 Moon Lane", "(333)222-1212", "32323");
            customerRepository.save(customer4);

            Customer customer5 = new Customer("John", "Kennedy", "4444 Young Lane", "(4343)222-5555", "55555");
            customerRepository.save(customer5);

            System.out.println("5 Sample Customers added.");
        } else {
            System.out.println("Customers already exist in the database.");
        }
    }
}
