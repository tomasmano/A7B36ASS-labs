package business;

import java.util.List;
import model.IPerson;


public class PersonService implements IPersonService {

	private static final String PERSON_XML = "person.xml";

	@SuppressWarnings("unchecked")
        @Override
	public List<IPerson> getPersonList() {
//		try {
//			FileReader reader = new FileReader(PERSON_XML);
//			return (List<IPerson>) Unmarshaller.unmarshal(ArrayList.class,
//					reader);
//
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//			e.printStackTrace(System.err);
//		}
		return null;
	}

}
