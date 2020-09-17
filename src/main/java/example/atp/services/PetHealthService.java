package example.atp.services;

import java.util.concurrent.CompletableFuture;
import javax.inject.Singleton;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Recoverable;

// The @Recoverable annotation is used to indicate
// that this service can recover from failure and provides
// the interface that contains the methods that should trigger fallbacks
@Singleton
@Recoverable(api = PetHealthOperations.class)
public class PetHealthService implements PetHealthOperations {
    private final PetHealthClient petHealthClient;

    PetHealthService(PetHealthClient petHealthClient) {
        this.petHealthClient = petHealthClient;
    }

    // The getHealth method uses the client to invoke the Helidon endpoint
    // and return the result without performing any blocking I/O
    @Override
    public CompletableFuture<PetHealth> getHealth(String name) {
        return petHealthClient.isVaccinated(name).thenApply(isVaccinated ->
                isVaccinated ? PetHealth.GOOD : PetHealth.REQUIRES_VACCINATION
        );
    }

    // A declarative HTTP client that will be implemented for you automatically
    // at compilation time. The value of the @Client annotation indicates the
    // target service ID.
    @Client(value = "pet-health", path ="/vaccinated")
    public interface PetHealthClient {
        @Get("/{name}")
        CompletableFuture<Boolean> isVaccinated(String name);
    }
}