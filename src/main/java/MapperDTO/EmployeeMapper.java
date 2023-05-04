package MapperDTO;

import com.example.EmployeePortal.EmployeesModel.EmployeeDTO;
import com.example.EmployeePortal.EmployeesModel.EmployeeModel;

public interface EmployeeMapper {
	  EmployeeModel toEntity(EmployeeDTO dto);
}
