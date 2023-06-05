package co.com.amaris.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;



@Data
public class EmployeesModel {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("employee_name")
    private String employeeName;
    @JsonProperty("employee_salary")
    private Double employeeSalary;
    @JsonProperty("employee_salary_annual")
    private Double employeeSalaryAnnual;
    @JsonProperty("employee_age")
    private Long employeeAge;
    @JsonProperty("profile_image")
    private String profileImage;

}
