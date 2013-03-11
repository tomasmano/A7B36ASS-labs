package view;
import business.IPersonService;
import java.util.List;
import model.IPerson;





public class ReportController {
	
	private IPersonService service = null;
	
	public IPersonService getService() {
		return service;
	}

	public void setService(IPersonService service) {
		this.service = service;
	}

	public List<IPerson> getPersonList() {
		return service.getPersonList();
	}

	public Long getReportPersonSalaryTotal() {
		Long total = 0l;
		for (IPerson person : getPersonList()) {
			total += person.getSalary();
		}
		return total;
	}

	public String getReportPersonMarriedStat() {
		Long total = (long) getPersonList().size();
		Long married = 0l;
		for (IPerson person : getPersonList()) {
			if (person.getMarried()) {
				married += 1;
			}
		}
		return married + "/" + total;

	}
	
}
