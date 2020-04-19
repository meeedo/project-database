package com.company;
import java.util.ArrayList;
import java.util.Locale;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    //static WaterfallChartDemo w;

    public static void main(final String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskis", "root", "");
        PreparedStatement st;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        Scanner input = new Scanner(System.in);

        String PM, ProjectName, TeamMemberName, WeekStart, pstart, pend, taskName, Taskresponsible, StaskName,
                predecessors, tStart, tEnd, sStart, sEnd;
        int nHoursMemberDay, nHoursMemberTask, ProjectCost, PnumOfHoursDay, TnumOfDaysH, Pduration, Tduartion,
                Staskduartion, TaskActual, teamsize, nHoursTask, tasksN, subN;

        Date PstartDate, PendDate, TstartDate, TendDate, SstartDate, SendDate;







/*



        String Deliverables[] = new String[100];

        System.out.println("Welcome To Project Manager Tool");

        System.out.println("Enter Project Manager name:");
        PM = input.next();

        System.out.println("Enter Project  name:");
        ProjectName = input.next();

        System.out.println("Enter Project  cost:");
        ProjectCost = input.nextInt();

        System.out.println("Enter Project  startDate:");
        pstart = input.next();
        PstartDate = sdf.parse(pstart);
        System.out.println("Enter Project  EndDate:");
        pend = input.next();
        PendDate = sdf.parse(pend);

        Pduration = (int) calcduration(PstartDate, PendDate, TimeUnit.DAYS);

        System.out.println("Enter Project working hours per day :");
        PnumOfHoursDay = input.nextInt();

        System.out.println("Enter the start week either (sunday or monday) :");
        WeekStart = input.next();

        System.out.println("Enter Number of  tasks included in the project : ");
        tasksN = input.nextInt();

        String tasks[] = new String[tasksN];

        int taskestimate1[] = new int[tasksN];

        for (int i = 0; i < tasksN; i++) {
            System.out.println("Enter name of the main task " + (i + 1) + ": ");
            taskName = input.next();
            tasks[i] = taskName;

            System.out.println("Enter Project  startDate:");
            tStart = input.next();
            TstartDate = sdf.parse(tStart);
            System.out.println("Enter Project  EndDate:");
            tEnd = input.next();
            TendDate = sdf.parse(tEnd);
            Tduartion = (int) calcduration(TstartDate, TendDate, TimeUnit.HOURS);
            taskestimate1[i] = (int) Tduartion;

            System.out.println("Enter predecessors of this task: ");
            predecessors = input.next();

            st = conn.prepareStatement(
                    "Insert INTO task (taskName,startDate,endDate,Duration,predecessors)VALUES(?,?,?,?,?)");
            st.setString(1, taskName);
            st.setString(2, tStart);
            st.setString(3, tEnd);
            st.setInt(4, Tduartion);
            st.setString(5, predecessors);
            st.executeUpdate();

            System.out.println("Add subtasks?1->>Yes");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.println("subtasks number:");
                subN = input.nextInt();
                for (int k = 0; k < subN; k++) {
                    System.out.println("Enter name of the subtask " + (i + 1) + ": ");
                    StaskName = input.next();
                    System.out.println("Enter subtask  startDate:");
                    sStart = input.next();
                    // comparedate(sStart,tStart);
                    SstartDate = sdf.parse(sStart);

                    if (SstartDate.compareTo(TstartDate) < 0) {
                        System.out.println("subtask must start within tha main task!!");
                        break;
                    }

                    System.out.println("Enter subtask  EndDate:");
                    sEnd = input.next();
                    SendDate = sdf.parse(sEnd);
                    Staskduartion = (int) calcduration(TstartDate, TendDate, TimeUnit.HOURS);

                    st = conn.prepareStatement(
                            "Insert INTO subtask (taskName,subName,startDate,endDate,Duration)VALUES(?,?,?,?,?)");
                    st.setString(1, taskName);
                    st.setString(2, StaskName);
                    st.setString(3, sStart);
                    st.setString(4, sEnd);
                    st.setInt(5, Staskduartion);

                    st.executeUpdate();
                }
            }

        }

        System.out.println("Enter Number of team members");
        teamsize = input.nextInt();
        for (int i = 0; i < teamsize; i++) {
            System.out.println("Enter name of member " + (i + 1) + " :");
            TeamMemberName = input.next();
            System.out.println("Enter number of working Hours of Member " + (i + 1) + " per Day: ");
            nHoursMemberDay = input.nextInt();

            System.out.println("tasks Available: ");
            st = conn.prepareStatement("SELECT taskName FROM task;");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("taskName"));
            }

            System.out.println("Responsible for which task: ");
            Taskresponsible = input.next();
            System.out.println("Enter number of working Hours of per task: ");
            nHoursMemberTask = input.nextInt();
            st = conn.prepareStatement("Insert INTO team (mName,nHoursDay,taskName,workingTime)VALUES(?,?,?,?)");
            st.setString(1, TeamMemberName);
            st.setInt(2, nHoursMemberDay);
            st.setString(3, Taskresponsible);
            st.setInt(4, nHoursMemberTask);
            st.executeUpdate();

        }
*/
        // our SQL SELECT query.
        // if you only need a few columns, specify them by name instead of using "*"
        String query = "SELECT taskName,Duration FROM task";

        // create the java statement
        Statement str = conn.createStatement();
        // execute the query, and get a java resultset
        ResultSet rss = str.executeQuery(query);

        // iterate through the java resultset
        int count = 0 ;
        ArrayList<task> tasks = new ArrayList<task>();
        task tmp;
        while (rss.next())
        {
            tmp = new task();
            tmp.setname(rss.getString("taskName"));
            tmp.setduration(rss.getDouble("Duration"));

            tasks.add(tmp);
            // print the results
            System.out.format(" %s, %s\n", tmp.getname(), tmp.getduration() );


        }
        str.close();


        // create the java mysql update preparedstatement
        String query2 = "update task set predecessors = ? where Duration = 43824";
        PreparedStatement preparedStmt = conn.prepareStatement(query2);
        preparedStmt.setString(1,"hrr");

        // execute the java preparedstatement
        preparedStmt.executeUpdate();

        conn.close();
    }



/*
        double ac = 0.0;
        Scanner t = new Scanner(System.in);
        for (int i = 0 ; i<tasks.size() ; i++)
        {

            System.out.println("enter the actual time for " +tasks.get(i).getname() );


            tasks.get(i).setactual(t.nextDouble());
        }

        for (int i = 0 ; i<tasks.size() ; i++)
        {

            System.out.println(tasks.get(i).getname() + "----->" + tasks.get(i).getduration() + "---->>" + tasks.get(i).getactual());
            compare(tasks.get(i).getduration() , tasks.get(i).getactual(),tasks.get(i).getname());
            //BarChartSample tt = new BarChartSample(tasks);
        }






    }
 */

    public static void compare (double duration,double actual,String name)
    {
        boolean test;
        if (duration <= actual)
        {
            test= true;
            System.out.println(name+ "  end in time ");
        }
        else
            {
            test = false;
                System.out.println(name+"  not finish in time ");
            }
       // return test;
    }

    public static long calcduration(Date firstDate, Date secondDate, TimeUnit timeunit) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());

        return timeunit.convert(diffInMillies, TimeUnit.MILLISECONDS);

    }

    public static void comparedate(String date1, String date2) throws ParseException {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdformat.parse(date1);
        Date d2 = sdformat.parse(date2);
        System.out.println("The date 1 is: " + sdformat.format(d1));
        System.out.println("The date 2 is: " + sdformat.format(d2));
        if (d1.compareTo(d2) > 0) {
            System.out.println("Date 1 occurs after Date 2");
        } else if (d1.compareTo(d2) < 0) {
            System.out.println("Date 1 occurs before Date 2");
        } else if (d1.compareTo(d2) == 0) {
            System.out.println("Both dates are equal");
        }
    }
}

