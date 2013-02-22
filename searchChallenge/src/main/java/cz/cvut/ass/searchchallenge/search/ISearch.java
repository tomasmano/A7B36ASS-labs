package cz.cvut.ass.searchchallenge.search;

import java.util.List;

public interface ISearch {

	// naive search
	public abstract List<?> search();

	// this data go out of the system so we do translation
	public abstract String getOrderBy();

	// this data go back to the system so we do translation
	public abstract void setOrderBy(String orderBy);

}