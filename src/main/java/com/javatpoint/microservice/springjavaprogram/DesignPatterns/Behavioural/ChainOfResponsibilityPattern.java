package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Behavioural;

/*
   Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility
      -->  Chain of Responsibility
                -> Passes a request along a chain of Handlers,where each handler either process the request or pass it to next Handler.
                -> Think of Customer Support
                      -> Junior Executive tries to Haqndle Request
                      -> if complex, pass it to team Lead
                      -> still UnResolved, move it to Manager.
      --> Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request.
      --> Use Cases
                ->  Logging frameworks (like Log4j)
                ->  Event handling systems (GUI toolkits, servlets)
                ->  Technical support escalation (level 1 → level 2 → manager)
                ->  Authorization filters in web apps

       --> Benefits
                ->  Decouples sender and receiver
                ->  Easy to add/remove new handlers
                ->  Reduces code duplication
*/

public class ChainOfResponsibilityPattern {
    private static Logger getChainOfLoggers() {
        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        Logger fileLogger = new FileLogger(Logger.DEBUG);
        Logger consoleLogger = new ConsoleLogger(Logger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        System.out.println("Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility");
        System.out.println();
        System.out.println("Behavioural Design Pattern Examples -> Chain Of Responsibility");
        Logger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(Logger.INFO, "This is an informational message.");
        loggerChain.logMessage(Logger.DEBUG, "This is a debug message.");
        loggerChain.logMessage(Logger.ERROR, "This is an error message.");
    }
}

abstract class Logger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message);
}

class ConsoleLogger extends Logger {
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Console::Logger: " + message);
    }
}

class FileLogger extends Logger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}

class ErrorLogger extends Logger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error::Logger: " + message);
    }
}




