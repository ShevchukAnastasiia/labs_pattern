package behavioral.chainofresponsibility;

public interface SupportHandler {
    boolean canHandleRequest(ServiceRequest req);
    int getPriority();
    void handle(ServiceRequest req);
    String name();
}