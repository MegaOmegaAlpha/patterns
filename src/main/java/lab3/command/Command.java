package lab3.command;

import lab1.factory.Car;

import java.io.Writer;

public interface Command {

    void performCommand(Car car, Writer writer);

}
