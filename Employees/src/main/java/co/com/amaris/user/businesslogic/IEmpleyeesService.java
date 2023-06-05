package co.com.amaris.user.businesslogic;

import co.com.amaris.user.model.EmployeesModel;
import co.com.amaris.user.model.EmployeesResponse;
import jdk.jfr.DataAmount;

import java.util.List;


public interface IEmpleyeesService {
  List<EmployeesModel> getAllEmployeesInfo();
 EmployeesModel getByIdEmployeeInfo(Long id);
}
