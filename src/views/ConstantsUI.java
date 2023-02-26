package views;

import java.awt.Color;
import java.awt.Font;

public class ConstantsUI {
	
	//Ventana Principal
	public static final String T_MAIN_WINDOW="Payroll_Subsidy";
	public static final String T_LABEL_TOTAL_VALUE_OF_CONSIGN="Total_Value_Consign";
	public static final String PATH_MAIN_ICON="/img/Main_Icon.png";
	public static final Font FONT_MAIN_WINDOW_LABELS = new Font("Gadugi", Font.PLAIN, 19);
	
	public static final Color COLOR_ORANGE = Color.decode("#F8C471");
	public static final Color COLOR_HEADER_TABLE = Color.decode("#282E33");
	public static final Color COLOR_CYAN = Color.decode("#EFFBFB");
	public static final Font FONT_HEADERS_TABLE = new Font("Century Gothic", Font.BOLD, 12);
	
	//Menu
	public static final String PATH_ADD_ICON="/img/Add_Icon.png";
	public static final String PATH_EDIT_ICON="/img/Edit_Icon.png";
	public static final String PATH_DELETE_ICON="/img/Delete_Icon.png";
	public static final String PATH_RELOAD_ICON="/img/Reload_Icon.png";
	public static final String PATH_SAVE_ICON="/img/Save_Icon.png";
	public static final String PATH_SPANISH_ICON="/img/Spanish_Icon.png";
	public static final String PATH_ENGLISH_ICON="/img/English_Icon.png";
	public static final String PATH_ITALY_ICON="/img/Italy_Icon.png";
	
	public static final String T_MENU_FILE = "File";
	public static final String T_MENU_DATA = "Data";
	public static final String T_MENU_ITEM_NEW_REQUEST = "New_Request";
	public static final String T_MENU_ITEM_ADD_REQUEST = "Add_Request";
	public static final String T_MENU_ITEM_EDIT_REQUEST = "Edit_Request";
	public static final String T_MENU_ITEM_DELETE_REQUEST = "Delete_Request";
	public static final String T_MENU_ITEM_RELOAD_REQUEST = "Reload_Request";
	public static final String T_MENU_ITEM_SAVE_REQUEST = "Save_Request";
	public static final String T_MENU_ITEM_CALCULATE_VALUE_DEPOSITED = "Calculate_Value";
	public static final String T_MENU_ITEM_EXIT = "Exit";
	public static final String T_MENU_ITEM_TYPE_REQUEST = "P_Type_Request";
	public static final String T_MENU_ITEM_TYPE_PERSON = "P_Type_Person";
	public static final String T_MENU_ITEM_TYPE_DOCUMENT = "P_Type_Document";
	public static final String T_MENU_ITEM_NUMBER_REQUEST_FOR_MONTH = "Request_For_Month";
	
	public static final Color COLOR_TBAR_BACKGROUND = Color.decode("#FFFFFF");
	
	//Dialogo de nueva Solicitud
	public static final String T_NUMBER_OF_REQUEST= "Add_Number_Request";
	public static final String T_TYPE_OF_PERSON= "Add_Type_Person";
	public static final String T_NAME_BUSSINES="Add_Name_Or_Company";
	public static final String T_TYPE_OF_DOCUMENT="Add_Type_ID";
	public static final String T_NUMBER_ID="Add_Number_ID";
	public static final String T_NUMBER_EMPLOYEES="Add_Number_Employees";
	public static final String T_DATE="Add_Date";
	public static final String T_ADD_REQUEST="Add_Create";
	public static final String T_CANCEL_REQUEST="Add_Cancel";
	public static final String T_SAVE_REQUEST="Add_Save";

	public static final Font FONT_COMPONENTS_DIALOG_COST = new Font("Century Gothic", Font.BOLD, 15);
	
	//Cabeceras de la tabla
	public static final String T_NUMBER_REGISTERED= "Number_Registered";
	public static final String T_REQUEST= "Request";
	public static final String T_NAME_OR_COMPANY= "Name_Or_Company_Name";
	public static final String T_NUMBER_IDENTIFICATION = "Number_ID";
	public static final String T_HEADER_NUMBER_EMPLOYEES= "Number_Employees";
	public static final String T_HEADER_DATE= "Date";
	public static final String T_VALUE_TO_CONSIGN= "Value_To_Consign";
	
	//Dialogos Porcentajes 
	public static final String T_HEADER_PERCENTAJE_= "Percentage";
	public static final String T_MAIN_PERCENTAJE_REQUEST= "Percentaje_Type_Request";
	public static final String T_HEADER_PERCENTAJE_REQUEST= "Type_Request";
	public static final String T_FIRTS_TIME= "First_Time";
	public static final String T_SECOND_TIME= "Second_Time";
	public static final String T_THIRD_TIME= "Third_Time";
	public static final String T_MAIN_PERCENTAJE_PERSON= "Percentaje_Type_Person";
	public static final String T_HEADER_PERCENTAJE_PERSON= "Type_Person";
	public static final String T_LEGAL_PERSON= "Legal_Person";
	public static final String T_NATURAL_PERSON= "Natural_Person";
	public static final String T_ENTITY= "No_Profit_Entity";
	public static final String T_TEMPORAL_UNION= "Temporary_Union";
	public static final String T_MAIN_PERCENTAJE_DOCUMENT= "Percentaje_Type_Document";
	public static final String T_HEADER_PERCENTAJE_DOCUMENT= "Type_Document";
	public static final String T_CITIZENSHIP= "Citizenship_Card";
	public static final String T_PASSPORT= "Passport";
	public static final String T_FOREIGNERS= "Foreigners_Card";
	public static final String T_MAIN_NUMBER_FOR_MONTH= "Number_Request_For_Month";
	public static final String T_HEADER_NUMBER_FOR_MONTH= "Month";
	public static final String T_APRIL= "April";
	public static final String T_MAY= "May";
	public static final String T_JUNE= "June";

	public static final Font FONT_DIALOGS = new Font("Century Gothic", Font.BOLD, 16);
	public static final Font FONT_DIALOGS_LABELS = new Font("Century Gothic", Font.BOLD, 16);
	
	//Error Messages
	public static final String T_INVALID_REQUEST= "Invalid_Request";
	public static final String T_INVALID_DATA= "Enter_All_Data";
	public static final String T_INVALID_ID_REQUEST= "Enter_Number_Registered";
	public static final String T_INVALID_DELETE_REQUEST= "Exception_Delete_Request";
	public static final String T_INVALID_EDIT_REQUEST= "Exception_Edit_Request";
	public static final String T_ERROR= "Error";
	public static final String T_EXIT= "Message_Exit";
	public static final String MESSAGE_EXIT_APP = "Exit_App?";
	public static final String T_NUMBER_INVALID_REQUEST= "Number_Invalid_Request";
	public static final String T_USER_INVALID = "User_Invalid";
	public static final String T_USER_INVALID_REQUEST= "User_Invalid_Request";
}
