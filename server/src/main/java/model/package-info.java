@FilterDef(name = "dateFilter", parameters = {
    @ParamDef(name = "startDate", type = "java.sql.Timestamp"),
    @ParamDef(name = "endDate", type = "java.sql.Timestamp")})

@FilterDef(name = "priceFilter", parameters = {@ParamDef(name = "pricePerNight", type = "int"),})

@FilterDef(name = "searchFilter", parameters = {@ParamDef(name = "country", type = "string"),
    @ParamDef(name = "city", type = "string"), @ParamDef(name = "street", type = "string"),})

@FilterDef(name = "amenityFilter", parameters = {@ParamDef(name = "amenity", type = "string"),})

@FilterDef(name = "reviewFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"),
defaultCondition = "is_deleted = :isDeleted")

package model;

import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;


