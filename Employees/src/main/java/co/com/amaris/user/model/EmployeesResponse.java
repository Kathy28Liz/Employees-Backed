package co.com.amaris.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EmployeesResponse {

    public String status;

    @JsonProperty("data")
    public List<EmployeesModel> employeesModelList;

    public String message;
}
