package PWS;
import org.apache.commons.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVFormat;


public class ObsExporter {

    public void createCSVFile() throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\"));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "Name", "Designation", "Company"));
        ) {
            csvPrinter.printRecord("1", "Sundar Pichai ♥", "CEO", "Google");
            csvPrinter.printRecord("2", "Satya Nadella", "CEO", "Microsoft");
            csvPrinter.printRecord("3", "Tim cook", "CEO", "Apple");

            csvPrinter.printRecord(Arrays.asList("4", "Mark Zuckerberg", "CEO", "Facebook"));

            csvPrinter.flush();
        }
    }
}
