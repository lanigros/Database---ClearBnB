
@FilterDef(name ="dateFilter", parameters = {
    @ParamDef(name = "startDate", type = "java.sql.Timestamp"),
    @ParamDef(name = "endDate", type = "java.sql.Timestamp")
})

@FilterDef(name ="priceFilter", parameters = {
    @ParamDef(name = "pricePerNight", type = "int"),
})

@FilterDef(name ="countryFilter", parameters = {
    @ParamDef(name = "country", type = "string"),
})

package model;

import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;


