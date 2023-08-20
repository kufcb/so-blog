package com.soblog.filter;

import com.commons.constant.JwtConstant;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author yys
 * @date 2023/8/20 22:15
 * @desc 过滤器 验证token
 */
public class UserAuthFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String authHeader = exchange.getRequest().getHeaders().getFirst(JwtConstant.TOKEN_HEADER);
        if(authHeader != null){

        }
        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
