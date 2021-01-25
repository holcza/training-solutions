package timesheet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Company {

    private List<Project> projects = new ArrayList<>();

    private List<Employee> employees = new ArrayList<>();

    private List<TimeSheetItem> timeSheetItems = new ArrayList<>();

    public Company(InputStream employeesFile, InputStream projectsFile) {
        employeeInput(employeesFile);

        projectInput(projectsFile);
    }

    private void projectInput(InputStream projectsFile) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(projectsFile))) {
            String s = "";
            while ((s = br.readLine()) != null) {

                projects.add(new Project(s));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read projects file", ioe);
        }
    }

    private void employeeInput(InputStream employeesFile) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(employeesFile))) {
            String s = "";
            while ((s = br.readLine()) != null) {

                String[] names = s.split(" ");
                employees.add(new Employee(names[0], names[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read employees file", ioe);
        }
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        timeSheetItems.add(new TimeSheetItem(employee, project, beginDate, endDate));
    }

    public List<ReportLine> calculateProjectByNameYearMonth(String employeeName, int year, int month) {
        nameCheck(employeeName);

        List<ReportLine> reportLines = new ArrayList<>();

        for (TimeSheetItem t : timeSheetItems) {
            if (t.getEmployee().getName().equals(employeeName) && t.getBeginDate().getYear() == year && t.getBeginDate().getMonthValue() == month) {
                addReportLine(reportLines, t);
            }
        }


        return reportLines;
    }

    private void addReportLine(List<ReportLine> reportLines, TimeSheetItem t) {
        long time = t.hoursBetweenDates();
        for (ReportLine r : reportLines) {
            if (r.getProject().getName().equals(t.getProject().getName())) {
                r.addTime(time);
                time = 0;
            }
        }
        reportLines.add(new ReportLine(t.getProject(), time));
    }

    private void nameCheck(String employeeName) {
        boolean nameCheck = false;
        for (Employee e : employees) {
            if (e.getName().equals(employeeName)) {
                nameCheck = true;
            }
        }

        if (!nameCheck) {
            throw new IllegalArgumentException("Wrong name");
        }
    }

    public void printToFile(String employeeName, int year, int month, Path file) {

        List<ReportLine> reportLines = calculateProjectByNameYearMonth(employeeName, year, month);
        long sum = getSumOfTime(reportLines);

        try (BufferedWriter bw = Files.newBufferedWriter(file)) {
            write(employeeName, year, month, reportLines, sum, bw);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    private void write(String employeeName, int year, int month, List<ReportLine> reportLines, long sum, BufferedWriter bw) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        LocalDate date = LocalDate.of(year, month, 1);
        bw.write(employeeName + "\t" + formatter.format(date) + "\t" + sum + "\n");
        for (ReportLine r : reportLines) {
            if (!r.toString().equals("")) {
                bw.write(r + "\n");
            }
        }
    }

    private long getSumOfTime(List<ReportLine> reportLines) {
        long sum = 0;
        for (ReportLine r : reportLines) {
            sum = sum + r.getTime();
        }
        return sum;
    }
}
