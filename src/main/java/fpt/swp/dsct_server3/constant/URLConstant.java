package fpt.swp.dsct_server3.constant;

import fpt.swp.dsct_server3.entity.Wage;
import org.springframework.beans.factory.annotation.Value;

public class URLConstant {
    private static final String API_PREFIX = "/api/v1";
    private static final String ID = "/{id}";

    private static final String AUTH = "/auth";
    private static final String LOGIN = "/login";
    public static final String AUTHENTICATE = API_PREFIX + AUTH + LOGIN;

    //    Employee
    private static final String EMPLOYEE = "/employee";
    public static final String EMPLOYEE_FIND_ALL = API_PREFIX + EMPLOYEE;

    //    Working Schedule
    private static final String WORKING_SCHEDULE = "/working-schedule";
    public static final String WORKING_SCHEDULE_OF_EMPLOYEE = API_PREFIX + EMPLOYEE + ID + WORKING_SCHEDULE;

//    Wage
    private static final String WAGE = "/wage";
    public static final String WAGE_CALCUlATE = API_PREFIX + WAGE;

}
