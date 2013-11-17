package com.eleven.booklibrary.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eleven.booklibrary.model.vo.Pagination;

public class BorrowExample {
    protected String orderByClause;

    protected boolean distinct;
    
    protected Long offset;
    
    public Long getOffset() {
      return offset;
    }

    public void setOffset(Long offset) {
      this.offset = offset;
    }

    public Long getLength() {
      return length;
    }

    public void setLength(Long length) {
      this.length = length;
    }

    protected Long length;

    protected List<Criteria> oredCriteria;

    public BorrowExample() {
        oredCriteria = new ArrayList<Criteria>();
    }
    
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBookNumberIsNull() {
            addCriterion("book_number is null");
            return (Criteria) this;
        }

        public Criteria andBookNumberIsNotNull() {
            addCriterion("book_number is not null");
            return (Criteria) this;
        }

        public Criteria andBookNumberEqualTo(Long value) {
            addCriterion("book_number =", value, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberNotEqualTo(Long value) {
            addCriterion("book_number <>", value, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberGreaterThan(Long value) {
            addCriterion("book_number >", value, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("book_number >=", value, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberLessThan(Long value) {
            addCriterion("book_number <", value, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberLessThanOrEqualTo(Long value) {
            addCriterion("book_number <=", value, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberIn(List<Long> values) {
            addCriterion("book_number in", values, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberNotIn(List<Long> values) {
            addCriterion("book_number not in", values, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberBetween(Long value1, Long value2) {
            addCriterion("book_number between", value1, value2, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberNotBetween(Long value1, Long value2) {
            addCriterion("book_number not between", value1, value2, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBorrowerNumberIsNull() {
            addCriterion("borrower_number is null");
            return (Criteria) this;
        }

        public Criteria andBorrowerNumberIsNotNull() {
            addCriterion("borrower_number is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowerNumberEqualTo(Long value) {
            addCriterion("borrower_number =", value, "borrowerNumber");
            return (Criteria) this;
        }

        public Criteria andBorrowerNumberNotEqualTo(Long value) {
            addCriterion("borrower_number <>", value, "borrowerNumber");
            return (Criteria) this;
        }

        public Criteria andBorrowerNumberGreaterThan(Long value) {
            addCriterion("borrower_number >", value, "borrowerNumber");
            return (Criteria) this;
        }

        public Criteria andBorrowerNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("borrower_number >=", value, "borrowerNumber");
            return (Criteria) this;
        }

        public Criteria andBorrowerNumberLessThan(Long value) {
            addCriterion("borrower_number <", value, "borrowerNumber");
            return (Criteria) this;
        }

        public Criteria andBorrowerNumberLessThanOrEqualTo(Long value) {
            addCriterion("borrower_number <=", value, "borrowerNumber");
            return (Criteria) this;
        }

        public Criteria andBorrowerNumberIn(List<Long> values) {
            addCriterion("borrower_number in", values, "borrowerNumber");
            return (Criteria) this;
        }

        public Criteria andBorrowerNumberNotIn(List<Long> values) {
            addCriterion("borrower_number not in", values, "borrowerNumber");
            return (Criteria) this;
        }

        public Criteria andBorrowerNumberBetween(Long value1, Long value2) {
            addCriterion("borrower_number between", value1, value2, "borrowerNumber");
            return (Criteria) this;
        }

        public Criteria andBorrowerNumberNotBetween(Long value1, Long value2) {
            addCriterion("borrower_number not between", value1, value2, "borrowerNumber");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameIsNull() {
            addCriterion("borrower_name is null");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameIsNotNull() {
            addCriterion("borrower_name is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameEqualTo(String value) {
            addCriterion("borrower_name =", value, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameNotEqualTo(String value) {
            addCriterion("borrower_name <>", value, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameGreaterThan(String value) {
            addCriterion("borrower_name >", value, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameGreaterThanOrEqualTo(String value) {
            addCriterion("borrower_name >=", value, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameLessThan(String value) {
            addCriterion("borrower_name <", value, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameLessThanOrEqualTo(String value) {
            addCriterion("borrower_name <=", value, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameLike(String value) {
            addCriterion("borrower_name like", value, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameNotLike(String value) {
            addCriterion("borrower_name not like", value, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameIn(List<String> values) {
            addCriterion("borrower_name in", values, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameNotIn(List<String> values) {
            addCriterion("borrower_name not in", values, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameBetween(String value1, String value2) {
            addCriterion("borrower_name between", value1, value2, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameNotBetween(String value1, String value2) {
            addCriterion("borrower_name not between", value1, value2, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andReturnDateIsNull() {
            addCriterion("return_date is null");
            return (Criteria) this;
        }

        public Criteria andReturnDateIsNotNull() {
            addCriterion("return_date is not null");
            return (Criteria) this;
        }

        public Criteria andReturnDateEqualTo(Date value) {
            addCriterion("return_date =", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotEqualTo(Date value) {
            addCriterion("return_date <>", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateGreaterThan(Date value) {
            addCriterion("return_date >", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateGreaterThanOrEqualTo(Date value) {
            addCriterion("return_date >=", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateLessThan(Date value) {
            addCriterion("return_date <", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateLessThanOrEqualTo(Date value) {
            addCriterion("return_date <=", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateIn(List<Date> values) {
            addCriterion("return_date in", values, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotIn(List<Date> values) {
            addCriterion("return_date not in", values, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateBetween(Date value1, Date value2) {
            addCriterion("return_date between", value1, value2, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotBetween(Date value1, Date value2) {
            addCriterion("return_date not between", value1, value2, "returnDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateIsNull() {
            addCriterion("borrowed_date is null");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateIsNotNull() {
            addCriterion("borrowed_date is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateEqualTo(Date value) {
            addCriterion("borrowed_date =", value, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateNotEqualTo(Date value) {
            addCriterion("borrowed_date <>", value, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateGreaterThan(Date value) {
            addCriterion("borrowed_date >", value, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("borrowed_date >=", value, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateLessThan(Date value) {
            addCriterion("borrowed_date <", value, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateLessThanOrEqualTo(Date value) {
            addCriterion("borrowed_date <=", value, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateIn(List<Date> values) {
            addCriterion("borrowed_date in", values, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateNotIn(List<Date> values) {
            addCriterion("borrowed_date not in", values, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateBetween(Date value1, Date value2) {
            addCriterion("borrowed_date between", value1, value2, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateNotBetween(Date value1, Date value2) {
            addCriterion("borrowed_date not between", value1, value2, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andFineIsNull() {
            addCriterion("fine is null");
            return (Criteria) this;
        }

        public Criteria andFineIsNotNull() {
            addCriterion("fine is not null");
            return (Criteria) this;
        }

        public Criteria andFineEqualTo(Long value) {
            addCriterion("fine =", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotEqualTo(Long value) {
            addCriterion("fine <>", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineGreaterThan(Long value) {
            addCriterion("fine >", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineGreaterThanOrEqualTo(Long value) {
            addCriterion("fine >=", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineLessThan(Long value) {
            addCriterion("fine <", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineLessThanOrEqualTo(Long value) {
            addCriterion("fine <=", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineIn(List<Long> values) {
            addCriterion("fine in", values, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotIn(List<Long> values) {
            addCriterion("fine not in", values, "fine");
            return (Criteria) this;
        }

        public Criteria andFineBetween(Long value1, Long value2) {
            addCriterion("fine between", value1, value2, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotBetween(Long value1, Long value2) {
            addCriterion("fine not between", value1, value2, "fine");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}