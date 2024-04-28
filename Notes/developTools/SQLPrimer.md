# SQLPrimer
## Sql Syntax Note
### DDL: Data Definition Language
#### CREATE
- Create Database
<tabs>
<tab title="Code">
<code-block lang="sql">
CREATE DATABASE IF NOT EXISTS database_name
CHARACTER SET charset_name
COLLATE collation_name;
</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
CREATE DATABASE IF NOT EXISTS MyNewDatabase
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;
</code-block>
</tab>
</tabs>
- Create Table
<tabs>
<tab title="Code">
<code-block lang="sql">
CREATE TABLE table_name (
    column_name datatype [constraints],
    ...
    [INDEX|KEY] [index_name] (column_name [, ...])
    ...
);
</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR(100),
    Position VARCHAR(50),
    HireDate DATE,
    INDEX index_name1 (column1),
    INDEX index_name2 (column2, column3),
    PRIMARY KEY (column1),
    UNIQUE INDEX unique_index_name (column2)
);
</code-block>
</tab>
</tabs>
- Create Index
<tabs>
<tab title="Code">
<code-block lang="sql">
-- 添加单列索引
CREATE INDEX index_name ON table_name (column_name);
-- 添加复合索引
CREATE INDEX index_name ON table_name (column1, column2);
-- 添加唯一索引
CREATE UNIQUE INDEX index_name ON table_name (column_name);
-- 添加全文索引
CREATE FULLTEXT INDEX index_name ON table_name (column_name);
</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
-- 添加单列索引
CREATE INDEX index_name ON table_name (column_name);
-- 添加复合索引
CREATE INDEX index_name ON table_name (column1, column2);
-- 添加唯一索引
CREATE UNIQUE INDEX index_name ON table_name (column_name);
-- 添加全文索引
CREATE FULLTEXT INDEX index_name ON table_name (column_name);
</code-block>
</tab>
</tabs>
- Create View
<tabs>
<tab title="Code">
<code-block lang="sql">
CREATE VIEW view_name AS
SELECT column1, column2, ...
FROM table_name
WHERE condition;
</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
CREATE VIEW view_name AS
SELECT column1, column2, ...
FROM table_name
WHERE condition;
</code-block>
</tab>
</tabs>

#### ALTER
- Alter Table
<tabs>
<tab title="Code">
<code-block lang="sql">
-- 添加新列
ALTER TABLE table_name
ADD column_name datatype [constraint];

-- 修改现有列的数据类型或约束
ALTER TABLE table_name
MODIFY COLUMN column_name new_datatype [constraint];

-- 删除列
ALTER TABLE table_name
DROP COLUMN column_name;

-- 重命名列
ALTER TABLE table_name
CHANGE COLUMN old_column_name TO new_datatype [constraint];

-- 重命名表
ALTER TABLE old_table_name
RENAME TO new_table_name;

</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
-- 添加新列
ALTER TABLE Employees
ADD Email VARCHAR(255);

-- 修改现有列的数据类型
ALTER TABLE Employees
MODIFY Name VARCHAR(255);

-- 删除列
ALTER TABLE Employees
DROP COLUMN HireDate;

-- 重命名列
ALTER TABLE Employees
CHANGE COLUMN Position TO JobTitle VARCHAR(50);

-- 重命名表
ALTER TABLE Employees
RENAME TO StaffMembers;
</code-block>
</tab>
</tabs>

- Alter Index
<tabs>
<tab title="Code">
<code-block lang="sql">
-- 添加索引
ALTER TABLE table_name
ADD [CONSTRAINT constraint_name]
[INDEX|KEY] [index_name] (column_name [, ...]);

-- 删除索引
ALTER TABLE table_name
DROP INDEX index_name;
</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
-- 添加索引
ALTER TABLE Employees
ADD INDEX idx_name (Name);

-- 删除索引
ALTER TABLE Employees
DROP INDEX idx_name;
</code-block>
</tab>
</tabs>

- Alter View
<tabs>
<tab title="Code">
<code-block lang="sql">
-- 更新视图
ALTER VIEW view_name AS
SELECT column1, column2, ...
FROM table_name
WHERE new_condition;
-- 删除视图
DROP VIEW view_name;
</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
-- 更新视图
ALTER VIEW view_name AS
SELECT column1, column2, ...
FROM table_name
WHERE new_condition;
-- 删除视图
DROP VIEW view_name;
</code-block>
</tab>
</tabs>

#### DROP
- Drop Database
<tabs>
<tab title="Code">
<code-block lang="sql">
DROP DATABASE if_exists database_name;
</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
DROP DATABASE if_exists database_name;
</code-block>
</tab>
</tabs>

- Drop Table
<tabs>
<tab title="Code">
<code-block lang="sql">
DROP TABLE if_exists table_name;
</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
DROP TABLE if_exists table_name;
</code-block>
</tab>
</tabs>

- Drop Index
<tabs>
<tab title="Code">
<code-block lang="sql">
DROP INDEX index_name ON table_name;
</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
DROP INDEX index_name ON table_name;
</code-block>
</tab>
</tabs>

- Drop View
<tabs>
<tab title="Code">
<code-block lang="sql">
DROP VIEW if_exists view_name;
</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
DROP VIEW if_exists view_name;
</code-block>
</tab>
</tabs>

#### TRUNCATE
- Truncate Table
<tabs>
<tab title="Code">
<code-block lang="sql">
TRUNCATE TABLE table_name;
</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
TRUNCATE TABLE Employees;
</code-block>
</tab>
</tabs>


### DML: Data Manipulation Language
#### INSERT
- Insert data into table
<tabs>
<tab title="Code">
<code-block lang="sql">
-- 单行插入
INSERT INTO table_name (column1, column2, column3, ...)
VALUES (value1, value2, value3, ...);
-- 多行插入
INSERT INTO table_name (column1, column2)
VALUES (value1a, value2a),
       (value1b, value2b),
       (value1c, value2c);
-- 插入查询结果
INSERT INTO table_name (column1, column2)
SELECT column1, column2
FROM another_table
WHERE condition;
</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
-- 单行插入
INSERT INTO Employees (Name, Department)
VALUES ('John Doe', 'Marketing');
-- 多行插入
INSERT INTO Employees (Name, Department)
VALUES ('Alice Smith', 'HR'),
       ('Bob Johnson', 'IT'),
       ('Carol Williams', 'Finance');
-- 插入查询结果
INSERT INTO Employees (Name, Department)
SELECT student_name, department
FROM Graduates
WHERE graduation_year = 2022;
</code-block>
</tab>
</tabs>

#### UPDATE
- Update Data
<tabs>
<tab title="Code">
<code-block lang="sql">
-- 条件更新
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;
</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
-- 条件更新
UPDATE Employees
SET Salary = Salary + 500
WHERE Department = 'Sales';
-- 条件更新多个列
UPDATE Employees
SET Salary = 75000, Department = 'Marketing'
WHERE EmployeeID = 123;
-- 连接更新
UPDATE Employees e
JOIN Departments d ON e.DepartmentID = d.DepartmentID
SET e.Department = d.DepartmentName
WHERE d.DepartmentName = 'Human Resources';
</code-block>
</tab>
</tabs>

#### DELETE
- Delete Data From Table
<tabs>
<tab title="Code">
<code-block lang="sql">
DELETE FROM table_name WHERE condition;
</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
DELETE FROM Employees WHERE Department = 'Sales';
</code-block>
</tab>
</tabs>


### DQL: Data Query Language
#### SELECT
- Normal Query
<tabs>
<tab title="Code">
<code-block lang="sql">
SELECT column1, column2, ...
FROM table_name
WHERE condition
ORDER BY column
GROUP BY column
HAVING condition
LIMIT number;
</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
SELECT Department, COUNT(*) AS NumberOfEmployees
FROM Employees
WHERE Department = 'Sales'
ORDER Gender
GROUP BY column
HAVING COUNT(*) > 10
LIMIT 5;
</code-block>
</tab>
</tabs>
<procedure title="The execution order of SQL statements." id="order">
<step>
<p>
FROM: This is the first step where the SQL processor retrieves data from the specified tables (or joins of tables). 
Before processing any other logic, it must be determined from which tables to retrieve data.
</p>
</step>
<step>
<p>
JOIN: If multiple tables are specified in the FROM clause, SQL will merge these tables according to the JOIN conditions
after retrieving the data. This includes handling any ON or USING conditions that specify how to join the tables.
</p>
</step>
<step>
<p>
WHERE: This step filters the dataset produced by the FROM and JOIN. The conditions in the WHERE clause are applied to 
thisdataset, and only rows that meet the conditions will proceed to the next phase.
</p>
</step>
<step>
<p>
GROUP BY: If the query specifies a GROUP BY clause, the next step is to group the result set by the specified columns. 
This is a prerequisite for aggregation functions (such as COUNT, SUM, AVG, etc.), as these functions are typically 
applied to the groups afterward.
</p>
</step>
<step>
<p>
HAVING: Similar to the WHERE clause, the HAVING clause is used for filtering, but it occurs after GROUP BY, filtering the 
aggregated results. The HAVING clause can only be used with aggregation functions.
</p>
</step>
<step>
<p>
SELECT: This step selects specified columns or expressions from the results above. Before this step, more data columns 
might have been processed to meet the needs of JOIN, WHERE, or GROUP BY, but during the SELECT phase, only the needed 
columns are extracted.
</p>
</step>
<step>
<p>
DISTINCT: If the DISTINCT keyword is specified, this step removes duplicate rows. It is usually performed after SELECT 
to ensure no duplicate rows in the returned result set.
</p>
</step>
<step>
<p>
ORDER BY: This step is one of the last to be performed, used to sort the final result set based on one or more columns. 
Sorting is often one of the most performance-intensive parts of query processing, especially when dealing with large amounts of data.
</p>
</step>
<step>
<p>
LIMIT: This is the final step, used to limit the number of records returned (LIMIT) and specify from which record to 
start returning (OFFSET), commonly used in data pagination
</p>
</step>
</procedure>

- Join Query
<tabs>
<tab title="Code">
<code-block lang="sql">
-- 默认使用inner join
SELECT Employees.Name, Departments.DepartmentName
FROM Employees
JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID;
-- 显示使用inner join
SELECT columns
FROM table1
INNER JOIN table2
ON table1.common_field = table2.common_field;
-- left join
SELECT columns
FROM table1
LEFT JOIN table2
ON table1.common_field = table2.common_field;
-- right join
SELECT columns
FROM table1
RIGHT JOIN table2
ON table1.common_field = table2.common_field;
-- full join
SELECT columns
FROM table1
LEFT JOIN table2
ON table1.common_field = table2.common_field
UNION (ALL)
SELECT columns
FROM table1
RIGHT JOIN table2
ON table1.common_field = table2.common_field;

</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
-- 默认使用inner join
SELECT Employees.Name, Departments.DepartmentName
FROM Employees
JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID;
-- 显示使用inner join
SELECT Employees.Name, Departments.DepartmentName
FROM Employees
INNER JOIN Departments
ON Employees.DepartmentID = Departments.DepartmentID;
-- left join
SELECT Employees.Name, Departments.DepartmentName
FROM Employees
LEFT JOIN Departments
ON Employees.DepartmentID = Departments.DepartmentID;
-- right join
SELECT Employees.Name, Departments.DepartmentName
FROM Employees
RIGHT JOIN Departments
ON Employees.DepartmentID = Departments.DepartmentID;
</code-block>
</tab>
</tabs>

- Sub Query
<tabs>
<tab title="Code">
<code-block lang="sql">
SELECT column1, (SELECT CLAUSE), ...
FROM (SELECT CLAUSE)
WHERE (SELECT CLAUSE)
ORDER BY column
GROUP BY column
HAVING (SELECT CLAUSE)
LIMIT number;
</code-block>
</tab>
<tab title="Example">
<code-block lang="sql">
-- 标量查询
SELECT Name
FROM Employees
WHERE Salary > (SELECT AVG(Salary) FROM Employees);
-- 列子查询
SELECT Name
FROM Employees
WHERE DepartmentID IN (SELECT DepartmentID FROM Departments WHERE Location = 'New York');
-- 行子查询
SELECT Name, Position
FROM Employees
WHERE (Name, Position) = (SELECT Name, Position FROM Employees WHERE EmployeeID = 123);
-- 表子查询
SELECT DepartmentName
FROM (
    SELECT DepartmentID, AVG(Salary) AS AvgSalary
    FROM Employees
    GROUP BY DepartmentID
) AS DeptSalaries
WHERE AvgSalary > (SELECT AVG(Salary) FROM Employees);
</code-block>
</tab>
</tabs>