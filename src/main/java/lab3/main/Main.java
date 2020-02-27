package lab3.main;

import lab1.factory.exceptions.DuplicateModelNameException;
import lab3.strategy.DomAnalyzer;
import lab3.strategy.SaxAnalyzer;
import lab3.strategy.XmlAnalyzerStrategy;

import java.io.File;

public class Main {

    public static void main(String[] args) throws DuplicateModelNameException {
        /*
        Printer rowPrinter = new RowPrinter();
        rowPrinter.setNext(new ColumnPrinter());

        Vehicle vehicle = Vehicles.createInstance("vaz", 4);
        rowPrinter.print(vehicle);

         */
        /*
        try (Writer writer = new FileWriter(new File("file.txt"))) {
            Car car = new Car("rrr", 5);

            car.setCommand(new ColumnWriter());
            car.print(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

         */

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

        XmlAnalyzerStrategy analyzerStrategy = new SaxAnalyzer();
        analyzerStrategy.analyze(new File(args[0]), new File(args[1]));
    }

}
