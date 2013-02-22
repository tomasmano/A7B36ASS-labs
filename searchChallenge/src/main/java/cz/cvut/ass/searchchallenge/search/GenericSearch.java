package cz.cvut.ass.searchchallenge.search;

import cz.cvut.ass.searchchallenge.helper.BiMap;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericSearch<T> implements ISearch {

    private String orderBy = null;
    protected Class<T> clazz = null;

    public GenericSearch(Class<T> clazz) {
        this.clazz = clazz;
    }

    // naive search
    public List<T> search() {
        List<String> criteriaArray = getCriteria();
        if (criteriaArray != null) {
            System.out.println("---Translated to---");
            System.out.println(" select * from "
                    + clazz.getSimpleName() + " where ");


            for (String criteria : criteriaArray) {
                if (criteria.equals(criteriaArray.get(criteriaArray.size() - 1))) {
                    System.out.println(criteria + " ");
                } else {
                    System.out.println(criteria + ", ");
                }
            }
            System.out.println(" order by " + orderBy);
            System.out.println("---comments---");
            System.out.println("--Our framework would supply the real values for #{params}");

            // here would be database search
            List<T> out = new ArrayList<T>();
            return out;
        } else {
            return null;
        }
    }

    // I need this function for criteria
    protected abstract List<String> getCriteria();

    protected abstract <E extends Enum & Criteria> Class<E> getSortCriteria();

    protected <E extends Enum & Criteria> BiMap<String, String> getAllowedOrder() {
        BiMap<String, String> allowOrder = new BiMap<String, String>();
        try {
            E[] values = (E[]) getSortCriteria().getDeclaredMethod("values").invoke(null);
            for (E e : values) {
                Criteria c = (Criteria) e;
                allowOrder.put(e.name(), c.getProp());
            }
            return allowOrder;
        } catch (Exception ex) {
            //ignore
            System.err.println("Sorry bro somethin' went wrong..");
            System.err.println(ex);
        }
        return null;
    }

    // this data go out of the system so we do translation
    public String getOrderBy() {
        return getAllowedOrder().getKey(orderBy);
    }

    // this data go back to the system so we do translation
    public void setOrderBy(String orderBy) {
        this.orderBy = getAllowedOrder().getValue(orderBy);
    }
}
