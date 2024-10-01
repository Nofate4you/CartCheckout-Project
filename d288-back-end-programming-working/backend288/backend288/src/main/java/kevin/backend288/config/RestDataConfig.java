
package kevin.backend288.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import kevin.backend288.entities.Country;
import kevin.backend288.entities.Customer;
import kevin.backend288.entities.Division;
import kevin.backend288.entities.Excursion;
import kevin.backend288.entities.Vacation;

/**
 * <h1>RestDataConfig</h1>
 * Configuration class for exposing REST API endpoints and setting pagination parameters.
 * This class implements the RepositoryRestConfigurer interface to customize the behavior of Spring Data REST repositories.
 * 
 * TODO: Restrict unused REST API endpoints.
 * 
 * @author WGU Course Materials
 * @version 0.1
 * @since 2023-02-27
 */
@Configuration
public class RestDataConfig implements RepositoryRestConfigurer {

    /**
     * Configures the exposed REST API endpoints and pagination settings.
     * This method is called during Spring Data REST configuration.
     * 
     * - Exposes entity IDs for the following classes: Country, Customer, Division, Excursion, Vacation.
     * - Sets the default and maximum page sizes to Integer.MAX_VALUE to disable pagination.
     * 
     * @param config RepositoryRestConfiguration used to configure repository settings.
     * @param cors CorsRegistry used to configure CORS settings (not currently used here).
     */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // Expose IDs for the following entities in the REST API.
        config.exposeIdsFor(Country.class);
        config.exposeIdsFor(Customer.class);
        config.exposeIdsFor(Division.class);
        config.exposeIdsFor(Excursion.class);
        config.exposeIdsFor(Vacation.class);
        
        // Disable pagination by setting the default and maximum page sizes to Integer.MAX_VALUE.
        config.setDefaultPageSize(Integer.MAX_VALUE);
        config.setMaxPageSize(Integer.MAX_VALUE);
    }
}
