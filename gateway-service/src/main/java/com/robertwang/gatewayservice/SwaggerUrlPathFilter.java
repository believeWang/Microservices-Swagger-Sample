package com.robertwang.gatewayservice;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Component
public class SwaggerUrlPathFilter extends ZuulFilter {

  @Override
  public String filterType() {
    return "route";
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    String requestURI = RequestContext.getCurrentContext().getRequest().getRequestURI();
    return requestURI.matches("/v3/api-docs/.+");
  }

  @Override
  public Object run() {
    RequestContext context = RequestContext.getCurrentContext();
    context.put(FilterConstants.REQUEST_URI_KEY, "/");
    return null;
  }
}
