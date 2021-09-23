
@FilterDef(name ="dateFilter", parameters = {
    @ParamDef(name = "start_date", type = "java.sql.Timestamp"),
    @ParamDef(name = "end_date", type = "java.sql.Timestamp")
})

@FilterDef(name ="priceFilter", parameters = {
    @ParamDef(name = "price_per_night", type = "int"),
})

@FilterDef(name ="countryFilter", parameters = {
    @ParamDef(name = "country", type = "string"),
})

package model;

import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;


