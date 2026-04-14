package behavioral.chainofresponsibility;

import java.util.Comparator;
import java.util.List;

public class SupportService {
    private final List<SupportHandler> handlers;

    public SupportService(List<SupportHandler> handlers) {
        this.handlers = handlers;
    }

    public void processRequest(ServiceRequest req) {
        handlers.stream()
                .sorted(Comparator.comparing(SupportHandler::getPriority))
                .filter(handler -> handler.canHandleRequest(req))
                .findFirst()
                .ifPresentOrElse(
                        handler -> handler.handle(req),
                        () -> System.out.println("На жаль, немає вільного спеціаліста для запиту: " + req)
                );
    }
}