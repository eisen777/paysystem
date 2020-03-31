set PGPASSWORD=postgres
"C:\Program Files\PostgreSQL\11\bin\psql.exe" -h localhost -U postgres -d paysystem -p 5432 -f clean_table_client.sql
cd "C:\Users\Dmitry\IdeaProjects\paysystem"
rmdir /Q /S out
mvn clean package