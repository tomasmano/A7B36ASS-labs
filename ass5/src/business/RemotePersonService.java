package business;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import model.IPerson;
import model.remote.PersonDS1ClassAdapter;
import model.remote.PersonDS2ClassAdapter;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

public class RemotePersonService implements IPersonService {

	private static final String PERSON_XML_DS1 = "person-ds1.xml";
	private static final String PERSON_XML_DS2 = "person-ds2.xml";
        

	@SuppressWarnings("unchecked")
        @Override
	public List<IPerson> getPersonList() {
                List<IPerson> persons = new ArrayList<>();
                
                for (PersonDS1ClassAdapter p : getPersonListDS1()) {
                    persons.add(p);
                }
                
                for (PersonDS2ClassAdapter p : getPersonListDS2()) {
                    persons.add(p);
                }
                return persons;
	}
        
	@SuppressWarnings("unchecked")
	public List<PersonDS1ClassAdapter> getPersonListDS1() {
		try {
			FileReader reader = new FileReader(PERSON_XML_DS1);
			return (List<PersonDS1ClassAdapter>) Unmarshaller.unmarshal(ArrayList.class,
					reader);
			
		} catch (FileNotFoundException | MarshalException | ValidationException e) {
			System.err.println(e.getMessage());
			e.printStackTrace(System.err);
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<PersonDS2ClassAdapter> getPersonListDS2() {
		try {
			FileReader reader = new FileReader(PERSON_XML_DS2);
			return (List<PersonDS2ClassAdapter>) Unmarshaller.unmarshal(ArrayList.class,
					reader);
			
		} catch (FileNotFoundException | MarshalException | ValidationException e) {
			System.err.println(e.getMessage());
			e.printStackTrace(System.err);
		}
		return null;
	}
	
	public static void main(String[] args) {

	}

}
