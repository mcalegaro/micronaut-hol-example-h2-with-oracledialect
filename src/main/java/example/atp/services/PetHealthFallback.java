package example.atp.services;

import io.micronaut.retry.annotation.Fallback;

import javax.inject.Singleton;
import java.util.concurrent.CompletableFuture;

// A fallback is invoked if a failure occurs
// The @Fallback annotation is used to designate the class as a fallback.
@Fallback
@Singleton
public class PetHealthFallback implements PetHealthOperations {
    @Override
    public CompletableFuture<PetHealth> getHealth(String name) {
        return CompletableFuture.completedFuture(PetHealthOperations.PetHealth.UNKNOWN);
    }
}