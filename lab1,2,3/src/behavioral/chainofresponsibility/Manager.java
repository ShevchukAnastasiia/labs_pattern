package behavioral.chainofresponsibility;

public class Manager implements SupportHandler {
    @Override
    public boolean canHandleRequest(ServiceRequest req) {
        return req.getServiceType() == ServiceType.FINANCIAL_CLAIM;
    }

    @Override
    public int getPriority() { return 3; }

    @Override
    public void handle(ServiceRequest req) {
        req.markHandled();
        System.out.println(name() + " розглядає фінансову претензію: " + req);
    }

    @Override
    public String name() { return "Фінансовий менеджер"; }
}