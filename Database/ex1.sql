DROP DATABASE Employee_Management;

CREATE DATABASE Employee_Management CHARACTER SET utf8 COLLATE utf8_general_ci;

USE Employee_Management;

CREATE TABLE Provinces(
    ID int NOT NULL AUTO_INCREMENT,
    Province_Name VARCHAR(50),
    PRIMARY KEY (ID)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Employee_Types(
    ID int NOT NULL AUTO_INCREMENT,
    Type_Name VARCHAR(50),
    PRIMARY KEY (ID)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Jobs(
    ID int NOT NULL AUTO_INCREMENT,
    Job_Name VARCHAR(50),
    PRIMARY KEY (ID)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Departments(
    ID int NOT NULL AUTO_INCREMENT,
    Department_Name VARCHAR(50),
    PRIMARY KEY (ID)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Positions(
    ID int NOT NULL AUTO_INCREMENT,
    Position_Name VARCHAR(50),
    PRIMARY KEY (ID)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Knowledges(
    ID int NOT NULL AUTO_INCREMENT,
    Knowledge_Name VARCHAR(50),
    PRIMARY KEY (ID)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Foreign_Languages(
    ID int NOT NULL AUTO_INCREMENT,
    Language_Name VARCHAR(50),
    PRIMARY KEY (ID)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Folks(
    ID int NOT NULL AUTO_INCREMENT,
    Folk_Name VARCHAR(50),
    PRIMARY KEY (ID)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Nationalities(
    ID int NOT NULL AUTO_INCREMENT,
    Nationality_Name VARCHAR(50),
    PRIMARY KEY (ID)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Certificates(
    ID int NOT NULL AUTO_INCREMENT,
    Certificate_Name VARCHAR(50),
    PRIMARY KEY (ID)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IT_Certificates(
    ID int NOT NULL AUTO_INCREMENT,
    IT_Name VARCHAR(50),
    PRIMARY KEY (ID)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Religions(
    ID int NOT NULL AUTO_INCREMENT,
    Religion_Name VARCHAR(50),
    PRIMARY KEY (ID)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Employees(
    ID varchar(4) NOT NULL,
    Full_Name VARCHAR(50) NOT NULL,
    Secret_Name VARCHAR(50),
    Gender Boolean,
    Marital_Status Boolean,
    Mobile_Number VARCHAR(10),
    Phone_Number VARCHAR(11),
    Email VARCHAR(50),
    Date_Of_Birth DATETIME,
    Place_Of_Birth VARCHAR(50),
    Pronvince_ID int,
    Identity_Number VARCHAR(9),
    Date_Of_ID_Registered DATETIME,
    Place_Of_ID_Registered VARCHAR(50),
    Home_Town VARCHAR(50),
    Address VARCHAR(50),
    Temporary_Residence VARCHAR(50),
    Employee_Type_ID int NOT NULL,
    Start_Working_Date DATETIME NOT NULL,
    Department_ID int NOT NULL,
    Job_ID int NOT NULL,
    Position_ID int NOT NULL,
    Basic_Salary bigint NOT NULL,
    Coefficient float NOT NULL,
    Salary bigint,
    Allowance bigint,
    Labour_Number varchar(9),
    Date_Of_Labour_Registered DATETIME,
    Place_Of_Labour_Registered VARCHAR(50),
    Bank_Account VARCHAR(50),
    Bank VARCHAR(50),
    Knowledge_ID int,
    Foreign_Language_ID int,
    Folk_ID int,
    Certificate_ID int,
    IT_Certificate_ID int,
    Nationality_ID int,
    Religion_ID int,
    PRIMARY KEY (ID),
    FOREIGN KEY (Pronvince_ID) REFERENCES Provinces(ID),
    FOREIGN KEY (Employee_Type_ID) REFERENCES Employee_Types(ID),
    FOREIGN KEY (Job_ID) REFERENCES Jobs(ID),
    FOREIGN KEY (Department_ID) REFERENCES Departments(ID),
    FOREIGN KEY (Position_ID) REFERENCES Positions(ID),
    FOREIGN KEY (Knowledge_ID) REFERENCES Knowledges(ID),
    FOREIGN KEY (Foreign_Language_ID) REFERENCES Foreign_Languages(ID),
    FOREIGN KEY (Folk_ID) REFERENCES Folks(ID),
    FOREIGN KEY (Certificate_ID) REFERENCES Certificates(ID),
    FOREIGN KEY (IT_Certificate_ID) REFERENCES IT_Certificates(ID),
    FOREIGN KEY (Nationality_ID) REFERENCES Nationalities(ID),
    FOREIGN KEY (Religion_ID) REFERENCES Religions(ID)
)CHARACTER SET utf8 COLLATE utf8_general_ci;


-- Insert data to table Provinces 
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Hà Nội');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Hà Giang');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Cao Bằng');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Bắc Kạn');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Tuyên Quang');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Lào Cai');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Điện Biên');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Lai Châu');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Sơn La');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Yên Bái');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Hoà Bình');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Thái Nguyên');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Lạng Sơn');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Quảng Ninh');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Bắc Giang');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Phú Thọ');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Vĩnh Phúc');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Bắc Ninh');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Hải Dương');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Hải Phòng');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Hưng Yên');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Thái Bình');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Hà Nam');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Nam Định');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Ninh Bình');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Thanh Hóa');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Nghệ An');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Hà Tĩnh');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Quảng Bình');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Quảng Trị');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Thừa Thiên Huế');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Đà Nẵng');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Quảng Nam');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Quảng Ngãi');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Bình Định');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Phú Yên');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Khánh Hòa');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Ninh Thuận');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Bình Thuận');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Kon Tum');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Gia Lai');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Đắk Lắk');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Đắk Nông');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Lâm Đồng');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Bình Phước');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Tây Ninh');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Bình Dương');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Đồng Nai');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Bà Rịa - Vũng Tàu');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Hồ Chí Minh');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Long An');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Tiền Giang');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Bến Tre');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Trà Vinh');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Vĩnh Long');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Đồng Tháp');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('An Giang');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Kiên Giang');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Cần Thơ');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Hậu Giang');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Sóc Trăng');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Bạc Liêu');
INSERT INTO `Provinces`( `Province_Name`)  VALUES ('Cà Mau');

-- Insert data to table Employee_Types 
INSERT INTO `Employee_Types`(`Type_Name`) VALUES ('Chính thức');
INSERT INTO `Employee_Types`(`Type_Name`) VALUES ('Thử việc');
INSERT INTO `Employee_Types`(`Type_Name`) VALUES ('Thực tập');

-- Insert data to table Jobs 
INSERT INTO `Jobs`(`Job_Name`) VALUES ('Quản lý');

-- Insert data to table Departments 
INSERT INTO `Departments`(`Department_Name`) VALUES ('Phòng kinh doanh');
INSERT INTO `Departments`(`Department_Name`) VALUES ('Phòng hành chính - nhân sự');
INSERT INTO `Departments`(`Department_Name`) VALUES ('Phòng tài chính - kế toán');
INSERT INTO `Departments`(`Department_Name`) VALUES ('Phòng marketing');
INSERT INTO `Departments`(`Department_Name`) VALUES ('Phòng kiểm toán');

-- Insert data to table Positions 
INSERT INTO `Positions`(`Position_Name`) VALUES ('Giám đốc');
INSERT INTO `Positions`(`Position_Name`) VALUES ('Phó giám đốc');
INSERT INTO `Positions`(`Position_Name`) VALUES ('Giám đốc điều hành');
INSERT INTO `Positions`(`Position_Name`) VALUES ('Trưởng phòng');
INSERT INTO `Positions`(`Position_Name`) VALUES ('Trưởng nhóm');
INSERT INTO `Positions`(`Position_Name`) VALUES ('Nhân viên');

-- Insert data to table Knowledges 
INSERT INTO `Knowledges`(`Knowledge_Name`) VALUES ('Tiểu học');
INSERT INTO `Knowledges`(`Knowledge_Name`) VALUES ('Trung học cơ sở');
INSERT INTO `Knowledges`(`Knowledge_Name`) VALUES ('Trung học phổ thông');
INSERT INTO `Knowledges`(`Knowledge_Name`) VALUES ('Cao đẳng');
INSERT INTO `Knowledges`(`Knowledge_Name`) VALUES ('Đại học');

-- Insert data to table Foreign_Languages 
INSERT INTO `Foreign_Languages`(`Language_Name`) VALUES ('Bằng A');
INSERT INTO `Foreign_Languages`(`Language_Name`) VALUES ('Bằng B');
INSERT INTO `Foreign_Languages`(`Language_Name`) VALUES ('Bằng C');
INSERT INTO `Foreign_Languages`(`Language_Name`) VALUES ('TOEIC');
INSERT INTO `Foreign_Languages`(`Language_Name`) VALUES ('TOEFL');
INSERT INTO `Foreign_Languages`(`Language_Name`) VALUES ('IELTS');
INSERT INTO `Foreign_Languages`(`Language_Name`) VALUES ('N5');
INSERT INTO `Foreign_Languages`(`Language_Name`) VALUES ('N4');
INSERT INTO `Foreign_Languages`(`Language_Name`) VALUES ('N3');
INSERT INTO `Foreign_Languages`(`Language_Name`) VALUES ('N2');
INSERT INTO `Foreign_Languages`(`Language_Name`) VALUES ('N1');

-- Insert data to table Folks 
INSERT INTO `Folks`(`Folk_Name`) VALUES ('Kinh');
INSERT INTO `Folks`(`Folk_Name`) VALUES ('Hoa');
INSERT INTO `Folks`(`Folk_Name`) VALUES ('Mường');
INSERT INTO `Folks`(`Folk_Name`) VALUES ('Thái');
INSERT INTO `Folks`(`Folk_Name`) VALUES ('Tày');
INSERT INTO `Folks`(`Folk_Name`) VALUES ('Chăm');
INSERT INTO `Folks`(`Folk_Name`) VALUES ('Dao');
INSERT INTO `Folks`(`Folk_Name`) VALUES ('Ê Đê');

-- Insert data to table Nationalities 
INSERT INTO `Nationalities`(`Nationality_Name`) VALUES ('Mỹ');
INSERT INTO `Nationalities`(`Nationality_Name`) VALUES ('Việt Nam');
INSERT INTO `Nationalities`(`Nationality_Name`) VALUES ('Pháp');
INSERT INTO `Nationalities`(`Nationality_Name`) VALUES ('Đức');
INSERT INTO `Nationalities`(`Nationality_Name`) VALUES ('Ý');
INSERT INTO `Nationalities`(`Nationality_Name`) VALUES ('Nhật');
INSERT INTO `Nationalities`(`Nationality_Name`) VALUES ('Anh');
INSERT INTO `Nationalities`(`Nationality_Name`) VALUES ('Campuchia');
INSERT INTO `Nationalities`(`Nationality_Name`) VALUES ('Thái Lan');
INSERT INTO `Nationalities`(`Nationality_Name`) VALUES ('Singapore');

-- Insert data to table Certificates 
INSERT INTO `Certificates`(`Certificate_Name`) VALUES ('Bằng đại học');
INSERT INTO `Certificates`(`Certificate_Name`) VALUES ('Bằng cao đẳng');

-- Insert data to table IT_Certificates 
INSERT INTO `IT_Certificates`(`IT_Name`) VALUES ('Bằng A');
INSERT INTO `IT_Certificates`(`IT_Name`) VALUES ('Bằng B');
INSERT INTO `IT_Certificates`(`IT_Name`) VALUES ('Bằng C');
INSERT INTO `IT_Certificates`(`IT_Name`) VALUES ('Bằng MOS');
INSERT INTO `IT_Certificates`(`IT_Name`) VALUES ('Bằng IC3');

-- Insert data to table Religions 
INSERT INTO `Religions`(`Religion_Name`) VALUES ('Không');
INSERT INTO `Religions`(`Religion_Name`) VALUES ('Phật giáo');
INSERT INTO `Religions`(`Religion_Name`) VALUES ('Thiên chúa giáo');
INSERT INTO `Religions`(`Religion_Name`) VALUES ('Hồi giáo');
INSERT INTO `Religions`(`Religion_Name`) VALUES ('Ấn Độ giáo');
INSERT INTO `Religions`(`Religion_Name`) VALUES ('Đạo Cao Đài');
INSERT INTO `Religions`(`Religion_Name`) VALUES ('Đạo Do Thái');

-- Insert data to table Employees 
INSERT INTO `Employees`(`ID`, `Full_Name`, `Secret_Name`, `Gender`, `Marital_Status`, `Mobile_Number`, `Phone_Number`, `Email`, `Date_Of_Birth`, `Place_Of_Birth`, `Pronvince_ID`, `Identity_Number`, `Date_Of_ID_Registered`, `Place_Of_ID_Registered`, `Home_Town`, `Address`, `Temporary_Residence`, `Employee_Type_ID`, `Start_Working_Date`, `Department_ID`, `Job_ID`, `Position_ID`, `Basic_Salary`, `Coefficient`, `Salary`, `Allowance`, `Labour_Number`, `Date_Of_Labour_Registered`, `Place_Of_Labour_Registered`, `Bank_Account`, `Bank`, `Knowledge_ID`, `Foreign_Language_ID`, `Folk_ID`, `Certificate_ID`, `IT_Certificate_ID`, `Nationality_ID`, `Religion_ID`) 
                VALUES ('A01','Nguyễn Văn A','Không',FALSE,FALSE,'0123456789','0123456789','nguyenvana@email.com','1986-7-04','Long An',51,'123456789','2002-2-20','Long An','Long An','Long An','Long An',1,'2010-2-22',1,1,4,7000000,1.0,7000000,200000,'000','2010-2-22','Long An','123456789','VietinBank',1,1,1,1,2,1,1);
INSERT INTO `Employees`(`ID`, `Full_Name`, `Secret_Name`, `Gender`, `Marital_Status`, `Mobile_Number`, `Phone_Number`, `Email`, `Date_Of_Birth`, `Place_Of_Birth`, `Pronvince_ID`, `Identity_Number`, `Date_Of_ID_Registered`, `Place_Of_ID_Registered`, `Home_Town`, `Address`, `Temporary_Residence`, `Employee_Type_ID`, `Start_Working_Date`, `Department_ID`, `Job_ID`, `Position_ID`, `Basic_Salary`, `Coefficient`, `Salary`, `Allowance`, `Labour_Number`, `Date_Of_Labour_Registered`, `Place_Of_Labour_Registered`, `Bank_Account`, `Bank`, `Knowledge_ID`, `Foreign_Language_ID`, `Folk_ID`, `Certificate_ID`, `IT_Certificate_ID`, `Nationality_ID`, `Religion_ID`) 
                VALUES ('A02','Nguyễn Thị B','Không',TRUE,TRUE,'0123456789','0123456789','nguyenthic@email.com','1986-7-04','Long An',51,'123451234','2002-2-20','Long An','Long An','Long An','Long An',1,'2010-2-22',1,1,4,7000000,1.0,7000000,200000,'001','2010-2-22','Long An','123456789','VietinBank',1,1,1,1,2,1,1)