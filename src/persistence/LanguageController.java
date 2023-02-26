package persistence;

import java.io.IOException;
import java.util.Properties;

import utils.Utils;

public class LanguageController {
	
	private String pathFile;
	public static String language = "undefined";
	public static Properties languageProperties;
	
	public LanguageController(String pathFile) {
		this.pathFile=pathFile;
	}
	
	public void loadLenguage() throws IOException{
		Properties controllerProperties = Utils.generateProperties(pathFile);
		language = controllerProperties.getProperty("Language");
		languageProperties = Utils.generateProperties(language);
	}
	
	public void saveLanguage() throws IOException{
		Properties controllerProperties = Utils.generateProperties(pathFile);
		controllerProperties.setProperty("Language", language);
		Utils.saveProperties( controllerProperties, pathFile);
	}
}

