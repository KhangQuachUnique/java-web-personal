# Dùng Tomcat base image chính thức
FROM tomcat:9.0-jdk17-temurin

# Xoá ứng dụng mặc định (ROOT, docs, examples) để nhẹ hơn
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy file .war của bạn vào webapps
COPY target/untitled.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080
EXPOSE 8080

# Chạy Tomcat
CMD ["catalina.sh", "run"]
