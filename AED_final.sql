CREATE database jarvis
go 
use jarvis
go 

-- Create the Property table
CREATE TABLE property_enlist (
    PropertyId INT IDENTITY(1,1) NOT NULL,
    PropertyName VARCHAR(255) NOT NULL,
    City VARCHAR(255),
    Street VARCHAR(255),
    State VARCHAR(255),
    ZipCode VARCHAR(255),
    ImgLink1 VARCHAR(255),
    ImgLink2 VARCHAR(255),
	Capacity VARCHAR(255),
	Status VARCHAR(255),
	PropertyOwner VARCHAR(255),
	Type VARCHAR(255),
	UserName VARCHAR(255),
    PRIMARY KEY (PropertyId)
);

-- Create the PropertyReview table
CREATE TABLE property_review (
    PropertyReviewId INT IDENTITY(1,1) NOT NULL,
    PropertyId INT NOT NULL,
    PropertyName VARCHAR(255),
	PropertyOwner VARCHAR(255),
    Approver VARCHAR(255),
    PRIMARY KEY (PropertyReviewId),
    FOREIGN KEY (PropertyId) REFERENCES property_enlist(PropertyId)
);

-- Create the SelectedTablesForEvent table
CREATE TABLE SELECTED_TABLES_FOR_EVENT (
    SRNO INT IDENTITY(1,1) NOT NULL,
	PropertyName VARCHAR(255), 
	Capacity VARCHAR(255),
	Location VARCHAR(255),
	EventAdmin VARCHAR(255),
    PropertyId INT NOT NULL,
	State VARCHAR(255),
    PRIMARY KEY (SRNO)
    -- FOREIGN KEY (PropertyId) REFERENCES property_enlist(PropertyId)
);

CREATE TABLE Events (
  EventId INT IDENTITY(1,1) NOT NULL,
  ProjectName VARCHAR(255) NOT NULL, 
  Location VARCHAR(255), 
  Capacity VARCHAR(255),
  EventName VARCHAR(255), 
  Description VARCHAR(255), 
  EventType VARCHAR(255), 
  DateFrom DATE, 
  Hosted VARCHAR(255),
  Timing VARCHAR(255),
  ImgLink1 VARBINARY(MAX),
  ImgLink2 VARBINARY(MAX),
  EventAdmin VARCHAR(255),
  Status VARCHAR(255),
  Contact VARCHAR(255),
  Role VARCHAR(255),
  PRIMARY KEY (EventId)
  -- FOREIGN KEY (PropertyId) REFERENCES property_enlist(PropertyId)
);

CREATE TABLE EVENTS_HOSTED (
  EventHostedId INT IDENTITY(1,1) NOT NULL,
  EventId INT NOT NULL,
  EventName VARCHAR(255),
  Organizer VARCHAR(255),
  Address VARCHAR(255),
  Food VARCHAR(255),
  Available_Ticket INT,
  CreatedBy VARCHAR(255),
  EventType VARCHAR(255),
  EventDate DATE,
  PRIMARY KEY (EventHostedId),
  FOREIGN KEY (EventId) REFERENCES EVENTS(EventId)
);


CREATE TABLE ATTENDEES (
   EmailId VARCHAR(255) NOT NULL UNIQUE,
   EventId INT NOT NULL,
   EventName VARCHAR(255),
   Confirmation VARCHAR(255),
   PropertyId INT NOT NULL,
   PRIMARY KEY (EmailId),
   -- FOREIGN KEY (PropertyId) REFERENCES property_enlist(PropertyId),
   -- FOREIGN KEY (EventId) REFERENCES EVENTS(EventId)
);

CREATE TABLE REVIEWED_EVENTS (
  ReviewEventsID INT IDENTITY(1,1) NOT NULL,
  EventHostedID INT NOT NULL,
  PropertyName VARCHAR(255),
  Location VARCHAR(255),
  Capacity INT,
  EventName VARCHAR(255),
  Description VARCHAR(255),
  EventType VARCHAR(255),
  DateOn DATE,
  HostedBy VARCHAR(255),
  Timing VARCHAR(255),
  Contact VARCHAR(255),
  ImgLink VARBINARY(MAX),
  EventAdmin VARCHAR(255),
  ApprovedBy VARCHAR(255),
  EventStatus VARCHAR(255),
  RType VARCHAR(255),
  PRIMARY KEY (ReviewEventsID),
  -- FOREIGN KEY (EventHostedId) REFERENCES EVENTS_HOSTED(EventHostedId)
);

CREATE TABLE USERS (
  Username VARCHAR(255) NOT NULL UNIQUE,
  EmailId VARCHAR(255) NOT NULL UNIQUE,
  FirstName VARCHAR(255),
  LastName VARCHAR(255),
  MobileNumber VARCHAR(255) DEFAULT '0000000000',
  Password VARCHAR(255),
  Role VARCHAR(255),
  PRIMARY KEY (Username),
  FOREIGN KEY (EmailId) REFERENCES ATTENDEES(EmailId) -- Assuming EventID is the correct foreign key
);

CREATE TABLE CATERER (
    CatererId INT NOT NULL IDENTITY(1,1),
    CatererName VARCHAR(255),
    Address VARCHAR(255),
    Phone VARCHAR(255),
    Ratings DECIMAL(10,2),
    PackageName VARCHAR(255),
	Price INT,
    CreatedBy VARCHAR(255),
    CreatedOn DATETIME,
    PRIMARY KEY (CatererId),
   -- FOREIGN KEY (EventHostedId) REFERENCES EVENTS_HOSTED(EventHostedId)
);

CREATE TABLE food_items (
  CatererId INT IDENTITY(1,1) NOT NULL,
  Type VARCHAR(255),
  DishName VARCHAR(255),
  Description VARCHAR(255),
  IsVegan VARCHAR(5);
  PRIMARY KEY (CatererId),
  -- FOREIGN KEY (CatererId) REFERENCES CATERER(CatererId)
);

