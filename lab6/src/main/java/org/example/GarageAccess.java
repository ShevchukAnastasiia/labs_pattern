package org.example;

import javax.inject.Inject;

public class GarageAccess {
    @Inject
    public GarageAccess() {}

    public void openGarage() {
        System.out.println("Відкриття локального гаража автосалону...");
    }
}
