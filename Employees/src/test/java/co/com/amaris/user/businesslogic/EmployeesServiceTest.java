package co.com.amaris.user.businesslogic;

import co.com.amaris.user.businesslogic.impl.EmployeesService;
import co.com.amaris.user.model.EmployeeResponse;
import co.com.amaris.user.model.EmployeesModel;
import co.com.amaris.user.model.EmployeesResponse;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

public class EmployeesServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private EmployeesService employeeService;


    EmployeesModel employeesModel;
    List<EmployeesModel> employeesModelList;

    protected String baseUrl= new String();

    HttpHeaders headers;
    HttpEntity<Void> requestEntity;


    EmployeesResponse  employeesResponse;
    EmployeeResponse employeeResponse;

@BeforeEach
void init() {
        baseUrl= "https://dummy.restapiexample./api/v1";
        employeesModel = new EmployeesModel();
        employeesModel.setEmployeeName("Kevin");
        employeesModel.setProfileImage(" ");
        employeesModel.setId(2L);
        employeesModel.setEmployeeAge(20L);
        employeesModel.setEmployeeSalary(23.90);
        employeesModel.setEmployeeSalaryAnnual(286.8);
        employeesModelList = new ArrayList<>();

        employeesModelList.add(employeesModel);

        headers = new HttpHeaders();
        requestEntity = new HttpEntity<>(headers);

        employeesResponse = new EmployeesResponse();
        employeesResponse.setMessage("Successfully! All records has been fetched.");
        employeesResponse.setStatus("Sucess");
        employeesResponse.setEmployeesModelList(employeesModelList);

        employeeResponse = new EmployeeResponse();
        employeeResponse.setMessage("Successfully! All records has been fetched.");
        employeeResponse.setStatus("Sucess");
        employeeResponse.setEmployeesModel(employeesModel);

    }
/*
    @Test
    public void testGetAllEmployeesInfo() {

        String uri = "https://dummy.restapiexample./api/v1/employees";

        ResponseEntity<EmployeesResponse> responseEntity = new ResponseEntity<>(employeesResponse, HttpStatus.OK);
        Mockito.when(restTemplate.exchange(uri, HttpMethod.GET, requestEntity, EmployeesResponse.class))
                .thenReturn(responseEntity);


        List<EmployeesModel> result = employeeService.getAllEmployeesInfo();

        Assert.assertEquals(1, result.size());
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(employeesModel.getId(), result.get(0).getId());
        Assert.assertEquals(employeesModel.getEmployeeName(), result.get(0).getEmployeeName());
        Assert.assertEquals(employeesModel.getEmployeeAge(), result.get(0).getEmployeeAge());
        Assert.assertEquals(employeesModel.getEmployeeSalary(), result.get(0).getEmployeeSalary());
       Assert.assertEquals(employeesModel.getEmployeeSalaryAnnual(), result.get(0).getEmployeeSalaryAnnual(), 0.0);
    }

    @Test
    public void testGetByIdEmployeeInfo() {

        Long id = 1L;
        String uri = "https://dummy.restapiexample./api/v1/employee/"+id;
        ResponseEntity<EmployeeResponse> responseEntity = new ResponseEntity<>(employeeResponse, HttpStatus.OK);
        lenient().when(restTemplate.exchange(uri, HttpMethod.GET, requestEntity, EmployeeResponse.class))
                .thenReturn(responseEntity);

        EmployeesModel result = employeeService.getByIdEmployeeInfo(id);

        Assert.assertEquals(employeesModel.getId(), result.getId());
        Assert.assertEquals(employeesModel.getEmployeeName(), result.getEmployeeName());
        Assert.assertEquals(employeesModel.getEmployeeAge(), result.getEmployeeAge());
        Assert.assertEquals(employeesModel.getEmployeeSalary(), result.getEmployeeSalary());
        Assert.assertEquals(employeesModel.getEmployeeSalaryAnnual(), result.getEmployeeSalaryAnnual(), 0.0);
    }
*/
    @Test
    public void testCalculateAnualSalary() {

        Double salary = 1000.0;
        Double result = employeeService.calculateAnualSalary(salary);

        Assert.assertEquals(12000.0, result, 0.0);
    }

}
