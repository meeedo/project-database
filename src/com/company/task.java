package com.company;

public class task {
    private String task_name = "";
    private double task_duration = 0.0;
    private double task_actual_time = 0.0;


    public void setname(String name)
    {
        task_name=name;
    }
    public void setduration(double duration)
    {
        task_duration=duration;
    }
    public void setactual(double actual)
    {
        task_actual_time=actual;
    }

    public String getname()
    {
        return task_name;
    }
    public double getduration()

    {
        return task_duration;
    }
    public double getactual()

    {
        return task_actual_time;
    }
}
