package language;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Configuracion.ConfigurationLoader;
import XML.XMLConfig;

public class LectorLanguage {
	
	private static String selectLanguagetoRead() {
		XMLConfig conf = ConfigurationLoader.getInstance();
		String[] languages = conf.getLenguages();
		for (int i = 0; i < languages.length; i++) {
			if( new File(languages[i].concat(conf.getLenguage_f_name())).exists() ) {
				return languages[i].concat(conf.getLenguage_f_name());
			}
		}
		return conf.getLenguage_def();
	}
	
	public static Language getLanguage() {
		Language language = new Language();
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(selectLanguagetoRead()));
			while((line = reader.readLine()) != null) {
				String variableName = line.split("=")[0], variableText = line.split("=")[1];
				switch (variableName) {
				case "frameTitle":
					language.setFrameTitle(variableText);
					break;

				case "labelUser":
					language.setLabelUser(variableText);
					break;
					
				case "fl_labelPsw":
					language.setFl_labelPsw(variableText);
					break;
										
				case "fl_opNoUser":
					language.setFl_opNoUser(variableText);
					break;
					
				case "fl_opYesUser":
					language.setFl_opYesUser(variableText);
					break;
					
				case "fl_opWrongUser":
					language.setFl_opWrongUser(variableText);
					break;
					
				case "fl_opTemporary":
					language.setFl_opTemporary(variableText);
					break;
					
				case "optionPaneTypeMessage":
					language.setOptionPaneTypeMessage(variableText);
					break;
					
				case "optionPaneAttention":
					language.setOptionPaneAttention(variableText);
					break;
					
				case "optionPaneError":
					language.setOptionPaneError(variableText);
					break;
					
				case "fd_labelTitle":
					language.setFd_labelTitle(variableText);
					break;
					
				case "fd_labelName":
					language.setFd_labelName(variableText);
					break;
					
				case "fd_labelSurname":
					language.setFd_labelSurname(variableText);
					break;
					
				case "fd_labelSecSurname":
					language.setFd_labelSecSurname(variableText);
					break;
					
				case "fd_labelDirection":
					language.setFd_labelDirection(variableText);
					break;
					
				case "d_labelEmail":
					language.setFd_labelEmail(variableText);
					break;
					
				case "fd_labelSex":
					language.setFd_labelSex(variableText);
					break;
					
				case "fd_radiobuttonMale":
					language.setFd_radiobuttonMale(variableText);
					break;
				
					
				case "fd_radiobuttonFemale":
					language.setFd_radiobuttonFemale(variableText);
					break;
				
					
				case "fd_radiobuttonNo":
					language.setFd_radiobuttonNo(variableText);
					break;
				
					
				case "fd_labelDateBirth":
					language.setFd_labelDateBirth(variableText);
					break;
				
					
				case "fd_opObligatotion":
					language.setFd_opObligatotion(variableText);
					break;
				
					
				case "fd_opSaved":
					language.setFd_opSaved(variableText);
					break;
				
					
				case "fd_opWrongEmail":
					language.setFd_opWrongEmail(variableText);
					break;
				
					
				case "fd_opExitNotSaving":
					language.setFd_opExitNotSaving(variableText);
					break;
				
					
				case "fd_buttonSave":
					language.setFd_buttonSave(variableText);
					break;
				
					
				case "buttonNext":
					language.setButtonNext(variableText);
					break;
				
					
				case "fc_labelTitle":
					language.setFc_labelTitle(variableText);
					break;
					
				case "fc_buttonPrevious":
					language.setFc_buttonPrevious(variableText);
					break;
					
				case "fs_lableTitle":
					language.setFs_lableTitle(variableText);
					break;
				
				case "fs_opChooseOne":
					language.setFs_opChooseOne(variableText);
					break;
					
				case "fe_lableTitle":
					language.setFe_lableTitle(variableText);
					break;
					
				case "fe_buttonBack":
					language.setFe_buttonBack(variableText);
					break;
					
				case "fe_buttonFinish":
					language.setFe_buttonFinish(variableText);
					break;
					
				case "fr_buttonStartAgain":
					language.setFr_buttonStartAgain(variableText);
					break;
					
				default:
					break;
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return language;
	}

}
