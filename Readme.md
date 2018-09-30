# 2017-10-14

[参考资料](http://sylarlove.coding.me/2016/11/26/spring-cloud-%E5%BE%AE%E6%9C%8D%E5%8A%A1%E6%95%B4%E5%90%88oauth2/#api-gateway-配置)

        项目                  端口	描述
        api-gateway             8080	网关 zuul-proxy
        discovery-server        8761	eureka-server
        auth-server             9091	
        user-service            9092	resource-server
        
#### 简介        
        优点 : 
            1. 使用 数据库 保存用户数据，客户数据，和 token。代码比较规范，说的比较明白。
            2. 使用 zuul 和 服务名称访问服务，而不是使用硬编码的URL，这样可以实现负载均衡
        缺点 ：以下 curl 命令访问受保护资源失败，报告说 invalid_token ， 

        curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "grant_type=password&username=admin&password=admin&redirect_uri=http://localhost:9092/users" "http://web:web_secret@localhost:9091/uaa/oauth/token"
        TOKEN=c94c84b5-7816-4a51-a2c3-e1cb2dbb8fef
        curl -H "Authorization: Bearer $TOKEN" http://localhost:9092/users
        
       
        9092 应用程序异常 ：
        
        2017-10-14 21:45:54.801 DEBUG 11852 --- [nio-9091-exec-8] o.s.s.w.a.i.FilterSecurityInterceptor    : Secure object: FilterInvocation: URL: /user; Attributes: [authenticated]
        2017-10-14 21:45:54.801 DEBUG 11852 --- [nio-9091-exec-8] o.s.b.a.audit.listener.AuditListener     : AuditEvent [timestamp=Sat Oct 14 21:45:54 CST 2017, principal=<unknown>, type=AUTHENTICATION_FAILURE, data={type=org.springframework.security.authentication.AuthenticationCredentialsNotFoundException, message=An Authentication object was not found in the SecurityContext}]
        2017-10-14 21:45:54.802 DEBUG 11852 --- [nio-9091-exec-8] o.s.s.w.a.ExceptionTranslationFilter     : Authentication exception occurred; redirecting to authentication entry point
        
        org.springframework.security.authentication.AuthenticationCredentialsNotFoundException: An Authentication object was not found in the SecurityContext
