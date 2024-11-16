create database onlinelearningplatform;
use onlinelearningplatform;
	
CREATE TABLE User (                                                        
    userFirstName VARCHAR(50) NOT NULL,
    userLastName VARCHAR(50) NOT NULL,
    contactNumber VARCHAR(15),
    gmail VARCHAR(100) UNIQUE,
    location VARCHAR(100),
    languagesPreferred VARCHAR(100),
    gender VARCHAR(10),
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    PRIMARY KEY (username)
);

select * from User;





CREATE TABLE CourseDetails (
    courseName VARCHAR(50),
    courseId VARCHAR(10),
    courseDescription VARCHAR(255),
    instructorName VARCHAR(50),
    durationInHours INT,
    courseRating DOUBLE,
    numberOfStudentsEnrolled INT,
    courseLevel VARCHAR(20),
    courseLanguage VARCHAR(50),
    coursePrice DOUBLE,
    startDate DATE,
    endDate DATE
);
select * from  CourseDetails ;
SELECT * FROM CourseDetails WHERE durationInHours > 70;
SELECT * FROM CourseDetails WHERE durationInHours > 70 AND coursePrice > 100 AND courseLanguage = 'English';





CREATE TABLE  Transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    amount INT NOT NULL,
    confirmation VARCHAR(10) NOT NULL,
    balance INT NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
select *from Transactions;



CREATE TABLE QuizScores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    quiz_topic VARCHAR(50),
    score INT
);
select*from QuizScores;
CREATE VIEW UserQuizResults AS
SELECT 
    QuizScores.username,
    QuizScores.quiz_topic,
    QuizScores.score,
    CourseDetails.courseId,
    CourseDetails.instructorName,
    CourseDetails.durationInHours,
    CourseDetails.courseRating,
    CourseDetails.courseLevel,
    CourseDetails.courseLanguage,
    CourseDetails.coursePrice
FROM QuizScores
JOIN CourseDetails ON QuizScores.quiz_topic = CourseDetails.courseName
WHERE QuizScores.score >= 2;





CREATE TABLE CourseFeedback (
    id INT AUTO_INCREMENT PRIMARY KEY,
    courseName VARCHAR(50),
    overallRating INT,
    contentRating VARCHAR(20)
);
select *from  CourseFeedback;
SELECT 
    QuizScores.username,
    CourseFeedback.courseName,
    CourseFeedback.overallRating
FROM QuizScores
JOIN CourseFeedback ON QuizScores.quiz_topic = CourseFeedback.courseName
WHERE CourseFeedback.overallRating > 3;





