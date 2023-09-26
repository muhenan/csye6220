package part5;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import org.apache.poi.*;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

@WebServlet(name = "Part5Servlet", value = "/store.xls")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"admin"}))
public class Part5Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<HTML>");
        out.println("<head><title> Part 5 </title></head>");
        out.println("<body>");
        out.println("<h1> Part 5 </h1>");
        out.println("<p> " + "Now, let see the excel file" + " <p>");


        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            URL url = this.getClass().getResource("/file");

            File file = new File(url.getPath() + "store.xls");
            Workbook workbook = new HSSFWorkbook(new FileInputStream(file));

            int numberOfSheets = workbook.getNumberOfSheets();

            out.println("<p> " + "There are " + numberOfSheets + " sheet(s)" + " <p>");

            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                out.println("<p> " + "This is the sheet " + sheet.getSheetName() + " <p>");

                out.println("<table border='1'>");
                for (Row row : sheet) {
                    out.println("<tr>");
                    for (Cell cell : row) {
                        CellType cellType = cell.getCellType();
                        out.println("<td>");
                        switch (cellType) {
                            case STRING:
                                out.println(cell.getStringCellValue());
                                break;
                            case NUMERIC:
                                out.println(cell.getNumericCellValue());
                                break;
                            case BOOLEAN:
                                out.println(cell.getBooleanCellValue());
                                break;
                            case BLANK:
                                out.println("");
                                break;
                            case _NONE:
                            case ERROR:
                            default:
                                out.println("Error reading cell value");
                                break;
                        }
                        out.println("</td>");
                    }
                    out.println("</tr>");
                }
                out.println("</table>");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



        out.println("</body>");
        out.println("</HTML>");

    }
}
