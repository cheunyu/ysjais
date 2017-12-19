package com.scyb.aisbroadcast.webservice;


import com.scyb.aisbroadcast.webservice.bo.NumericalForecastBo;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by foo on 2017/6/29.
 */
@WebService
public interface INumericalForecastService {
    public int numericalForecastService(List<NumericalForecastBo> numericalForecastBoList);
}
