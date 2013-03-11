package view.page;

import container.Container;
import model.IPerson;
import view.ReportController;

public class PersonListPage implements Page {
	
	/* (non-Javadoc)
	 * @see view.Page#render()
	 */
	@Override
	public String render() {
		System.out.println("---------Person list-------");
		System.out.println("\nPeople:");
		System.out.println("\t---------------------------------");
		for (IPerson person : ((ReportController) Container.context.get("reportController")).getPersonList()) {
			System.out.println("\t|ID="+person.getId()+"\t|"+person.getfName()+"\t|"+person.getAge()+"\t|"+person.getlName()+"\t|..\t|");
		}
		System.out.println("\t---------------------------------");
		System.out.println("\n---------          --------");
		return null;
	}
}
