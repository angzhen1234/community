## 汪振社区


## 资料
[Spring 文档](https://spring.io/guides)    
[Spring Web文档](https://spring.io/guides/gs/serving-web-content/)   
[es社区](https://elasticsearch.cn/explore)   
[Github deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)  
[Bootstrap](https://v3.bootcss.com/getting-started/)   
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)  
[Spring的官方文档](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)    

## 工具
[GIT下载](https://git-scm.com/download)  
[Visual Paradigm](https://www.visual-paradigm.com) 

## 脚本
```sql
CREATE TABLE USER
(
    ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACCOUNT_ID VARCHAR(100),
    NAME VARCHAR(50),
    TOKEN VARCHAR(36),
    GMT_CREATE BIGINT,
    GMT_MODIFIED BIGINT
);  
```  
```bash  
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate  
```  
