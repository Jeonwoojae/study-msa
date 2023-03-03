FROM mariadb
ENV MYSQL_ROOT_PASSWORD 1234
ENV MYSQL_DATABASE mydb
COPY ./data /var/lib/mysql
EXPOSE 3306
ENTRYPOINT ["mysqld", "--user=root", "--default-authentication-plugin=mysql_native_password"]