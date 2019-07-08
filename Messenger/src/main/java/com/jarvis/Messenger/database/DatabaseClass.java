package com.jarvis.Messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.jarvis.Messenger.model.Message;
import com.jarvis.Messenger.model.Profile;

public class DatabaseClass {

	private static Map<Long,Message> messages = new HashMap<>();
	private static Map<String,Profile> profile = new HashMap<>();
	
	
	public static Map<Long,Message> getMessages(){
		return messages;
	}
		
	public static Map<String,Profile> getProfiles(){
			return profile;
		
	}


	}

