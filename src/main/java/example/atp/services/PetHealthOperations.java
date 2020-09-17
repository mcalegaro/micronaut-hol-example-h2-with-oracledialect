package example.atp.services;

import java.util.concurrent.CompletableFuture;

// An interface that defines the contract for REST client operations
public interface PetHealthOperations {
    CompletableFuture<PetHealth> getHealth(String name);

    enum PetHealth {
        UNKNOWN,
        GOOD,
        REQUIRES_VACCINATION
    }
}