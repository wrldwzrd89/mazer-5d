package com.puttysoftware.mazer5d.errorlogger;

public final class ErrorLogger {
    // Fields
    private final String name;

    // Constructor
    public ErrorLogger(final String programName) {
        this.name = programName;
    }

    // Methods
    public void logError(final Throwable t) {
        final LogWriter lw = new LogWriter(t, this.name);
        lw.writeErrorInfo();
        System.exit(1);
    }
}
