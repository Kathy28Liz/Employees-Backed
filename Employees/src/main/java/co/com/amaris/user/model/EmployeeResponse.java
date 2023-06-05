package co.com.amaris.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class EmployeeResponse {

    public String status;

    @JsonProperty("data")
    public EmployeesModel employeesModel;

    public String message;
}
