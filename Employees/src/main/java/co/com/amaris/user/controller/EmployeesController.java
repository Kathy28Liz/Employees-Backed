package co.com.amaris.user.controller;

import co.com.amaris.user.businesslogic.IEmpleyeesService;
import co.com.amaris.user.model.EmployeesModel;
import co.com.amaris.user.model.EmployeesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("amaris/")
@CrossOrigin("*")
@Validated
public class EmployeesController {

    @Autowired
    private IEmpleyeesService iEmpleyeesService;

     @GetMapping("employeer/{id}")
    public EmployeesModel getByIdEmployees(@PathVariable(name="id") Long id){
         return iEmpleyeesService.getByIdEmployeeInfo(id);
     }

    @GetMapping("employeers")
    public List<EmployeesModel> geAllEmployees( ){
        return iEmpleyeesService.getAllEmployeesInfo();
    }

}
