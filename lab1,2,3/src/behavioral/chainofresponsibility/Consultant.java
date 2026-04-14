package behavioral.chainofresponsibility;

public class Consultant implements SupportHandler {
    @Override
    public boolean canHandleRequest(ServiceRequest req) {
        return req.getServiceType() == ServiceType.SALES_CONSULTATION;
    }

    @Override
    public int getPriority() { return 1; }

    @Override
    public void handle(ServiceRequest req) {
        req.markHandled();
        System.out.println(name() + " проводить консультацію щодо авто: " + req);
    }

    @Override
    public String name() { return "Консультант відділу продажів"; }
}