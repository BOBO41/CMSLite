package com.xiang.bean.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andImgUrlAIsNull() {
            addCriterion("img_url_a is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlAIsNotNull() {
            addCriterion("img_url_a is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlAEqualTo(String value) {
            addCriterion("img_url_a =", value, "imgUrlA");
            return (Criteria) this;
        }

        public Criteria andImgUrlANotEqualTo(String value) {
            addCriterion("img_url_a <>", value, "imgUrlA");
            return (Criteria) this;
        }

        public Criteria andImgUrlAGreaterThan(String value) {
            addCriterion("img_url_a >", value, "imgUrlA");
            return (Criteria) this;
        }

        public Criteria andImgUrlAGreaterThanOrEqualTo(String value) {
            addCriterion("img_url_a >=", value, "imgUrlA");
            return (Criteria) this;
        }

        public Criteria andImgUrlALessThan(String value) {
            addCriterion("img_url_a <", value, "imgUrlA");
            return (Criteria) this;
        }

        public Criteria andImgUrlALessThanOrEqualTo(String value) {
            addCriterion("img_url_a <=", value, "imgUrlA");
            return (Criteria) this;
        }

        public Criteria andImgUrlALike(String value) {
            addCriterion("img_url_a like", value, "imgUrlA");
            return (Criteria) this;
        }

        public Criteria andImgUrlANotLike(String value) {
            addCriterion("img_url_a not like", value, "imgUrlA");
            return (Criteria) this;
        }

        public Criteria andImgUrlAIn(List<String> values) {
            addCriterion("img_url_a in", values, "imgUrlA");
            return (Criteria) this;
        }

        public Criteria andImgUrlANotIn(List<String> values) {
            addCriterion("img_url_a not in", values, "imgUrlA");
            return (Criteria) this;
        }

        public Criteria andImgUrlABetween(String value1, String value2) {
            addCriterion("img_url_a between", value1, value2, "imgUrlA");
            return (Criteria) this;
        }

        public Criteria andImgUrlANotBetween(String value1, String value2) {
            addCriterion("img_url_a not between", value1, value2, "imgUrlA");
            return (Criteria) this;
        }

        public Criteria andImgUrlBIsNull() {
            addCriterion("img_url_b is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlBIsNotNull() {
            addCriterion("img_url_b is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlBEqualTo(String value) {
            addCriterion("img_url_b =", value, "imgUrlB");
            return (Criteria) this;
        }

        public Criteria andImgUrlBNotEqualTo(String value) {
            addCriterion("img_url_b <>", value, "imgUrlB");
            return (Criteria) this;
        }

        public Criteria andImgUrlBGreaterThan(String value) {
            addCriterion("img_url_b >", value, "imgUrlB");
            return (Criteria) this;
        }

        public Criteria andImgUrlBGreaterThanOrEqualTo(String value) {
            addCriterion("img_url_b >=", value, "imgUrlB");
            return (Criteria) this;
        }

        public Criteria andImgUrlBLessThan(String value) {
            addCriterion("img_url_b <", value, "imgUrlB");
            return (Criteria) this;
        }

        public Criteria andImgUrlBLessThanOrEqualTo(String value) {
            addCriterion("img_url_b <=", value, "imgUrlB");
            return (Criteria) this;
        }

        public Criteria andImgUrlBLike(String value) {
            addCriterion("img_url_b like", value, "imgUrlB");
            return (Criteria) this;
        }

        public Criteria andImgUrlBNotLike(String value) {
            addCriterion("img_url_b not like", value, "imgUrlB");
            return (Criteria) this;
        }

        public Criteria andImgUrlBIn(List<String> values) {
            addCriterion("img_url_b in", values, "imgUrlB");
            return (Criteria) this;
        }

        public Criteria andImgUrlBNotIn(List<String> values) {
            addCriterion("img_url_b not in", values, "imgUrlB");
            return (Criteria) this;
        }

        public Criteria andImgUrlBBetween(String value1, String value2) {
            addCriterion("img_url_b between", value1, value2, "imgUrlB");
            return (Criteria) this;
        }

        public Criteria andImgUrlBNotBetween(String value1, String value2) {
            addCriterion("img_url_b not between", value1, value2, "imgUrlB");
            return (Criteria) this;
        }

        public Criteria andImgUrlCIsNull() {
            addCriterion("img_url_c is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlCIsNotNull() {
            addCriterion("img_url_c is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlCEqualTo(String value) {
            addCriterion("img_url_c =", value, "imgUrlC");
            return (Criteria) this;
        }

        public Criteria andImgUrlCNotEqualTo(String value) {
            addCriterion("img_url_c <>", value, "imgUrlC");
            return (Criteria) this;
        }

        public Criteria andImgUrlCGreaterThan(String value) {
            addCriterion("img_url_c >", value, "imgUrlC");
            return (Criteria) this;
        }

        public Criteria andImgUrlCGreaterThanOrEqualTo(String value) {
            addCriterion("img_url_c >=", value, "imgUrlC");
            return (Criteria) this;
        }

        public Criteria andImgUrlCLessThan(String value) {
            addCriterion("img_url_c <", value, "imgUrlC");
            return (Criteria) this;
        }

        public Criteria andImgUrlCLessThanOrEqualTo(String value) {
            addCriterion("img_url_c <=", value, "imgUrlC");
            return (Criteria) this;
        }

        public Criteria andImgUrlCLike(String value) {
            addCriterion("img_url_c like", value, "imgUrlC");
            return (Criteria) this;
        }

        public Criteria andImgUrlCNotLike(String value) {
            addCriterion("img_url_c not like", value, "imgUrlC");
            return (Criteria) this;
        }

        public Criteria andImgUrlCIn(List<String> values) {
            addCriterion("img_url_c in", values, "imgUrlC");
            return (Criteria) this;
        }

        public Criteria andImgUrlCNotIn(List<String> values) {
            addCriterion("img_url_c not in", values, "imgUrlC");
            return (Criteria) this;
        }

        public Criteria andImgUrlCBetween(String value1, String value2) {
            addCriterion("img_url_c between", value1, value2, "imgUrlC");
            return (Criteria) this;
        }

        public Criteria andImgUrlCNotBetween(String value1, String value2) {
            addCriterion("img_url_c not between", value1, value2, "imgUrlC");
            return (Criteria) this;
        }

        public Criteria andDelIsNull() {
            addCriterion("del is null");
            return (Criteria) this;
        }

        public Criteria andDelIsNotNull() {
            addCriterion("del is not null");
            return (Criteria) this;
        }

        public Criteria andDelEqualTo(Boolean value) {
            addCriterion("del =", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotEqualTo(Boolean value) {
            addCriterion("del <>", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThan(Boolean value) {
            addCriterion("del >", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("del >=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThan(Boolean value) {
            addCriterion("del <", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThanOrEqualTo(Boolean value) {
            addCriterion("del <=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelIn(List<Boolean> values) {
            addCriterion("del in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotIn(List<Boolean> values) {
            addCriterion("del not in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelBetween(Boolean value1, Boolean value2) {
            addCriterion("del between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("del not between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
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