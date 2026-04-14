package behavioral.chainofresponsibility;

import java.util.Objects;

public class ServiceRequest {
    private final ServiceType type;
    private final String description;
    private boolean handled;

    public ServiceRequest(ServiceType type, String description) {
        this.type = Objects.requireNonNull(type);
        this.description = Objects.requireNonNull(description);
    }

    public ServiceType getServiceType() { return type; }
    public void markHandled() { this.handled = true; }
    public boolean isHandled() { return handled; }

    @Override
    public String toString() { return description; }
}