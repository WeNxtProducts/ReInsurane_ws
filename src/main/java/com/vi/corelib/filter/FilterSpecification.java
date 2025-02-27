package com.vi.corelib.filter;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class FilterSpecification<T> implements Specification<T> {
  private FilterCriteria criteria;

  public FilterSpecification(FilterCriteria filterCriteria) {
    this.criteria = filterCriteria;
  }

  public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
    return Filter.getFilter(root, query, builder, criteria);
  }
}
