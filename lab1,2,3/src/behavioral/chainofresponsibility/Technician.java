package behavioral.chainofresponsibility;

public class Technician implements SupportHandler {
    @Override
    public boolean canHandleRequest(ServiceRequest req) {
        return req.getServiceType() == ServiceType.TECHNICAL_REPAIR;
    }

    @Override
    public int getPriority() { return 2; }

    @Override
    public void handle(ServiceRequest req) {
        req.markHandled();
        System.out.println(name() + " проводить діагностику несправності: " + req);
    }

    @Override
    public String name() { return "Старший технік сервісу"; }
}