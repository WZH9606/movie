package com.rec.movie.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MovieinfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table movieinfo
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table movieinfo
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table movieinfo
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movieinfo
     *
     * @mbggenerated
     */
    public MovieinfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movieinfo
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movieinfo
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movieinfo
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movieinfo
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movieinfo
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movieinfo
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movieinfo
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movieinfo
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movieinfo
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movieinfo
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table movieinfo
     *
     * @mbggenerated
     */
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andMovieidIsNull() {
            addCriterion("movieid is null");
            return (Criteria) this;
        }

        public Criteria andMovieidIsNotNull() {
            addCriterion("movieid is not null");
            return (Criteria) this;
        }

        public Criteria andMovieidEqualTo(Integer value) {
            addCriterion("movieid =", value, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidNotEqualTo(Integer value) {
            addCriterion("movieid <>", value, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidGreaterThan(Integer value) {
            addCriterion("movieid >", value, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidGreaterThanOrEqualTo(Integer value) {
            addCriterion("movieid >=", value, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidLessThan(Integer value) {
            addCriterion("movieid <", value, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidLessThanOrEqualTo(Integer value) {
            addCriterion("movieid <=", value, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidIn(List<Integer> values) {
            addCriterion("movieid in", values, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidNotIn(List<Integer> values) {
            addCriterion("movieid not in", values, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidBetween(Integer value1, Integer value2) {
            addCriterion("movieid between", value1, value2, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovieidNotBetween(Integer value1, Integer value2) {
            addCriterion("movieid not between", value1, value2, "movieid");
            return (Criteria) this;
        }

        public Criteria andMovienameIsNull() {
            addCriterion("moviename is null");
            return (Criteria) this;
        }

        public Criteria andMovienameIsNotNull() {
            addCriterion("moviename is not null");
            return (Criteria) this;
        }

        public Criteria andMovienameEqualTo(String value) {
            addCriterion("moviename =", value, "moviename");
            return (Criteria) this;
        }

        public Criteria andMovienameNotEqualTo(String value) {
            addCriterion("moviename <>", value, "moviename");
            return (Criteria) this;
        }

        public Criteria andMovienameGreaterThan(String value) {
            addCriterion("moviename >", value, "moviename");
            return (Criteria) this;
        }

        public Criteria andMovienameGreaterThanOrEqualTo(String value) {
            addCriterion("moviename >=", value, "moviename");
            return (Criteria) this;
        }

        public Criteria andMovienameLessThan(String value) {
            addCriterion("moviename <", value, "moviename");
            return (Criteria) this;
        }

        public Criteria andMovienameLessThanOrEqualTo(String value) {
            addCriterion("moviename <=", value, "moviename");
            return (Criteria) this;
        }

        public Criteria andMovienameLike(String value) {
            addCriterion("moviename like", value, "moviename");
            return (Criteria) this;
        }

        public Criteria andMovienameNotLike(String value) {
            addCriterion("moviename not like", value, "moviename");
            return (Criteria) this;
        }

        public Criteria andMovienameIn(List<String> values) {
            addCriterion("moviename in", values, "moviename");
            return (Criteria) this;
        }

        public Criteria andMovienameNotIn(List<String> values) {
            addCriterion("moviename not in", values, "moviename");
            return (Criteria) this;
        }

        public Criteria andMovienameBetween(String value1, String value2) {
            addCriterion("moviename between", value1, value2, "moviename");
            return (Criteria) this;
        }

        public Criteria andMovienameNotBetween(String value1, String value2) {
            addCriterion("moviename not between", value1, value2, "moviename");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIsNull() {
            addCriterion("releasetime is null");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIsNotNull() {
            addCriterion("releasetime is not null");
            return (Criteria) this;
        }

        public Criteria andReleasetimeEqualTo(Date value) {
            addCriterionForJDBCDate("releasetime =", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("releasetime <>", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("releasetime >", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("releasetime >=", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLessThan(Date value) {
            addCriterionForJDBCDate("releasetime <", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("releasetime <=", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIn(List<Date> values) {
            addCriterionForJDBCDate("releasetime in", values, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("releasetime not in", values, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("releasetime between", value1, value2, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("releasetime not between", value1, value2, "releasetime");
            return (Criteria) this;
        }

        public Criteria andDirectorIsNull() {
            addCriterion("director is null");
            return (Criteria) this;
        }

        public Criteria andDirectorIsNotNull() {
            addCriterion("director is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorEqualTo(String value) {
            addCriterion("director =", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotEqualTo(String value) {
            addCriterion("director <>", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorGreaterThan(String value) {
            addCriterion("director >", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorGreaterThanOrEqualTo(String value) {
            addCriterion("director >=", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLessThan(String value) {
            addCriterion("director <", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLessThanOrEqualTo(String value) {
            addCriterion("director <=", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLike(String value) {
            addCriterion("director like", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotLike(String value) {
            addCriterion("director not like", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorIn(List<String> values) {
            addCriterion("director in", values, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotIn(List<String> values) {
            addCriterion("director not in", values, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorBetween(String value1, String value2) {
            addCriterion("director between", value1, value2, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotBetween(String value1, String value2) {
            addCriterion("director not between", value1, value2, "director");
            return (Criteria) this;
        }

        public Criteria andLeadactorsIsNull() {
            addCriterion("leadactors is null");
            return (Criteria) this;
        }

        public Criteria andLeadactorsIsNotNull() {
            addCriterion("leadactors is not null");
            return (Criteria) this;
        }

        public Criteria andLeadactorsEqualTo(String value) {
            addCriterion("leadactors =", value, "leadactors");
            return (Criteria) this;
        }

        public Criteria andLeadactorsNotEqualTo(String value) {
            addCriterion("leadactors <>", value, "leadactors");
            return (Criteria) this;
        }

        public Criteria andLeadactorsGreaterThan(String value) {
            addCriterion("leadactors >", value, "leadactors");
            return (Criteria) this;
        }

        public Criteria andLeadactorsGreaterThanOrEqualTo(String value) {
            addCriterion("leadactors >=", value, "leadactors");
            return (Criteria) this;
        }

        public Criteria andLeadactorsLessThan(String value) {
            addCriterion("leadactors <", value, "leadactors");
            return (Criteria) this;
        }

        public Criteria andLeadactorsLessThanOrEqualTo(String value) {
            addCriterion("leadactors <=", value, "leadactors");
            return (Criteria) this;
        }

        public Criteria andLeadactorsLike(String value) {
            addCriterion("leadactors like", value, "leadactors");
            return (Criteria) this;
        }

        public Criteria andLeadactorsNotLike(String value) {
            addCriterion("leadactors not like", value, "leadactors");
            return (Criteria) this;
        }

        public Criteria andLeadactorsIn(List<String> values) {
            addCriterion("leadactors in", values, "leadactors");
            return (Criteria) this;
        }

        public Criteria andLeadactorsNotIn(List<String> values) {
            addCriterion("leadactors not in", values, "leadactors");
            return (Criteria) this;
        }

        public Criteria andLeadactorsBetween(String value1, String value2) {
            addCriterion("leadactors between", value1, value2, "leadactors");
            return (Criteria) this;
        }

        public Criteria andLeadactorsNotBetween(String value1, String value2) {
            addCriterion("leadactors not between", value1, value2, "leadactors");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andAveratingIsNull() {
            addCriterion("averating is null");
            return (Criteria) this;
        }

        public Criteria andAveratingIsNotNull() {
            addCriterion("averating is not null");
            return (Criteria) this;
        }

        public Criteria andAveratingEqualTo(Double value) {
            addCriterion("averating =", value, "averating");
            return (Criteria) this;
        }

        public Criteria andAveratingNotEqualTo(Double value) {
            addCriterion("averating <>", value, "averating");
            return (Criteria) this;
        }

        public Criteria andAveratingGreaterThan(Double value) {
            addCriterion("averating >", value, "averating");
            return (Criteria) this;
        }

        public Criteria andAveratingGreaterThanOrEqualTo(Double value) {
            addCriterion("averating >=", value, "averating");
            return (Criteria) this;
        }

        public Criteria andAveratingLessThan(Double value) {
            addCriterion("averating <", value, "averating");
            return (Criteria) this;
        }

        public Criteria andAveratingLessThanOrEqualTo(Double value) {
            addCriterion("averating <=", value, "averating");
            return (Criteria) this;
        }

        public Criteria andAveratingIn(List<Double> values) {
            addCriterion("averating in", values, "averating");
            return (Criteria) this;
        }

        public Criteria andAveratingNotIn(List<Double> values) {
            addCriterion("averating not in", values, "averating");
            return (Criteria) this;
        }

        public Criteria andAveratingBetween(Double value1, Double value2) {
            addCriterion("averating between", value1, value2, "averating");
            return (Criteria) this;
        }

        public Criteria andAveratingNotBetween(Double value1, Double value2) {
            addCriterion("averating not between", value1, value2, "averating");
            return (Criteria) this;
        }

        public Criteria andNumratingIsNull() {
            addCriterion("numrating is null");
            return (Criteria) this;
        }

        public Criteria andNumratingIsNotNull() {
            addCriterion("numrating is not null");
            return (Criteria) this;
        }

        public Criteria andNumratingEqualTo(Integer value) {
            addCriterion("numrating =", value, "numrating");
            return (Criteria) this;
        }

        public Criteria andNumratingNotEqualTo(Integer value) {
            addCriterion("numrating <>", value, "numrating");
            return (Criteria) this;
        }

        public Criteria andNumratingGreaterThan(Integer value) {
            addCriterion("numrating >", value, "numrating");
            return (Criteria) this;
        }

        public Criteria andNumratingGreaterThanOrEqualTo(Integer value) {
            addCriterion("numrating >=", value, "numrating");
            return (Criteria) this;
        }

        public Criteria andNumratingLessThan(Integer value) {
            addCriterion("numrating <", value, "numrating");
            return (Criteria) this;
        }

        public Criteria andNumratingLessThanOrEqualTo(Integer value) {
            addCriterion("numrating <=", value, "numrating");
            return (Criteria) this;
        }

        public Criteria andNumratingIn(List<Integer> values) {
            addCriterion("numrating in", values, "numrating");
            return (Criteria) this;
        }

        public Criteria andNumratingNotIn(List<Integer> values) {
            addCriterion("numrating not in", values, "numrating");
            return (Criteria) this;
        }

        public Criteria andNumratingBetween(Integer value1, Integer value2) {
            addCriterion("numrating between", value1, value2, "numrating");
            return (Criteria) this;
        }

        public Criteria andNumratingNotBetween(Integer value1, Integer value2) {
            addCriterion("numrating not between", value1, value2, "numrating");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andTypelistIsNull() {
            addCriterion("typelist is null");
            return (Criteria) this;
        }

        public Criteria andTypelistIsNotNull() {
            addCriterion("typelist is not null");
            return (Criteria) this;
        }

        public Criteria andTypelistEqualTo(String value) {
            addCriterion("typelist =", value, "typelist");
            return (Criteria) this;
        }

        public Criteria andTypelistNotEqualTo(String value) {
            addCriterion("typelist <>", value, "typelist");
            return (Criteria) this;
        }

        public Criteria andTypelistGreaterThan(String value) {
            addCriterion("typelist >", value, "typelist");
            return (Criteria) this;
        }

        public Criteria andTypelistGreaterThanOrEqualTo(String value) {
            addCriterion("typelist >=", value, "typelist");
            return (Criteria) this;
        }

        public Criteria andTypelistLessThan(String value) {
            addCriterion("typelist <", value, "typelist");
            return (Criteria) this;
        }

        public Criteria andTypelistLessThanOrEqualTo(String value) {
            addCriterion("typelist <=", value, "typelist");
            return (Criteria) this;
        }

        public Criteria andTypelistLike(String value) {
            addCriterion("typelist like", value, "typelist");
            return (Criteria) this;
        }

        public Criteria andTypelistNotLike(String value) {
            addCriterion("typelist not like", value, "typelist");
            return (Criteria) this;
        }

        public Criteria andTypelistIn(List<String> values) {
            addCriterion("typelist in", values, "typelist");
            return (Criteria) this;
        }

        public Criteria andTypelistNotIn(List<String> values) {
            addCriterion("typelist not in", values, "typelist");
            return (Criteria) this;
        }

        public Criteria andTypelistBetween(String value1, String value2) {
            addCriterion("typelist between", value1, value2, "typelist");
            return (Criteria) this;
        }

        public Criteria andTypelistNotBetween(String value1, String value2) {
            addCriterion("typelist not between", value1, value2, "typelist");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table movieinfo
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table movieinfo
     *
     * @mbggenerated
     */
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