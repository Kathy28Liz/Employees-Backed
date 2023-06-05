package co.com.amaris.user.businesslogic.impl;

import co.com.amaris.user.businesslogic.IEmpleyeesService;
import co.com.amaris.user.model.EmployeeResponse;
import co.com.amaris.user.model.EmployeesModel;
import co.com.amaris.user.model.EmployeesResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class EmployeesService  implements IEmpleyeesService {

    private final HttpHeaders headers = new HttpHeaders();
    private HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

    @Value("${employeers.base.url}")
    protected String baseUrl;

    protected RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<EmployeesModel> getAllEmployeesInfo(){

         String uri = baseUrl +"/employees";
         ResponseEntity<EmployeesResponse>response =  restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity, EmployeesResponse.class);

        if(response.getStatusCode().is2xxSuccessful()){
            log.info( response.getBody().message, response.getBody().getStatus());
           var modelList=response.getBody().employeesModelList;
             for(EmployeesModel employee: modelList){
                 if(employee.getEmployeeSalary()!=null) {
                     employee.setEmployeeSalaryAnnual(calculateAnualSalary(employee.getEmployeeSalary()));
                 }
              }

        return response.getBody().employeesModelList;
        }

        log.info( response.getBody().message, response.getBody().getStatus());
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "newTaskStatusName INVALID_VALUE");
    }
    @Override
    public EmployeesModel getByIdEmployeeInfo(Long id){

        String uri=baseUrl+"/employee/"+id;
        ResponseEntity<EmployeeResponse>response=restTemplate.exchange(
                uri,HttpMethod.GET,requestEntity, EmployeeResponse.class);

        if(response.getStatusCode().is2xxSuccessful()){
            log.info(response.getBody().message,response.getBody().getStatus());
           var employee= response.getBody().employeesModel;

           if(employee.getEmployeeSalary()!=null) {
               employee.setEmployeeSalaryAnnual(calculateAnualSalary(employee.getEmployeeSalary()));
           }
           return response.getBody().getEmployeesModel();
        }
        log.info(response.getBody().message,response.getBody().getStatus());
        throw new RuntimeException("Error");
    }

     public double calculateAnualSalary(Double salary){
        return salary *12;
     }
}
