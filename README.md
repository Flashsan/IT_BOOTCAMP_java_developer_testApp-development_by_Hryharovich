# itBootcampJavaTestTask

# *****************************************

# ТЕСТОВОЕ ЗАДАНИЕ ДЛЯ JAVA DEVELOPER

# *****************************************

# ТРЕБОВАНИЯ:

# Обязательные:

# 1) Многомодульный maven проект (3-level three-module development architecture)

# 2)Система контроля версий – Git (Тестовый проект должен быть залит на GitHub и должен быть предоставлен к нему публичный доступ).

# 3) Технологии:

# *Java 17+ (+)

# *Log4j2 как система логирования (+)

# *Spring Boot 3(или Tomcat 10 + Spring 6) (+)

# *Hibernate 6 (+)

# *MySQL 8 (+)

# Опционально:

# Использование Docker и Docker Compose для контейнеризации проекта (-)

# Unit и Integration тесты на приложение (-)

# Использование Liquibase/Flyway для миграции базы данных API (+)

# Требования:

# Формат: JSON (+)

# Архитектурный стиль: REST (+)

# Endpoint для добавления пользователя:

# Основные поля:

# Фамилия (40 символов, только латинские буквы)(+)

# Имя (20 символов, только латинские буквы)(+)

# Отчество (40 символов, только латинские буквы)(+)

# Email (50 символов, стандартный шаблон)(+)

# Role (Administrator, Sale User, Customer User, Secure API User)(+)

# Endpoint для получения всех пользователей:

# Основные поля:

# ФИО

# Email

# Role

# Записи должны быть отсортированы по email в алфавитном порядке.

# Опционально:

# Обработка ошибок(+-)

# Постраничный вывод записей по 10 для получения пользователя(+)

# Запуск приложения
изменить настройки БД в файле application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/info_clients?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=admin
изменить настройки БД в файле liquibase.properties:
url=jdbc:mysql://localhost:3306/info_clients
username=root
password=admin

# Получение данных:



# показать всех: http://localhost:8080/api/clients/showAll

# показать всех согласно условию: http://localhost:8080/api/clients/showAll?pageSize=10&pageNo=0&sortBy=emailClient&sortDir=asc

# найти по id: http://localhost:8080/api/clients/getById/2

# добавить нового: http://localhost:8080/api/clients/create

# редактировать по id: http://localhost:8080/api/clients/update/1

# удалить по id: http://localhost:8080/api/clients/getById/5
