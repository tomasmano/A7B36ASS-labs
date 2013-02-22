package cz.cvut.ass.searchchallenge.search;

import cz.cvut.ass.searchchallenge.model.Person;
import java.util.Arrays;
import java.util.List;

public class PersonSearch extends GenericSearch<Person> {

    // Restriction for Search
    private static final String[] RESTRICTIONS = {
        "lower(" + SortCriteria.FIRSTNAME.getProp() + ") like concat(lower(#{personSearch.person.firstName}),'%')",
        "lower(" + SortCriteria.LASTNAME.getProp() + ") like concat(lower(#{personSearch.person.lastName}),'%')",
        "lower(" + SortCriteria.AGE.getProp() + ") like concat(lower(#{personSearch.person.age}),'%')",};
    // instance of a person for search criteria data
    private Person person = new Person();

    public PersonSearch() {
        super(Person.class);
    }

    @Override
    // Restriction for Search
    protected List<String> getCriteria() {
        return Arrays.asList(RESTRICTIONS);
    }

    @Override
    protected Class<SortCriteria> getSortCriteria() {
        return SortCriteria.class;
    }

    //////////  Getters / Setters  //////////
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    private enum SortCriteria implements Criteria {

        FIRSTNAME("person.firstName"),
        LASTNAME("person.lastName"),
        AGE("person.age");
        private final String prop;

        SortCriteria(String prop) {
            this.prop = prop;
        }

        public String getProp() {
            return prop;
        }
    }
}
