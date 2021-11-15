## Приложение "Заметки"
Используется Spring Boot, Spring Data JPA, Lombok, H2 на диске
### Сборка и запуск 
```bash
  mvn spring-boot:run
```
### Использование
Открыть в браузере:
http://localhost:8080
#### Запуск консоли H2
http://localhost:8080/h2-console

### Функции
<ul>
<li>Просмотр всех заметок</li>
<li>Добавить заметку</li>
<li>Изменить заметку</li>
<li>Удалить заметку</li>
</ul>

### Прочее
Используется автоматический смешанный режим работы H2(http://h2database.com/html/features.html#auto_mixed_mode):
первое соединение с базой данных выполняется во встроенном режиме, и дополнительно сервер запускается изнутри 
(как поток демона). Если база данных уже открыта в другом процессе, автоматически используется режим сервера. 
IP-адрес и порт сервера хранятся в файле .lock.db, поэтому базы данных в памяти не поддерживаются.
