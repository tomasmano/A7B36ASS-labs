package cz.cvut.ass.searchchallenge.search;

import cz.cvut.ass.searchchallenge.model.Car;
import java.util.Arrays;
import java.util.List;

public class CarSearch extends GenericSearch<Car> {

    // Restriction for Search
    private static final String[] RESTRICTIONS = {
        "lower(" + SortCriteria.BRAND.getProp() + ") like concat(lower(#{carSearch.car.brand}),'%')",
        "lower(" + SortCriteria.YEAR.getProp() + ") like concat(lower(#{carSearch.car.year}),'%')",};
    // instance of a person for search criteria data
    private Car car = new Car();


    public CarSearch() {
        super(Car.class);
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
    
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    private enum SortCriteria implements Criteria{

        BRAND("car.brand"),
        YEAR("car.year");
        private final String prop;

        SortCriteria(String prop) {
            this.prop = prop;
        }

        public String getProp() {
            return prop;
        }
    }
}
