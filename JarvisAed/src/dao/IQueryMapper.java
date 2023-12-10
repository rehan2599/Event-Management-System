/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author anas
 */
public interface IQueryMapper {

    public final String FROM_EMAIL = "taxid68taxid68@gmail.com";
    public final String FROM_PASSWORD = "gkvrkifqzskqyjtd";
    public final String CLASSNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public final String URL = "jdbc:sqlserver://jarvis-aed.database.windows.net:1433;database=jarvis;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    public final String USERNAME = "jarvis-aed@jarvis-aed";
    public final String PASSWORD = "Kalbugrara@123";

    public final String INSERT_PROPERTY_OWNER = "INSERT INTO property_enlist(PropertyName, City, Street, State, ZipCode, Capacity, ImgLink1, ImgLink2, Status, PropertyOwner)"
            + "VALUES (?,?,?,?,?,?,?,?,?,?)";
    
    public final String INSERT_PROPERTY_REVIEW = "INSERT INTO property_review(PropertyId, PropertyOwner, PropertyName, Approver)"
            + "VALUES (?,?,?,?)";
    public final String INSERT_USERS = "INSERT into USERS values(?,?,?,?,?,?,?)";
    public final String INSERT_FOOD_ITEMS = "INSERT into food_items values (?,?,?,?)";
//    public final String INSERT_CATERER = "INSERT INTO CATERER (Package_Name, Price, Appetizer, Main_course, Dessert) VALUES (?,?,?,?,?) where CatererID = 3020";
    public final String INSERT_CATERER_2 = "INSERT INTO CATERER (CatererName, Address, Phone, Ratings, CreatedBy, CreatedOn) values (?,?,?,?,?,?)";
    public final String INSERT_ATTENDEES = "INSERT INTO ATTENDEES VALUES(?,?,?,?,?)";
    public final String INSERT_EVENTS_HOSTED = "INSERT INTO EVENTS_HOSTED VALUES (?,?,?,?,?,?,?,?,?)";

    public final String UPDATE_CATERER_2 = "UPDATE CATERER SET PackageName = ?, Price = ?, Menu = ? where CatererId = ?";
    public final String UPDATE_EVENTS_HOSTED = "UPDATE EVENTS_HOSTED SET Available_Ticket = ? where EventId = ?";
    public final String UPDATE_PROPERTY_STATUS = "UPDATE property_enlist SET Status=? WHERE PropertyId = ?";
    public final String UPDATE_CATERER = "UPDATE CATERER SET CatererName = ?, Address = ?, Phone = ? WHERE CatererId = ?";

    public final String SELECT_CREATED_PROPERTY = "SELECT * FROM property_enlist WHERE Status = ?";
    public final String SELECT_PROPERTY_ENLIST_2 = "SELECT * FROM property_enlist WHERE PropertyOwner = ?";
    public final String SELECT_PROPERTY_ENLIST = "SELECT * FROM property_enlist WHERE PropertyId = ?";
    public final String SELECT_PROPERTY_ENLIST_3 = "SELECT PropertyId, PropertyName, Street, City, ZipCode, Capacity, Status, PropertyOwner from property_enlist";
    public final String SELECT_PROPERTY_REVIEW = "SELECT PropertyId, PropertyName, PropertyOwner FROM property_review WHERE Approver = ?";

    public final String SELECT_FOOD_ITEMS = "SELECT * FROM FOOD_ITEMS";
    public final String SELECT_FOOD_ITEMS_2 = "SELECT * FROM FOOD_ITEMS where Type = ?";
    public final String SELECT_CATERER = "SELECT * FROM CATERER";
    public final String SELECT_CATERER_2 = "SELECT * FROM CATERER where CatererName = ?";
    public final String SELECT_CATERER_3 = "SELECT menu FROM CATERER where CatererName = ? and PackageName = ?";

    public final String SELECT_EVENTS_HOSTED = "SELECT * FROM EVENTS_HOSTED";
    public final String SELECT_EVENTS_HOSTED_2 = "SELECT food FROM EVENTS_HOSTED where EventId = ?";
    public final String SELECT_EVENTS_HOSTED_3 = "SELECT * FROM EVENTS_HOSTED WHERE ADDRESS LIKE  ? and EventType = ? and Available_Ticket<>0";// and Event_date = ? and available_ticket <> 0";
    public final String SELECT_EVENTS_HOSTED_4 = "SELECT Available_Ticket from EVENTS_HOSTED where EventId = ?";
    public final String SELECT_EVENTS_HOSTED_5 = "SELECT COUNT(EventId) as TotalEvents from EVENTS_HOSTED";
    public final String SELECT_EVENTS_HOSTED_6 = "select EventName from EVENTS_HOSTED where Available_Ticket = (select max(Available_Ticket) from EVENTS_HOSTED)";
    public final String SELECT_EVENTS_HOSTED_7 = "SELECT COUNT(EventId) as nilEvent from EVENTS_HOSTED where Available_Ticket = 0";
   
    
    public final String SELECT_CATERER_5 = "SELECT CatererName, PackageName, Price from Caterer where Price = (Select max(Price) from Caterer)";
    
    public final String SELECT_CATERER_4 = "SELECT COUNT(distinct CatererName ) as TotalCaterer from Caterer";
    public final String SELECT_PROPERTY_ENLIST_10 = "SELECT count(PropertyId) as totalProp from property_enlist where Status = 'Approved'";

    //updated from SELECT_EVENTS to SELECT_EVENTS_IMAGE
    public final String SELECT_EVENTS_IMAGE = "Select ImgLink1 from EVENTS where EventId = ?";
    public final String SELECT_ATTENDEES = "Select * from Attendees where EventId = ?";

    public final String DELETE_FOOD_ITEMS = "DELETE FROM FOOD_ITEMS where DishName = ?";
    public final String DELETE_CATERER = "DELETE FROM Caterer where CatererId = ?";

    public static String UPDATE_EVENT_STATUS = "UPDATE EVENTS SET Status = ? WHERE EventId = ?";
    public static String UPDATE_EVENT_REVIEWER_STATUS = "UPDATE REVIEWED_EVENTS SET EventStatus = ? WHERE EventHostedId = ?";
    
    public static String INSERT_EVENT_REVIEW = "INSERT INTO REVIEWED_EVENTS (PropertyName, Location, Capacity, EventName, Description,\n"
            + "	EventType, DateOn, HostedBy, Timing, Contact, ImgLink ,EventAdmin, ApprovedBy, EventHostedID, EventStatus, RType)"
            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
//public static String INSERT_EVENT_REVIEW = "INSERT INTO REVIEWED_EVENTS (Property_Name, Location, Capacity, EventName, Description,\n"
//      + "	EventType, DateOn, HostedBy, Timing, Contact, EventAdmin, ApprovedBy, EventId, EventStatus, rType)"
//    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public static String FETCH_LOCATIONS = "SELECT DISTINCT City FROM property_enlist WHERE City <> '' ORDER BY City ASC";
    public static String FETCH_TYPE = "SELECT DISTINCT Type FROM property_enlist WHERE Type <> '' ORDER BY Type ASC";
    public static String FETCH_CAPACITY = "SELECT DISTINCT Capacity FROM property_enlist WHERE Capacity <> '' ORDER BY Capacity ASC";

    public static String INSERT_SELECTED_PLACES_FOR_EVENT = "INSERT INTO SELECTED_TABLES_FOR_EVENT VALUES(?,?,?,?,?,?)";
    public static String REMOVE_SELECTED_PLACES_FOR_EVENT = "DELETE FROM SELECTED_TABLES_FOR_EVENT WHERE EventAdmin = ?";

    public static String SELECT_EVENTS = "SELECT * FROM EVENTS WHERE EventAdmin = ?";
    
    public static String SELECT_PERSONAL_EVENTS = "SELECT * FROM personal_events WHERE EventAdmin = ?";
    
    
    public static String SELECT_EVENTS_1 = "SELECT * FROM EVENTS";
    public static String SELECT_EVENTS_2 = "SELECT * FROM Events WHERE Role LIKE ?";
    public static String SELECT_EVENTS_3 = "SELECT * FROM personal_events WHERE Role LIKE ?";
// "SELECT * FROM EVENTS WHERE Role = ?";
    public static String SELECT_REVEIWER_EVENTS = "SELECT * FROM REVIEWED_EVENTS WHERE ApprovedBy = ? ";
    public static String SELECT_REVEIWER_EVENTS_1 = "SELECT * FROM REVIEWED_EVENTS WHERE ApprovedBy = ? AND EventStatus = 'Created'";

    public String SELECT_REVIEWED_EVENTS_2 = "SELECT EventHostedId, EventName, PropertyName, Location, EventType, HOSTEDBY, EVENTADMIN, DATEON FROM REVIEWED_EVENTS WHERE EVENTADMIN = ? AND EVENTTYPE IN (?,?,?,?,?)";

    public static String CREATE_EVENT = "INSERT INTO EVENTS VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    public static String CREATE_PERSONAL_EVENTS = "INSERT INTO personal_events VALUES (?,?,?,?,?,?,?,?,?)";
    
    public static String DELETE_EVENT = "DELETE FROM EVENTS WHERE EventId = ?";
    public static String DELETE_PERSONAL_EVENT = "DELETE FROM personal_events WHERE PersonalEventId = ?";

    public final String SELECT_CREATED_PROPERTY_FOR_EVENT = "SELECT * FROM property_enlist WHERE Status = ? "
            + "AND PropertyId NOT IN (SELECT PropertyId FROM SELECTED_TABLES_FOR_EVENT)";
    public final String SELECT_SHORTLISTED_PROPERTY = "SELECT * FROM SELECTED_TABLES_FOR_EVENT WHERE EventAdmin = ? ";
//            + "AND property_id NOT IN (SELECT propertyid FROM SELECTED_TABLES_FOR_EVENT)";

//    public final String SELECT_USERS = "SELECT First_name, role, email_id FROM users where email_id =? and password = ?";
//    public final String SELECT_USERS_2 = "SELECT email_id from users where email_id = ?";
    
    // new queries
    public final String SELECT_USERS = "SELECT FirstName, Role, EmailId FROM USERS where EmailId =? and Password = ?";
    public final String SELECT_USERS_2 = "SELECT EmailId from USERS where EmailId = ?";

}
