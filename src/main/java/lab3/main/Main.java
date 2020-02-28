package lab3.main;

import lab1.factory.Car;
import lab1.factory.Motorcycle;
import lab1.factory.Vehicles;
import lab1.factory.exceptions.DuplicateModelNameException;
import lab1.factory.interfaces.Vehicle;
import lab3.chainOfResponsibility.ColumnPrinter;
import lab3.chainOfResponsibility.Printer;
import lab3.chainOfResponsibility.RowPrinter;
import lab3.command.ColumnWriter;
import lab3.command.RowWriter;
import lab3.strategy.DomAnalyzer;
import lab3.strategy.SaxAnalyzer;
import lab3.strategy.XmlAnalyzerStrategy;
import lab3.visitor.PrintVisitor;
import lab3.visitor.Visitor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {

    public static void main(String[] args) throws DuplicateModelNameException {

        //todo print to file
        Printer rowPrinter = new RowPrinter(new File("printer_test.txt"));
        rowPrinter.setNext(new ColumnPrinter(new File("printer_test.txt")));

        Vehicle vehicle = Vehicles.createInstance("vaz", 4);
        rowPrinter.print(vehicle);



       /* try (Writer writer = new FileWriter(new File("file.txt"))) {
            Car car = new Car("rrr", 5);

            car.setCommand(new RowWriter());
            car.print(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

       //Car car = new Car("zzz", 5);




        /*
        Car carOrig = new Car("zil", 5);

        Car.Memento memento = carOrig.createMemento();

        carOrig.addModel("zzz", 555);
        Vehicles.printModels(carOrig);
        System.out.println();

        carOrig.readMemento(memento);
        Vehicles.printModels(carOrig);


         */


/*
        Car car = new Car("qwe", 5);
        Motorcycle motorcycle = new Motorcycle("asd", 4);
        Visitor visitor = new PrintVisitor();
        car.accept(visitor);
        System.out.println();
        motorcycle.accept(visitor);
*/


        /*
        XmlAnalyzerStrategy analyzer = new DomAnalyzer();
        analyzer.analyze(new File(args[0]), new File(args[1]));

         */
/*


        XmlAnalyzerStrategy analyzerStrategy = new SaxAnalyzer();
        analyzerStrategy.analyze(new File(args[0]), new File(args[1]));

*/

    }

}
