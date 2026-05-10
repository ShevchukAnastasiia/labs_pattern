package org.example;

import javax.inject.Inject;

public class AssemblyLine {
    @Inject
    public AssemblyLine() {}

    public void start() {
        System.out.println("Запуск конвеєра на заводі...");
    }
}